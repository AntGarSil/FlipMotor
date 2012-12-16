/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import model.Entities.Businessadvert;
import model.model.exceptions.NonexistentEntityException;
import model.model.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Entities.Offer;
import model.Entities.Registeredclient;
import model.Entities.Conciliation;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
public class BusinessadvertJpaController implements Serializable {

    public BusinessadvertJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU"); 

    public BusinessadvertJpaController() {}

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Businessadvert businessadvert) throws RollbackFailureException, Exception {
        if (businessadvert.getConciliationCollection() == null) {
            businessadvert.setConciliationCollection(new ArrayList<Conciliation>());
        }
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            Offer offer = businessadvert.getOffer();
            if (offer != null) {
                offer = em.getReference(offer.getClass(), offer.getNam());
                businessadvert.setOffer(offer);
            }
            Registeredclient clientID = businessadvert.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getClientID());
                businessadvert.setClientID(clientID);
            }
            Collection<Conciliation> attachedConciliationCollection = new ArrayList<Conciliation>();
            for (Conciliation conciliationCollectionConciliationToAttach : businessadvert.getConciliationCollection()) {
                conciliationCollectionConciliationToAttach = em.getReference(conciliationCollectionConciliationToAttach.getClass(), conciliationCollectionConciliationToAttach.getCode());
                attachedConciliationCollection.add(conciliationCollectionConciliationToAttach);
            }
            businessadvert.setConciliationCollection(attachedConciliationCollection);
            em.persist(businessadvert);
            if (offer != null) {
                offer.getBusinessadvertCollection().add(businessadvert);
                offer = em.merge(offer);
            }
            if (clientID != null) {
                clientID.getBusinessadvertCollection().add(businessadvert);
                clientID = em.merge(clientID);
            }
            for (Conciliation conciliationCollectionConciliation : businessadvert.getConciliationCollection()) {
                Businessadvert oldBusinessIDOfConciliationCollectionConciliation = conciliationCollectionConciliation.getBusinessID();
                conciliationCollectionConciliation.setBusinessID(businessadvert);
                conciliationCollectionConciliation = em.merge(conciliationCollectionConciliation);
                if (oldBusinessIDOfConciliationCollectionConciliation != null) {
                    oldBusinessIDOfConciliationCollectionConciliation.getConciliationCollection().remove(conciliationCollectionConciliation);
                    oldBusinessIDOfConciliationCollectionConciliation = em.merge(oldBusinessIDOfConciliationCollectionConciliation);
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

    public void edit(Businessadvert businessadvert) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            Businessadvert persistentBusinessadvert = em.find(Businessadvert.class, businessadvert.getCode());
            Offer offerOld = persistentBusinessadvert.getOffer();
            Offer offerNew = businessadvert.getOffer();
            Registeredclient clientIDOld = persistentBusinessadvert.getClientID();
            Registeredclient clientIDNew = businessadvert.getClientID();
            Collection<Conciliation> conciliationCollectionOld = persistentBusinessadvert.getConciliationCollection();
            Collection<Conciliation> conciliationCollectionNew = businessadvert.getConciliationCollection();
            if (offerNew != null) {
                offerNew = em.getReference(offerNew.getClass(), offerNew.getNam());
                businessadvert.setOffer(offerNew);
            }
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getClientID());
                businessadvert.setClientID(clientIDNew);
            }
            Collection<Conciliation> attachedConciliationCollectionNew = new ArrayList<Conciliation>();
            for (Conciliation conciliationCollectionNewConciliationToAttach : conciliationCollectionNew) {
                conciliationCollectionNewConciliationToAttach = em.getReference(conciliationCollectionNewConciliationToAttach.getClass(), conciliationCollectionNewConciliationToAttach.getCode());
                attachedConciliationCollectionNew.add(conciliationCollectionNewConciliationToAttach);
            }
            conciliationCollectionNew = attachedConciliationCollectionNew;
            businessadvert.setConciliationCollection(conciliationCollectionNew);
            businessadvert = em.merge(businessadvert);
            if (offerOld != null && !offerOld.equals(offerNew)) {
                offerOld.getBusinessadvertCollection().remove(businessadvert);
                offerOld = em.merge(offerOld);
            }
            if (offerNew != null && !offerNew.equals(offerOld)) {
                offerNew.getBusinessadvertCollection().add(businessadvert);
                offerNew = em.merge(offerNew);
            }
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getBusinessadvertCollection().remove(businessadvert);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getBusinessadvertCollection().add(businessadvert);
                clientIDNew = em.merge(clientIDNew);
            }
            for (Conciliation conciliationCollectionOldConciliation : conciliationCollectionOld) {
                if (!conciliationCollectionNew.contains(conciliationCollectionOldConciliation)) {
                    conciliationCollectionOldConciliation.setBusinessID(null);
                    conciliationCollectionOldConciliation = em.merge(conciliationCollectionOldConciliation);
                }
            }
            for (Conciliation conciliationCollectionNewConciliation : conciliationCollectionNew) {
                if (!conciliationCollectionOld.contains(conciliationCollectionNewConciliation)) {
                    Businessadvert oldBusinessIDOfConciliationCollectionNewConciliation = conciliationCollectionNewConciliation.getBusinessID();
                    conciliationCollectionNewConciliation.setBusinessID(businessadvert);
                    conciliationCollectionNewConciliation = em.merge(conciliationCollectionNewConciliation);
                    if (oldBusinessIDOfConciliationCollectionNewConciliation != null && !oldBusinessIDOfConciliationCollectionNewConciliation.equals(businessadvert)) {
                        oldBusinessIDOfConciliationCollectionNewConciliation.getConciliationCollection().remove(conciliationCollectionNewConciliation);
                        oldBusinessIDOfConciliationCollectionNewConciliation = em.merge(oldBusinessIDOfConciliationCollectionNewConciliation);
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
                Integer id = businessadvert.getCode();
                if (findBusinessadvert(id) == null) {
                    throw new NonexistentEntityException("The businessadvert with id " + id + " no longer exists.");
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
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            Businessadvert businessadvert;
            try {
                businessadvert = em.getReference(Businessadvert.class, id);
                businessadvert.getCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The businessadvert with id " + id + " no longer exists.", enfe);
            }
            Offer offer = businessadvert.getOffer();
            if (offer != null) {
                offer.getBusinessadvertCollection().remove(businessadvert);
                offer = em.merge(offer);
            }
            Registeredclient clientID = businessadvert.getClientID();
            if (clientID != null) {
                clientID.getBusinessadvertCollection().remove(businessadvert);
                clientID = em.merge(clientID);
            }
            Collection<Conciliation> conciliationCollection = businessadvert.getConciliationCollection();
            for (Conciliation conciliationCollectionConciliation : conciliationCollection) {
                conciliationCollectionConciliation.setBusinessID(null);
                conciliationCollectionConciliation = em.merge(conciliationCollectionConciliation);
            }
            em.remove(businessadvert);
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

    public List<Businessadvert> findBusinessadvertEntities() {
        return findBusinessadvertEntities(true, -1, -1);
    }

    public List<Businessadvert> findBusinessadvertEntities(int maxResults, int firstResult) {
        return findBusinessadvertEntities(false, maxResults, firstResult);
    }

    private List<Businessadvert> findBusinessadvertEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Businessadvert.class));
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

    public Businessadvert findBusinessadvert(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Businessadvert.class, id);
        } finally {
            em.close();
        }
    }

    public int getBusinessadvertCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Businessadvert> rt = cq.from(Businessadvert.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    @PersistenceContext
    public List<Businessadvert> findNotValidatedBusiness() {
        EntityManager em = getEntityManager();
        String jpql = "SELECT a FROM Businessadvert a WHERE a.state LIKE 'Not Active' OR a.state LIKE 'Payed'";
        Query q = em.createQuery(jpql);
        return q.getResultList();
    }
    
}
