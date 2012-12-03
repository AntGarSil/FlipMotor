/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Datastore.Entities.Offer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Datastore.Entities.Vehicleadvert;
import java.util.ArrayList;
import java.util.Collection;
import Datastore.Entities.Businessadvert;
import javax.transaction.UserTransaction;
import model.exceptions.IllegalOrphanException;
import model.exceptions.NonexistentEntityException;
import model.exceptions.PreexistingEntityException;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author root
 */
public class OfferJpaController implements Serializable {

    public OfferJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Offer offer) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (offer.getVehicleadvertCollection() == null) {
            offer.setVehicleadvertCollection(new ArrayList<Vehicleadvert>());
        }
        if (offer.getBusinessadvertCollection() == null) {
            offer.setBusinessadvertCollection(new ArrayList<Businessadvert>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Vehicleadvert> attachedVehicleadvertCollection = new ArrayList<Vehicleadvert>();
            for (Vehicleadvert vehicleadvertCollectionVehicleadvertToAttach : offer.getVehicleadvertCollection()) {
                vehicleadvertCollectionVehicleadvertToAttach = em.getReference(vehicleadvertCollectionVehicleadvertToAttach.getClass(), vehicleadvertCollectionVehicleadvertToAttach.getCode());
                attachedVehicleadvertCollection.add(vehicleadvertCollectionVehicleadvertToAttach);
            }
            offer.setVehicleadvertCollection(attachedVehicleadvertCollection);
            Collection<Businessadvert> attachedBusinessadvertCollection = new ArrayList<Businessadvert>();
            for (Businessadvert businessadvertCollectionBusinessadvertToAttach : offer.getBusinessadvertCollection()) {
                businessadvertCollectionBusinessadvertToAttach = em.getReference(businessadvertCollectionBusinessadvertToAttach.getClass(), businessadvertCollectionBusinessadvertToAttach.getCode());
                attachedBusinessadvertCollection.add(businessadvertCollectionBusinessadvertToAttach);
            }
            offer.setBusinessadvertCollection(attachedBusinessadvertCollection);
            em.persist(offer);
            for (Vehicleadvert vehicleadvertCollectionVehicleadvert : offer.getVehicleadvertCollection()) {
                Offer oldOfferOfVehicleadvertCollectionVehicleadvert = vehicleadvertCollectionVehicleadvert.getOffer();
                vehicleadvertCollectionVehicleadvert.setOffer(offer);
                vehicleadvertCollectionVehicleadvert = em.merge(vehicleadvertCollectionVehicleadvert);
                if (oldOfferOfVehicleadvertCollectionVehicleadvert != null) {
                    oldOfferOfVehicleadvertCollectionVehicleadvert.getVehicleadvertCollection().remove(vehicleadvertCollectionVehicleadvert);
                    oldOfferOfVehicleadvertCollectionVehicleadvert = em.merge(oldOfferOfVehicleadvertCollectionVehicleadvert);
                }
            }
            for (Businessadvert businessadvertCollectionBusinessadvert : offer.getBusinessadvertCollection()) {
                Offer oldOfferOfBusinessadvertCollectionBusinessadvert = businessadvertCollectionBusinessadvert.getOffer();
                businessadvertCollectionBusinessadvert.setOffer(offer);
                businessadvertCollectionBusinessadvert = em.merge(businessadvertCollectionBusinessadvert);
                if (oldOfferOfBusinessadvertCollectionBusinessadvert != null) {
                    oldOfferOfBusinessadvertCollectionBusinessadvert.getBusinessadvertCollection().remove(businessadvertCollectionBusinessadvert);
                    oldOfferOfBusinessadvertCollectionBusinessadvert = em.merge(oldOfferOfBusinessadvertCollectionBusinessadvert);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findOffer(offer.getNam()) != null) {
                throw new PreexistingEntityException("Offer " + offer + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Offer offer) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Offer persistentOffer = em.find(Offer.class, offer.getNam());
            Collection<Vehicleadvert> vehicleadvertCollectionOld = persistentOffer.getVehicleadvertCollection();
            Collection<Vehicleadvert> vehicleadvertCollectionNew = offer.getVehicleadvertCollection();
            Collection<Businessadvert> businessadvertCollectionOld = persistentOffer.getBusinessadvertCollection();
            Collection<Businessadvert> businessadvertCollectionNew = offer.getBusinessadvertCollection();
            List<String> illegalOrphanMessages = null;
            for (Vehicleadvert vehicleadvertCollectionOldVehicleadvert : vehicleadvertCollectionOld) {
                if (!vehicleadvertCollectionNew.contains(vehicleadvertCollectionOldVehicleadvert)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vehicleadvert " + vehicleadvertCollectionOldVehicleadvert + " since its offer field is not nullable.");
                }
            }
            for (Businessadvert businessadvertCollectionOldBusinessadvert : businessadvertCollectionOld) {
                if (!businessadvertCollectionNew.contains(businessadvertCollectionOldBusinessadvert)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Businessadvert " + businessadvertCollectionOldBusinessadvert + " since its offer field is not nullable.");
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
            offer.setVehicleadvertCollection(vehicleadvertCollectionNew);
            Collection<Businessadvert> attachedBusinessadvertCollectionNew = new ArrayList<Businessadvert>();
            for (Businessadvert businessadvertCollectionNewBusinessadvertToAttach : businessadvertCollectionNew) {
                businessadvertCollectionNewBusinessadvertToAttach = em.getReference(businessadvertCollectionNewBusinessadvertToAttach.getClass(), businessadvertCollectionNewBusinessadvertToAttach.getCode());
                attachedBusinessadvertCollectionNew.add(businessadvertCollectionNewBusinessadvertToAttach);
            }
            businessadvertCollectionNew = attachedBusinessadvertCollectionNew;
            offer.setBusinessadvertCollection(businessadvertCollectionNew);
            offer = em.merge(offer);
            for (Vehicleadvert vehicleadvertCollectionNewVehicleadvert : vehicleadvertCollectionNew) {
                if (!vehicleadvertCollectionOld.contains(vehicleadvertCollectionNewVehicleadvert)) {
                    Offer oldOfferOfVehicleadvertCollectionNewVehicleadvert = vehicleadvertCollectionNewVehicleadvert.getOffer();
                    vehicleadvertCollectionNewVehicleadvert.setOffer(offer);
                    vehicleadvertCollectionNewVehicleadvert = em.merge(vehicleadvertCollectionNewVehicleadvert);
                    if (oldOfferOfVehicleadvertCollectionNewVehicleadvert != null && !oldOfferOfVehicleadvertCollectionNewVehicleadvert.equals(offer)) {
                        oldOfferOfVehicleadvertCollectionNewVehicleadvert.getVehicleadvertCollection().remove(vehicleadvertCollectionNewVehicleadvert);
                        oldOfferOfVehicleadvertCollectionNewVehicleadvert = em.merge(oldOfferOfVehicleadvertCollectionNewVehicleadvert);
                    }
                }
            }
            for (Businessadvert businessadvertCollectionNewBusinessadvert : businessadvertCollectionNew) {
                if (!businessadvertCollectionOld.contains(businessadvertCollectionNewBusinessadvert)) {
                    Offer oldOfferOfBusinessadvertCollectionNewBusinessadvert = businessadvertCollectionNewBusinessadvert.getOffer();
                    businessadvertCollectionNewBusinessadvert.setOffer(offer);
                    businessadvertCollectionNewBusinessadvert = em.merge(businessadvertCollectionNewBusinessadvert);
                    if (oldOfferOfBusinessadvertCollectionNewBusinessadvert != null && !oldOfferOfBusinessadvertCollectionNewBusinessadvert.equals(offer)) {
                        oldOfferOfBusinessadvertCollectionNewBusinessadvert.getBusinessadvertCollection().remove(businessadvertCollectionNewBusinessadvert);
                        oldOfferOfBusinessadvertCollectionNewBusinessadvert = em.merge(oldOfferOfBusinessadvertCollectionNewBusinessadvert);
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
                String id = offer.getNam();
                if (findOffer(id) == null) {
                    throw new NonexistentEntityException("The offer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Offer offer;
            try {
                offer = em.getReference(Offer.class, id);
                offer.getNam();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The offer with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Vehicleadvert> vehicleadvertCollectionOrphanCheck = offer.getVehicleadvertCollection();
            for (Vehicleadvert vehicleadvertCollectionOrphanCheckVehicleadvert : vehicleadvertCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Offer (" + offer + ") cannot be destroyed since the Vehicleadvert " + vehicleadvertCollectionOrphanCheckVehicleadvert + " in its vehicleadvertCollection field has a non-nullable offer field.");
            }
            Collection<Businessadvert> businessadvertCollectionOrphanCheck = offer.getBusinessadvertCollection();
            for (Businessadvert businessadvertCollectionOrphanCheckBusinessadvert : businessadvertCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Offer (" + offer + ") cannot be destroyed since the Businessadvert " + businessadvertCollectionOrphanCheckBusinessadvert + " in its businessadvertCollection field has a non-nullable offer field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(offer);
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

    public List<Offer> findOfferEntities() {
        return findOfferEntities(true, -1, -1);
    }

    public List<Offer> findOfferEntities(int maxResults, int firstResult) {
        return findOfferEntities(false, maxResults, firstResult);
    }

    private List<Offer> findOfferEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Offer.class));
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

    public Offer findOffer(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Offer.class, id);
        } finally {
            em.close();
        }
    }

    public int getOfferCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Offer> rt = cq.from(Offer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
