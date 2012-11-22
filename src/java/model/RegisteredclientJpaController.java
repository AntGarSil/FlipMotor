/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.exceptions.IllegalOrphanException;
import model.exceptions.NonexistentEntityException;
import model.exceptions.PreexistingEntityException;
import model.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import Datastore.Entities.Fav;
import java.util.ArrayList;
import java.util.Collection;
import Datastore.Entities.Registeredclient;
import Datastore.Entities.Vehicleadvert;
import Datastore.Entities.Businessadvert;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author root
 */
public class RegisteredclientJpaController implements Serializable {

    public RegisteredclientJpaController() {

    }

    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registeredclient registeredclient) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (registeredclient.getFavCollection() == null) {
            registeredclient.setFavCollection(new ArrayList<Fav>());
        }
        if (registeredclient.getVehicleadvertCollection() == null) {
            registeredclient.setVehicleadvertCollection(new ArrayList<Vehicleadvert>());
        }
        if (registeredclient.getBusinessadvertCollection() == null) {
            registeredclient.setBusinessadvertCollection(new ArrayList<Businessadvert>());
        }
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Fav> attachedFavCollection = new ArrayList<Fav>();
            for (Fav favCollectionFavToAttach : registeredclient.getFavCollection()) {
                favCollectionFavToAttach = em.getReference(favCollectionFavToAttach.getClass(), favCollectionFavToAttach.getId());
                attachedFavCollection.add(favCollectionFavToAttach);
            }
            registeredclient.setFavCollection(attachedFavCollection);
            Collection<Vehicleadvert> attachedVehicleadvertCollection = new ArrayList<Vehicleadvert>();
            for (Vehicleadvert vehicleadvertCollectionVehicleadvertToAttach : registeredclient.getVehicleadvertCollection()) {
                vehicleadvertCollectionVehicleadvertToAttach = em.getReference(vehicleadvertCollectionVehicleadvertToAttach.getClass(), vehicleadvertCollectionVehicleadvertToAttach.getCode());
                attachedVehicleadvertCollection.add(vehicleadvertCollectionVehicleadvertToAttach);
            }
            registeredclient.setVehicleadvertCollection(attachedVehicleadvertCollection);
            Collection<Businessadvert> attachedBusinessadvertCollection = new ArrayList<Businessadvert>();
            for (Businessadvert businessadvertCollectionBusinessadvertToAttach : registeredclient.getBusinessadvertCollection()) {
                businessadvertCollectionBusinessadvertToAttach = em.getReference(businessadvertCollectionBusinessadvertToAttach.getClass(), businessadvertCollectionBusinessadvertToAttach.getBusinessadvertPK());
                attachedBusinessadvertCollection.add(businessadvertCollectionBusinessadvertToAttach);
            }
            registeredclient.setBusinessadvertCollection(attachedBusinessadvertCollection);
            em.persist(registeredclient);
            for (Fav favCollectionFav : registeredclient.getFavCollection()) {
                Registeredclient oldClientIDOfFavCollectionFav = favCollectionFav.getClientID();
                favCollectionFav.setClientID(registeredclient);
                favCollectionFav = em.merge(favCollectionFav);
                if (oldClientIDOfFavCollectionFav != null) {
                    oldClientIDOfFavCollectionFav.getFavCollection().remove(favCollectionFav);
                    oldClientIDOfFavCollectionFav = em.merge(oldClientIDOfFavCollectionFav);
                }
            }
            for (Vehicleadvert vehicleadvertCollectionVehicleadvert : registeredclient.getVehicleadvertCollection()) {
                Registeredclient oldClientIDOfVehicleadvertCollectionVehicleadvert = vehicleadvertCollectionVehicleadvert.getClientID();
                vehicleadvertCollectionVehicleadvert.setClientID(registeredclient);
                vehicleadvertCollectionVehicleadvert = em.merge(vehicleadvertCollectionVehicleadvert);
                if (oldClientIDOfVehicleadvertCollectionVehicleadvert != null) {
                    oldClientIDOfVehicleadvertCollectionVehicleadvert.getVehicleadvertCollection().remove(vehicleadvertCollectionVehicleadvert);
                    oldClientIDOfVehicleadvertCollectionVehicleadvert = em.merge(oldClientIDOfVehicleadvertCollectionVehicleadvert);
                }
            }
            for (Businessadvert businessadvertCollectionBusinessadvert : registeredclient.getBusinessadvertCollection()) {
                Registeredclient oldRegisteredclientOfBusinessadvertCollectionBusinessadvert = businessadvertCollectionBusinessadvert.getRegisteredclient();
                businessadvertCollectionBusinessadvert.setRegisteredclient(registeredclient);
                businessadvertCollectionBusinessadvert = em.merge(businessadvertCollectionBusinessadvert);
                if (oldRegisteredclientOfBusinessadvertCollectionBusinessadvert != null) {
                    oldRegisteredclientOfBusinessadvertCollectionBusinessadvert.getBusinessadvertCollection().remove(businessadvertCollectionBusinessadvert);
                    oldRegisteredclientOfBusinessadvertCollectionBusinessadvert = em.merge(oldRegisteredclientOfBusinessadvertCollectionBusinessadvert);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findRegisteredclient(registeredclient.getClientID()) != null) {
                throw new PreexistingEntityException("Registeredclient " + registeredclient + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registeredclient registeredclient) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Registeredclient persistentRegisteredclient = em.find(Registeredclient.class, registeredclient.getClientID());
            Collection<Fav> favCollectionOld = persistentRegisteredclient.getFavCollection();
            Collection<Fav> favCollectionNew = registeredclient.getFavCollection();
            Collection<Vehicleadvert> vehicleadvertCollectionOld = persistentRegisteredclient.getVehicleadvertCollection();
            Collection<Vehicleadvert> vehicleadvertCollectionNew = registeredclient.getVehicleadvertCollection();
            Collection<Businessadvert> businessadvertCollectionOld = persistentRegisteredclient.getBusinessadvertCollection();
            Collection<Businessadvert> businessadvertCollectionNew = registeredclient.getBusinessadvertCollection();
            List<String> illegalOrphanMessages = null;
            for (Fav favCollectionOldFav : favCollectionOld) {
                if (!favCollectionNew.contains(favCollectionOldFav)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Fav " + favCollectionOldFav + " since its clientID field is not nullable.");
                }
            }
            for (Vehicleadvert vehicleadvertCollectionOldVehicleadvert : vehicleadvertCollectionOld) {
                if (!vehicleadvertCollectionNew.contains(vehicleadvertCollectionOldVehicleadvert)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vehicleadvert " + vehicleadvertCollectionOldVehicleadvert + " since its clientID field is not nullable.");
                }
            }
            for (Businessadvert businessadvertCollectionOldBusinessadvert : businessadvertCollectionOld) {
                if (!businessadvertCollectionNew.contains(businessadvertCollectionOldBusinessadvert)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Businessadvert " + businessadvertCollectionOldBusinessadvert + " since its registeredclient field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Fav> attachedFavCollectionNew = new ArrayList<Fav>();
            for (Fav favCollectionNewFavToAttach : favCollectionNew) {
                favCollectionNewFavToAttach = em.getReference(favCollectionNewFavToAttach.getClass(), favCollectionNewFavToAttach.getId());
                attachedFavCollectionNew.add(favCollectionNewFavToAttach);
            }
            favCollectionNew = attachedFavCollectionNew;
            registeredclient.setFavCollection(favCollectionNew);
            Collection<Vehicleadvert> attachedVehicleadvertCollectionNew = new ArrayList<Vehicleadvert>();
            for (Vehicleadvert vehicleadvertCollectionNewVehicleadvertToAttach : vehicleadvertCollectionNew) {
                vehicleadvertCollectionNewVehicleadvertToAttach = em.getReference(vehicleadvertCollectionNewVehicleadvertToAttach.getClass(), vehicleadvertCollectionNewVehicleadvertToAttach.getCode());
                attachedVehicleadvertCollectionNew.add(vehicleadvertCollectionNewVehicleadvertToAttach);
            }
            vehicleadvertCollectionNew = attachedVehicleadvertCollectionNew;
            registeredclient.setVehicleadvertCollection(vehicleadvertCollectionNew);
            Collection<Businessadvert> attachedBusinessadvertCollectionNew = new ArrayList<Businessadvert>();
            for (Businessadvert businessadvertCollectionNewBusinessadvertToAttach : businessadvertCollectionNew) {
                businessadvertCollectionNewBusinessadvertToAttach = em.getReference(businessadvertCollectionNewBusinessadvertToAttach.getClass(), businessadvertCollectionNewBusinessadvertToAttach.getBusinessadvertPK());
                attachedBusinessadvertCollectionNew.add(businessadvertCollectionNewBusinessadvertToAttach);
            }
            businessadvertCollectionNew = attachedBusinessadvertCollectionNew;
            registeredclient.setBusinessadvertCollection(businessadvertCollectionNew);
            registeredclient = em.merge(registeredclient);
            for (Fav favCollectionNewFav : favCollectionNew) {
                if (!favCollectionOld.contains(favCollectionNewFav)) {
                    Registeredclient oldClientIDOfFavCollectionNewFav = favCollectionNewFav.getClientID();
                    favCollectionNewFav.setClientID(registeredclient);
                    favCollectionNewFav = em.merge(favCollectionNewFav);
                    if (oldClientIDOfFavCollectionNewFav != null && !oldClientIDOfFavCollectionNewFav.equals(registeredclient)) {
                        oldClientIDOfFavCollectionNewFav.getFavCollection().remove(favCollectionNewFav);
                        oldClientIDOfFavCollectionNewFav = em.merge(oldClientIDOfFavCollectionNewFav);
                    }
                }
            }
            for (Vehicleadvert vehicleadvertCollectionNewVehicleadvert : vehicleadvertCollectionNew) {
                if (!vehicleadvertCollectionOld.contains(vehicleadvertCollectionNewVehicleadvert)) {
                    Registeredclient oldClientIDOfVehicleadvertCollectionNewVehicleadvert = vehicleadvertCollectionNewVehicleadvert.getClientID();
                    vehicleadvertCollectionNewVehicleadvert.setClientID(registeredclient);
                    vehicleadvertCollectionNewVehicleadvert = em.merge(vehicleadvertCollectionNewVehicleadvert);
                    if (oldClientIDOfVehicleadvertCollectionNewVehicleadvert != null && !oldClientIDOfVehicleadvertCollectionNewVehicleadvert.equals(registeredclient)) {
                        oldClientIDOfVehicleadvertCollectionNewVehicleadvert.getVehicleadvertCollection().remove(vehicleadvertCollectionNewVehicleadvert);
                        oldClientIDOfVehicleadvertCollectionNewVehicleadvert = em.merge(oldClientIDOfVehicleadvertCollectionNewVehicleadvert);
                    }
                }
            }
            for (Businessadvert businessadvertCollectionNewBusinessadvert : businessadvertCollectionNew) {
                if (!businessadvertCollectionOld.contains(businessadvertCollectionNewBusinessadvert)) {
                    Registeredclient oldRegisteredclientOfBusinessadvertCollectionNewBusinessadvert = businessadvertCollectionNewBusinessadvert.getRegisteredclient();
                    businessadvertCollectionNewBusinessadvert.setRegisteredclient(registeredclient);
                    businessadvertCollectionNewBusinessadvert = em.merge(businessadvertCollectionNewBusinessadvert);
                    if (oldRegisteredclientOfBusinessadvertCollectionNewBusinessadvert != null && !oldRegisteredclientOfBusinessadvertCollectionNewBusinessadvert.equals(registeredclient)) {
                        oldRegisteredclientOfBusinessadvertCollectionNewBusinessadvert.getBusinessadvertCollection().remove(businessadvertCollectionNewBusinessadvert);
                        oldRegisteredclientOfBusinessadvertCollectionNewBusinessadvert = em.merge(oldRegisteredclientOfBusinessadvertCollectionNewBusinessadvert);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registeredclient.getClientID();
                if (findRegisteredclient(id) == null) {
                    throw new NonexistentEntityException("The registeredclient with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Registeredclient registeredclient;
            try {
                registeredclient = em.getReference(Registeredclient.class, id);
                registeredclient.getClientID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registeredclient with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Fav> favCollectionOrphanCheck = registeredclient.getFavCollection();
            for (Fav favCollectionOrphanCheckFav : favCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Registeredclient (" + registeredclient + ") cannot be destroyed since the Fav " + favCollectionOrphanCheckFav + " in its favCollection field has a non-nullable clientID field.");
            }
            Collection<Vehicleadvert> vehicleadvertCollectionOrphanCheck = registeredclient.getVehicleadvertCollection();
            for (Vehicleadvert vehicleadvertCollectionOrphanCheckVehicleadvert : vehicleadvertCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Registeredclient (" + registeredclient + ") cannot be destroyed since the Vehicleadvert " + vehicleadvertCollectionOrphanCheckVehicleadvert + " in its vehicleadvertCollection field has a non-nullable clientID field.");
            }
            Collection<Businessadvert> businessadvertCollectionOrphanCheck = registeredclient.getBusinessadvertCollection();
            for (Businessadvert businessadvertCollectionOrphanCheckBusinessadvert : businessadvertCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Registeredclient (" + registeredclient + ") cannot be destroyed since the Businessadvert " + businessadvertCollectionOrphanCheckBusinessadvert + " in its businessadvertCollection field has a non-nullable registeredclient field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(registeredclient);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registeredclient> findRegisteredclientEntities() {
        return findRegisteredclientEntities(true, -1, -1);
    }

    public List<Registeredclient> findRegisteredclientEntities(int maxResults, int firstResult) {
        return findRegisteredclientEntities(false, maxResults, firstResult);
    }

    private List<Registeredclient> findRegisteredclientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registeredclient.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Registeredclient findRegisteredclient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registeredclient.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegisteredclientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registeredclient> rt = cq.from(Registeredclient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
