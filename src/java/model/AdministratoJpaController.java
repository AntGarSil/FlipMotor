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
import Datastore.Entities.Vehicleadvert;
import java.util.ArrayList;
import java.util.Collection;
import Datastore.Entities.Businessadvert;
import Datastore.Entities.Offer;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author root
 */
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class AdministratoJpaController implements Serializable {

    public AdministratoJpaController() {

    }
    
    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrato administrato) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (administrato.getVehicleadvertCollection() == null) {
            administrato.setVehicleadvertCollection(new ArrayList<Vehicleadvert>());
        }
        if (administrato.getBusinessadvertCollection() == null) {
            administrato.setBusinessadvertCollection(new ArrayList<Businessadvert>());
        }
        if (administrato.getOfferCollection() == null) {
            administrato.setOfferCollection(new ArrayList<Offer>());
        }
        
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Vehicleadvert> attachedVehicleadvertCollection = new ArrayList<Vehicleadvert>();
            for (Vehicleadvert vehicleadvertCollectionVehicleadvertToAttach : administrato.getVehicleadvertCollection()) {
                vehicleadvertCollectionVehicleadvertToAttach = em.getReference(vehicleadvertCollectionVehicleadvertToAttach.getClass(), vehicleadvertCollectionVehicleadvertToAttach.getCode());
                attachedVehicleadvertCollection.add(vehicleadvertCollectionVehicleadvertToAttach);
            }
            administrato.setVehicleadvertCollection(attachedVehicleadvertCollection);
            Collection<Businessadvert> attachedBusinessadvertCollection = new ArrayList<Businessadvert>();
            for (Businessadvert businessadvertCollectionBusinessadvertToAttach : administrato.getBusinessadvertCollection()) {
                businessadvertCollectionBusinessadvertToAttach = em.getReference(businessadvertCollectionBusinessadvertToAttach.getClass(), businessadvertCollectionBusinessadvertToAttach.getBusinessadvertPK());
                attachedBusinessadvertCollection.add(businessadvertCollectionBusinessadvertToAttach);
            }
            administrato.setBusinessadvertCollection(attachedBusinessadvertCollection);
            Collection<Offer> attachedOfferCollection = new ArrayList<Offer>();
            for (Offer offerCollectionOfferToAttach : administrato.getOfferCollection()) {
                offerCollectionOfferToAttach = em.getReference(offerCollectionOfferToAttach.getClass(), offerCollectionOfferToAttach.getNam());
                attachedOfferCollection.add(offerCollectionOfferToAttach);
            }
            administrato.setOfferCollection(attachedOfferCollection);
            em.persist(administrato);
            for (Vehicleadvert vehicleadvertCollectionVehicleadvert : administrato.getVehicleadvertCollection()) {
                Administrato oldAdminIDOfVehicleadvertCollectionVehicleadvert = vehicleadvertCollectionVehicleadvert.getAdminID();
                vehicleadvertCollectionVehicleadvert.setAdminID(administrato);
                vehicleadvertCollectionVehicleadvert = em.merge(vehicleadvertCollectionVehicleadvert);
                if (oldAdminIDOfVehicleadvertCollectionVehicleadvert != null) {
                    oldAdminIDOfVehicleadvertCollectionVehicleadvert.getVehicleadvertCollection().remove(vehicleadvertCollectionVehicleadvert);
                    oldAdminIDOfVehicleadvertCollectionVehicleadvert = em.merge(oldAdminIDOfVehicleadvertCollectionVehicleadvert);
                }
            }
            for (Businessadvert businessadvertCollectionBusinessadvert : administrato.getBusinessadvertCollection()) {
                Administrato oldAdminIDOfBusinessadvertCollectionBusinessadvert = businessadvertCollectionBusinessadvert.getAdminID();
                businessadvertCollectionBusinessadvert.setAdminID(administrato);
                businessadvertCollectionBusinessadvert = em.merge(businessadvertCollectionBusinessadvert);
                if (oldAdminIDOfBusinessadvertCollectionBusinessadvert != null) {
                    oldAdminIDOfBusinessadvertCollectionBusinessadvert.getBusinessadvertCollection().remove(businessadvertCollectionBusinessadvert);
                    oldAdminIDOfBusinessadvertCollectionBusinessadvert = em.merge(oldAdminIDOfBusinessadvertCollectionBusinessadvert);
                }
            }
            for (Offer offerCollectionOffer : administrato.getOfferCollection()) {
                Administrato oldAdminIDOfOfferCollectionOffer = offerCollectionOffer.getAdminID();
                offerCollectionOffer.setAdminID(administrato);
                offerCollectionOffer = em.merge(offerCollectionOffer);
                if (oldAdminIDOfOfferCollectionOffer != null) {
                    oldAdminIDOfOfferCollectionOffer.getOfferCollection().remove(offerCollectionOffer);
                    oldAdminIDOfOfferCollectionOffer = em.merge(oldAdminIDOfOfferCollectionOffer);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAdministrato(administrato.getAdminID()) != null) {
                throw new PreexistingEntityException("Administrato " + administrato + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrato administrato) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            Administrato persistentAdministrato = em.find(Administrato.class, administrato.getAdminID());
            Collection<Vehicleadvert> vehicleadvertCollectionOld = persistentAdministrato.getVehicleadvertCollection();
            Collection<Vehicleadvert> vehicleadvertCollectionNew = administrato.getVehicleadvertCollection();
            Collection<Businessadvert> businessadvertCollectionOld = persistentAdministrato.getBusinessadvertCollection();
            Collection<Businessadvert> businessadvertCollectionNew = administrato.getBusinessadvertCollection();
            Collection<Offer> offerCollectionOld = persistentAdministrato.getOfferCollection();
            Collection<Offer> offerCollectionNew = administrato.getOfferCollection();
            List<String> illegalOrphanMessages = null;
            for (Vehicleadvert vehicleadvertCollectionOldVehicleadvert : vehicleadvertCollectionOld) {
                if (!vehicleadvertCollectionNew.contains(vehicleadvertCollectionOldVehicleadvert)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vehicleadvert " + vehicleadvertCollectionOldVehicleadvert + " since its adminID field is not nullable.");
                }
            }
            for (Businessadvert businessadvertCollectionOldBusinessadvert : businessadvertCollectionOld) {
                if (!businessadvertCollectionNew.contains(businessadvertCollectionOldBusinessadvert)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Businessadvert " + businessadvertCollectionOldBusinessadvert + " since its adminID field is not nullable.");
                }
            }
            for (Offer offerCollectionOldOffer : offerCollectionOld) {
                if (!offerCollectionNew.contains(offerCollectionOldOffer)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Offer " + offerCollectionOldOffer + " since its adminID field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Vehicleadvert> attachedVehicleadvertCollectionNew = new ArrayList<Vehicleadvert>();
            for (Vehicleadvert vehicleadvertCollectionNewVehicleadvertToAttach : vehicleadvertCollectionNew) {
                vehicleadvertCollectionNewVehicleadvertToAttach = em.getReference(vehicleadvertCollectionNewVehicleadvertToAttach.getClass(), vehicleadvertCollectionNewVehicleadvertToAttach.getCode());
                attachedVehicleadvertCollectionNew.add(vehicleadvertCollectionNewVehicleadvertToAttach);
            }
            vehicleadvertCollectionNew = attachedVehicleadvertCollectionNew;
            administrato.setVehicleadvertCollection(vehicleadvertCollectionNew);
            Collection<Businessadvert> attachedBusinessadvertCollectionNew = new ArrayList<Businessadvert>();
            for (Businessadvert businessadvertCollectionNewBusinessadvertToAttach : businessadvertCollectionNew) {
                businessadvertCollectionNewBusinessadvertToAttach = em.getReference(businessadvertCollectionNewBusinessadvertToAttach.getClass(), businessadvertCollectionNewBusinessadvertToAttach.getBusinessadvertPK());
                attachedBusinessadvertCollectionNew.add(businessadvertCollectionNewBusinessadvertToAttach);
            }
            businessadvertCollectionNew = attachedBusinessadvertCollectionNew;
            administrato.setBusinessadvertCollection(businessadvertCollectionNew);
            Collection<Offer> attachedOfferCollectionNew = new ArrayList<Offer>();
            for (Offer offerCollectionNewOfferToAttach : offerCollectionNew) {
                offerCollectionNewOfferToAttach = em.getReference(offerCollectionNewOfferToAttach.getClass(), offerCollectionNewOfferToAttach.getNam());
                attachedOfferCollectionNew.add(offerCollectionNewOfferToAttach);
            }
            offerCollectionNew = attachedOfferCollectionNew;
            administrato.setOfferCollection(offerCollectionNew);
            administrato = em.merge(administrato);
            for (Vehicleadvert vehicleadvertCollectionNewVehicleadvert : vehicleadvertCollectionNew) {
                if (!vehicleadvertCollectionOld.contains(vehicleadvertCollectionNewVehicleadvert)) {
                    Administrato oldAdminIDOfVehicleadvertCollectionNewVehicleadvert = vehicleadvertCollectionNewVehicleadvert.getAdminID();
                    vehicleadvertCollectionNewVehicleadvert.setAdminID(administrato);
                    vehicleadvertCollectionNewVehicleadvert = em.merge(vehicleadvertCollectionNewVehicleadvert);
                    if (oldAdminIDOfVehicleadvertCollectionNewVehicleadvert != null && !oldAdminIDOfVehicleadvertCollectionNewVehicleadvert.equals(administrato)) {
                        oldAdminIDOfVehicleadvertCollectionNewVehicleadvert.getVehicleadvertCollection().remove(vehicleadvertCollectionNewVehicleadvert);
                        oldAdminIDOfVehicleadvertCollectionNewVehicleadvert = em.merge(oldAdminIDOfVehicleadvertCollectionNewVehicleadvert);
                    }
                }
            }
            for (Businessadvert businessadvertCollectionNewBusinessadvert : businessadvertCollectionNew) {
                if (!businessadvertCollectionOld.contains(businessadvertCollectionNewBusinessadvert)) {
                    Administrato oldAdminIDOfBusinessadvertCollectionNewBusinessadvert = businessadvertCollectionNewBusinessadvert.getAdminID();
                    businessadvertCollectionNewBusinessadvert.setAdminID(administrato);
                    businessadvertCollectionNewBusinessadvert = em.merge(businessadvertCollectionNewBusinessadvert);
                    if (oldAdminIDOfBusinessadvertCollectionNewBusinessadvert != null && !oldAdminIDOfBusinessadvertCollectionNewBusinessadvert.equals(administrato)) {
                        oldAdminIDOfBusinessadvertCollectionNewBusinessadvert.getBusinessadvertCollection().remove(businessadvertCollectionNewBusinessadvert);
                        oldAdminIDOfBusinessadvertCollectionNewBusinessadvert = em.merge(oldAdminIDOfBusinessadvertCollectionNewBusinessadvert);
                    }
                }
            }
            for (Offer offerCollectionNewOffer : offerCollectionNew) {
                if (!offerCollectionOld.contains(offerCollectionNewOffer)) {
                    Administrato oldAdminIDOfOfferCollectionNewOffer = offerCollectionNewOffer.getAdminID();
                    offerCollectionNewOffer.setAdminID(administrato);
                    offerCollectionNewOffer = em.merge(offerCollectionNewOffer);
                    if (oldAdminIDOfOfferCollectionNewOffer != null && !oldAdminIDOfOfferCollectionNewOffer.equals(administrato)) {
                        oldAdminIDOfOfferCollectionNewOffer.getOfferCollection().remove(offerCollectionNewOffer);
                        oldAdminIDOfOfferCollectionNewOffer = em.merge(oldAdminIDOfOfferCollectionNewOffer);
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
                Integer id = administrato.getAdminID();
                if (findAdministrato(id) == null) {
                    throw new NonexistentEntityException("The administrato with id " + id + " no longer exists.");
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
            Administrato administrato;
            try {
                administrato = em.getReference(Administrato.class, id);
                administrato.getAdminID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrato with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Vehicleadvert> vehicleadvertCollectionOrphanCheck = administrato.getVehicleadvertCollection();
            for (Vehicleadvert vehicleadvertCollectionOrphanCheckVehicleadvert : vehicleadvertCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrato (" + administrato + ") cannot be destroyed since the Vehicleadvert " + vehicleadvertCollectionOrphanCheckVehicleadvert + " in its vehicleadvertCollection field has a non-nullable adminID field.");
            }
            Collection<Businessadvert> businessadvertCollectionOrphanCheck = administrato.getBusinessadvertCollection();
            for (Businessadvert businessadvertCollectionOrphanCheckBusinessadvert : businessadvertCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrato (" + administrato + ") cannot be destroyed since the Businessadvert " + businessadvertCollectionOrphanCheckBusinessadvert + " in its businessadvertCollection field has a non-nullable adminID field.");
            }
            Collection<Offer> offerCollectionOrphanCheck = administrato.getOfferCollection();
            for (Offer offerCollectionOrphanCheckOffer : offerCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Administrato (" + administrato + ") cannot be destroyed since the Offer " + offerCollectionOrphanCheckOffer + " in its offerCollection field has a non-nullable adminID field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(administrato);
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

    public List<Administrato> findAdministratoEntities() {
        return findAdministratoEntities(true, -1, -1);
    }

    public List<Administrato> findAdministratoEntities(int maxResults, int firstResult) {
        return findAdministratoEntities(false, maxResults, firstResult);
    }

    private List<Administrato> findAdministratoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrato.class));
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

    public Administrato findAdministrato(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrato.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministratoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrato> rt = cq.from(Administrato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
