/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.model;

import Flipmotor.Entities.Conciliation;
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
import Flipmotor.Entities.Vehicleadvert;
import Flipmotor.Entities.Businessadvert;
import Flipmotor.Entities.Registeredclient;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
public class ConciliationJpaController implements Serializable {

    public ConciliationJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conciliation conciliation) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vehicleadvert vehicleID = conciliation.getVehicleID();
            if (vehicleID != null) {
                vehicleID = em.getReference(vehicleID.getClass(), vehicleID.getCode());
                conciliation.setVehicleID(vehicleID);
            }
            Businessadvert businessID = conciliation.getBusinessID();
            if (businessID != null) {
                businessID = em.getReference(businessID.getClass(), businessID.getCode());
                conciliation.setBusinessID(businessID);
            }
            Registeredclient userID = conciliation.getUserID();
            if (userID != null) {
                userID = em.getReference(userID.getClass(), userID.getClientID());
                conciliation.setUserID(userID);
            }
            em.persist(conciliation);
            if (vehicleID != null) {
                vehicleID.getConciliationCollection().add(conciliation);
                vehicleID = em.merge(vehicleID);
            }
            if (businessID != null) {
                businessID.getConciliationCollection().add(conciliation);
                businessID = em.merge(businessID);
            }
            if (userID != null) {
                userID.getConciliationCollection().add(conciliation);
                userID = em.merge(userID);
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

    public void edit(Conciliation conciliation) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Conciliation persistentConciliation = em.find(Conciliation.class, conciliation.getCode());
            Vehicleadvert vehicleIDOld = persistentConciliation.getVehicleID();
            Vehicleadvert vehicleIDNew = conciliation.getVehicleID();
            Businessadvert businessIDOld = persistentConciliation.getBusinessID();
            Businessadvert businessIDNew = conciliation.getBusinessID();
            Registeredclient userIDOld = persistentConciliation.getUserID();
            Registeredclient userIDNew = conciliation.getUserID();
            if (vehicleIDNew != null) {
                vehicleIDNew = em.getReference(vehicleIDNew.getClass(), vehicleIDNew.getCode());
                conciliation.setVehicleID(vehicleIDNew);
            }
            if (businessIDNew != null) {
                businessIDNew = em.getReference(businessIDNew.getClass(), businessIDNew.getCode());
                conciliation.setBusinessID(businessIDNew);
            }
            if (userIDNew != null) {
                userIDNew = em.getReference(userIDNew.getClass(), userIDNew.getClientID());
                conciliation.setUserID(userIDNew);
            }
            conciliation = em.merge(conciliation);
            if (vehicleIDOld != null && !vehicleIDOld.equals(vehicleIDNew)) {
                vehicleIDOld.getConciliationCollection().remove(conciliation);
                vehicleIDOld = em.merge(vehicleIDOld);
            }
            if (vehicleIDNew != null && !vehicleIDNew.equals(vehicleIDOld)) {
                vehicleIDNew.getConciliationCollection().add(conciliation);
                vehicleIDNew = em.merge(vehicleIDNew);
            }
            if (businessIDOld != null && !businessIDOld.equals(businessIDNew)) {
                businessIDOld.getConciliationCollection().remove(conciliation);
                businessIDOld = em.merge(businessIDOld);
            }
            if (businessIDNew != null && !businessIDNew.equals(businessIDOld)) {
                businessIDNew.getConciliationCollection().add(conciliation);
                businessIDNew = em.merge(businessIDNew);
            }
            if (userIDOld != null && !userIDOld.equals(userIDNew)) {
                userIDOld.getConciliationCollection().remove(conciliation);
                userIDOld = em.merge(userIDOld);
            }
            if (userIDNew != null && !userIDNew.equals(userIDOld)) {
                userIDNew.getConciliationCollection().add(conciliation);
                userIDNew = em.merge(userIDNew);
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
                Integer id = conciliation.getCode();
                if (findConciliation(id) == null) {
                    throw new NonexistentEntityException("The conciliation with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Conciliation conciliation;
            try {
                conciliation = em.getReference(Conciliation.class, id);
                conciliation.getCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conciliation with id " + id + " no longer exists.", enfe);
            }
            Vehicleadvert vehicleID = conciliation.getVehicleID();
            if (vehicleID != null) {
                vehicleID.getConciliationCollection().remove(conciliation);
                vehicleID = em.merge(vehicleID);
            }
            Businessadvert businessID = conciliation.getBusinessID();
            if (businessID != null) {
                businessID.getConciliationCollection().remove(conciliation);
                businessID = em.merge(businessID);
            }
            Registeredclient userID = conciliation.getUserID();
            if (userID != null) {
                userID.getConciliationCollection().remove(conciliation);
                userID = em.merge(userID);
            }
            em.remove(conciliation);
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

    public List<Conciliation> findConciliationEntities() {
        return findConciliationEntities(true, -1, -1);
    }

    public List<Conciliation> findConciliationEntities(int maxResults, int firstResult) {
        return findConciliationEntities(false, maxResults, firstResult);
    }

    private List<Conciliation> findConciliationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conciliation.class));
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

    public Conciliation findConciliation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conciliation.class, id);
        } finally {
            em.close();
        }
    }

    public int getConciliationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conciliation> rt = cq.from(Conciliation.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
