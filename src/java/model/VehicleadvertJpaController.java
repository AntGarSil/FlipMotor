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
import Datastore.Entities.Administrato;
import Datastore.Entities.Registeredclient;
import Datastore.Entities.Fav;
import java.util.ArrayList;
import java.util.Collection;
import Datastore.Entities.Vehicleadvert;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author root
 */
public class VehicleadvertJpaController implements Serializable {

    public VehicleadvertJpaController() {
    }

    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehicleadvert vehicleadvert) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (vehicleadvert.getFavCollection() == null) {
            vehicleadvert.setFavCollection(new ArrayList<Fav>());
        }
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Administrato adminID = vehicleadvert.getAdminID();
            if (adminID != null) {
                adminID = em.getReference(adminID.getClass(), adminID.getAdminID());
                vehicleadvert.setAdminID(adminID);
            }
            Registeredclient clientID = vehicleadvert.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getClientID());
                vehicleadvert.setClientID(clientID);
            }
            Collection<Fav> attachedFavCollection = new ArrayList<Fav>();
            for (Fav favCollectionFavToAttach : vehicleadvert.getFavCollection()) {
                favCollectionFavToAttach = em.getReference(favCollectionFavToAttach.getClass(), favCollectionFavToAttach.getId());
                attachedFavCollection.add(favCollectionFavToAttach);
            }
            vehicleadvert.setFavCollection(attachedFavCollection);
            em.persist(vehicleadvert);
            if (adminID != null) {
                adminID.getVehicleadvertCollection().add(vehicleadvert);
                adminID = em.merge(adminID);
            }
            if (clientID != null) {
                clientID.getVehicleadvertCollection().add(vehicleadvert);
                clientID = em.merge(clientID);
            }
            for (Fav favCollectionFav : vehicleadvert.getFavCollection()) {
                Vehicleadvert oldCodeOfFavCollectionFav = favCollectionFav.getCode();
                favCollectionFav.setCode(vehicleadvert);
                favCollectionFav = em.merge(favCollectionFav);
                if (oldCodeOfFavCollectionFav != null) {
                    oldCodeOfFavCollectionFav.getFavCollection().remove(favCollectionFav);
                    oldCodeOfFavCollectionFav = em.merge(oldCodeOfFavCollectionFav);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findVehicleadvert(vehicleadvert.getCode()) != null) {
                throw new PreexistingEntityException("Vehicleadvert " + vehicleadvert + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehicleadvert vehicleadvert) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Vehicleadvert persistentVehicleadvert = em.find(Vehicleadvert.class, vehicleadvert.getCode());
            Administrato adminIDOld = persistentVehicleadvert.getAdminID();
            Administrato adminIDNew = vehicleadvert.getAdminID();
            Registeredclient clientIDOld = persistentVehicleadvert.getClientID();
            Registeredclient clientIDNew = vehicleadvert.getClientID();
            Collection<Fav> favCollectionOld = persistentVehicleadvert.getFavCollection();
            Collection<Fav> favCollectionNew = vehicleadvert.getFavCollection();
            List<String> illegalOrphanMessages = null;
            for (Fav favCollectionOldFav : favCollectionOld) {
                if (!favCollectionNew.contains(favCollectionOldFav)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Fav " + favCollectionOldFav + " since its code field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (adminIDNew != null) {
                adminIDNew = em.getReference(adminIDNew.getClass(), adminIDNew.getAdminID());
                vehicleadvert.setAdminID(adminIDNew);
            }
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getClientID());
                vehicleadvert.setClientID(clientIDNew);
            }
            Collection<Fav> attachedFavCollectionNew = new ArrayList<Fav>();
            for (Fav favCollectionNewFavToAttach : favCollectionNew) {
                favCollectionNewFavToAttach = em.getReference(favCollectionNewFavToAttach.getClass(), favCollectionNewFavToAttach.getId());
                attachedFavCollectionNew.add(favCollectionNewFavToAttach);
            }
            favCollectionNew = attachedFavCollectionNew;
            vehicleadvert.setFavCollection(favCollectionNew);
            vehicleadvert = em.merge(vehicleadvert);
            if (adminIDOld != null && !adminIDOld.equals(adminIDNew)) {
                adminIDOld.getVehicleadvertCollection().remove(vehicleadvert);
                adminIDOld = em.merge(adminIDOld);
            }
            if (adminIDNew != null && !adminIDNew.equals(adminIDOld)) {
                adminIDNew.getVehicleadvertCollection().add(vehicleadvert);
                adminIDNew = em.merge(adminIDNew);
            }
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getVehicleadvertCollection().remove(vehicleadvert);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getVehicleadvertCollection().add(vehicleadvert);
                clientIDNew = em.merge(clientIDNew);
            }
            for (Fav favCollectionNewFav : favCollectionNew) {
                if (!favCollectionOld.contains(favCollectionNewFav)) {
                    Vehicleadvert oldCodeOfFavCollectionNewFav = favCollectionNewFav.getCode();
                    favCollectionNewFav.setCode(vehicleadvert);
                    favCollectionNewFav = em.merge(favCollectionNewFav);
                    if (oldCodeOfFavCollectionNewFav != null && !oldCodeOfFavCollectionNewFav.equals(vehicleadvert)) {
                        oldCodeOfFavCollectionNewFav.getFavCollection().remove(favCollectionNewFav);
                        oldCodeOfFavCollectionNewFav = em.merge(oldCodeOfFavCollectionNewFav);
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
                Integer id = vehicleadvert.getCode();
                if (findVehicleadvert(id) == null) {
                    throw new NonexistentEntityException("The vehicleadvert with id " + id + " no longer exists.");
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
            Vehicleadvert vehicleadvert;
            try {
                vehicleadvert = em.getReference(Vehicleadvert.class, id);
                vehicleadvert.getCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehicleadvert with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Fav> favCollectionOrphanCheck = vehicleadvert.getFavCollection();
            for (Fav favCollectionOrphanCheckFav : favCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vehicleadvert (" + vehicleadvert + ") cannot be destroyed since the Fav " + favCollectionOrphanCheckFav + " in its favCollection field has a non-nullable code field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Administrato adminID = vehicleadvert.getAdminID();
            if (adminID != null) {
                adminID.getVehicleadvertCollection().remove(vehicleadvert);
                adminID = em.merge(adminID);
            }
            Registeredclient clientID = vehicleadvert.getClientID();
            if (clientID != null) {
                clientID.getVehicleadvertCollection().remove(vehicleadvert);
                clientID = em.merge(clientID);
            }
            em.remove(vehicleadvert);
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

    public List<Vehicleadvert> findVehicleadvertEntities() {
        return findVehicleadvertEntities(true, -1, -1);
    }

    public List<Vehicleadvert> findVehicleadvertEntities(int maxResults, int firstResult) {
        return findVehicleadvertEntities(false, maxResults, firstResult);
    }

    private List<Vehicleadvert> findVehicleadvertEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehicleadvert.class));
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

    public Vehicleadvert findVehicleadvert(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehicleadvert.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehicleadvertCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehicleadvert> rt = cq.from(Vehicleadvert.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
