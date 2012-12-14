/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.model;

import Flipmotor.Entities.Vehicleadvert;
import Flipmotor.model.exceptions.IllegalOrphanException;
import Flipmotor.model.exceptions.NonexistentEntityException;
import Flipmotor.model.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Flipmotor.Entities.Offer;
import Flipmotor.Entities.Registeredclient;
import Flipmotor.Entities.Conciliation;
import java.util.ArrayList;
import java.util.Collection;
import Flipmotor.Entities.Fav;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
public class VehicleadvertJpaController implements Serializable {

    public VehicleadvertJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehicleadvert vehicleadvert) throws RollbackFailureException, Exception {
        if (vehicleadvert.getConciliationCollection() == null) {
            vehicleadvert.setConciliationCollection(new ArrayList<Conciliation>());
        }
        if (vehicleadvert.getFavCollection() == null) {
            vehicleadvert.setFavCollection(new ArrayList<Fav>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Offer offer = vehicleadvert.getOffer();
            if (offer != null) {
                offer = em.getReference(offer.getClass(), offer.getNam());
                vehicleadvert.setOffer(offer);
            }
            Registeredclient clientID = vehicleadvert.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getClientID());
                vehicleadvert.setClientID(clientID);
            }
            Collection<Conciliation> attachedConciliationCollection = new ArrayList<Conciliation>();
            for (Conciliation conciliationCollectionConciliationToAttach : vehicleadvert.getConciliationCollection()) {
                conciliationCollectionConciliationToAttach = em.getReference(conciliationCollectionConciliationToAttach.getClass(), conciliationCollectionConciliationToAttach.getCode());
                attachedConciliationCollection.add(conciliationCollectionConciliationToAttach);
            }
            vehicleadvert.setConciliationCollection(attachedConciliationCollection);
            Collection<Fav> attachedFavCollection = new ArrayList<Fav>();
            for (Fav favCollectionFavToAttach : vehicleadvert.getFavCollection()) {
                favCollectionFavToAttach = em.getReference(favCollectionFavToAttach.getClass(), favCollectionFavToAttach.getId());
                attachedFavCollection.add(favCollectionFavToAttach);
            }
            vehicleadvert.setFavCollection(attachedFavCollection);
            em.persist(vehicleadvert);
            if (offer != null) {
                offer.getVehicleadvertCollection().add(vehicleadvert);
                offer = em.merge(offer);
            }
            if (clientID != null) {
                clientID.getVehicleadvertCollection().add(vehicleadvert);
                clientID = em.merge(clientID);
            }
            for (Conciliation conciliationCollectionConciliation : vehicleadvert.getConciliationCollection()) {
                Vehicleadvert oldVehicleIDOfConciliationCollectionConciliation = conciliationCollectionConciliation.getVehicleID();
                conciliationCollectionConciliation.setVehicleID(vehicleadvert);
                conciliationCollectionConciliation = em.merge(conciliationCollectionConciliation);
                if (oldVehicleIDOfConciliationCollectionConciliation != null) {
                    oldVehicleIDOfConciliationCollectionConciliation.getConciliationCollection().remove(conciliationCollectionConciliation);
                    oldVehicleIDOfConciliationCollectionConciliation = em.merge(oldVehicleIDOfConciliationCollectionConciliation);
                }
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
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehicleadvert vehicleadvert) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vehicleadvert persistentVehicleadvert = em.find(Vehicleadvert.class, vehicleadvert.getCode());
            Offer offerOld = persistentVehicleadvert.getOffer();
            Offer offerNew = vehicleadvert.getOffer();
            Registeredclient clientIDOld = persistentVehicleadvert.getClientID();
            Registeredclient clientIDNew = vehicleadvert.getClientID();
            Collection<Conciliation> conciliationCollectionOld = persistentVehicleadvert.getConciliationCollection();
            Collection<Conciliation> conciliationCollectionNew = vehicleadvert.getConciliationCollection();
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
            if (offerNew != null) {
                offerNew = em.getReference(offerNew.getClass(), offerNew.getNam());
                vehicleadvert.setOffer(offerNew);
            }
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getClientID());
                vehicleadvert.setClientID(clientIDNew);
            }
            Collection<Conciliation> attachedConciliationCollectionNew = new ArrayList<Conciliation>();
            for (Conciliation conciliationCollectionNewConciliationToAttach : conciliationCollectionNew) {
                conciliationCollectionNewConciliationToAttach = em.getReference(conciliationCollectionNewConciliationToAttach.getClass(), conciliationCollectionNewConciliationToAttach.getCode());
                attachedConciliationCollectionNew.add(conciliationCollectionNewConciliationToAttach);
            }
            conciliationCollectionNew = attachedConciliationCollectionNew;
            vehicleadvert.setConciliationCollection(conciliationCollectionNew);
            Collection<Fav> attachedFavCollectionNew = new ArrayList<Fav>();
            for (Fav favCollectionNewFavToAttach : favCollectionNew) {
                favCollectionNewFavToAttach = em.getReference(favCollectionNewFavToAttach.getClass(), favCollectionNewFavToAttach.getId());
                attachedFavCollectionNew.add(favCollectionNewFavToAttach);
            }
            favCollectionNew = attachedFavCollectionNew;
            vehicleadvert.setFavCollection(favCollectionNew);
            vehicleadvert = em.merge(vehicleadvert);
            if (offerOld != null && !offerOld.equals(offerNew)) {
                offerOld.getVehicleadvertCollection().remove(vehicleadvert);
                offerOld = em.merge(offerOld);
            }
            if (offerNew != null && !offerNew.equals(offerOld)) {
                offerNew.getVehicleadvertCollection().add(vehicleadvert);
                offerNew = em.merge(offerNew);
            }
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getVehicleadvertCollection().remove(vehicleadvert);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getVehicleadvertCollection().add(vehicleadvert);
                clientIDNew = em.merge(clientIDNew);
            }
            for (Conciliation conciliationCollectionOldConciliation : conciliationCollectionOld) {
                if (!conciliationCollectionNew.contains(conciliationCollectionOldConciliation)) {
                    conciliationCollectionOldConciliation.setVehicleID(null);
                    conciliationCollectionOldConciliation = em.merge(conciliationCollectionOldConciliation);
                }
            }
            for (Conciliation conciliationCollectionNewConciliation : conciliationCollectionNew) {
                if (!conciliationCollectionOld.contains(conciliationCollectionNewConciliation)) {
                    Vehicleadvert oldVehicleIDOfConciliationCollectionNewConciliation = conciliationCollectionNewConciliation.getVehicleID();
                    conciliationCollectionNewConciliation.setVehicleID(vehicleadvert);
                    conciliationCollectionNewConciliation = em.merge(conciliationCollectionNewConciliation);
                    if (oldVehicleIDOfConciliationCollectionNewConciliation != null && !oldVehicleIDOfConciliationCollectionNewConciliation.equals(vehicleadvert)) {
                        oldVehicleIDOfConciliationCollectionNewConciliation.getConciliationCollection().remove(conciliationCollectionNewConciliation);
                        oldVehicleIDOfConciliationCollectionNewConciliation = em.merge(oldVehicleIDOfConciliationCollectionNewConciliation);
                    }
                }
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
            Offer offer = vehicleadvert.getOffer();
            if (offer != null) {
                offer.getVehicleadvertCollection().remove(vehicleadvert);
                offer = em.merge(offer);
            }
            Registeredclient clientID = vehicleadvert.getClientID();
            if (clientID != null) {
                clientID.getVehicleadvertCollection().remove(vehicleadvert);
                clientID = em.merge(clientID);
            }
            Collection<Conciliation> conciliationCollection = vehicleadvert.getConciliationCollection();
            for (Conciliation conciliationCollectionConciliation : conciliationCollection) {
                conciliationCollectionConciliation.setVehicleID(null);
                conciliationCollectionConciliation = em.merge(conciliationCollectionConciliation);
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
