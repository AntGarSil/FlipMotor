/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class OfferJpaController implements Serializable {

    public OfferJpaController() {

    }
    
    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Offer offer) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Administrato adminID = offer.getAdminID();
            if (adminID != null) {
                adminID = em.getReference(adminID.getClass(), adminID.getAdminID());
                offer.setAdminID(adminID);
            }
            em.persist(offer);
            if (adminID != null) {
                adminID.getOfferCollection().add(offer);
                adminID = em.merge(adminID);
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

    public void edit(Offer offer) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Offer persistentOffer = em.find(Offer.class, offer.getNam());
            Administrato adminIDOld = persistentOffer.getAdminID();
            Administrato adminIDNew = offer.getAdminID();
            if (adminIDNew != null) {
                adminIDNew = em.getReference(adminIDNew.getClass(), adminIDNew.getAdminID());
                offer.setAdminID(adminIDNew);
            }
            offer = em.merge(offer);
            if (adminIDOld != null && !adminIDOld.equals(adminIDNew)) {
                adminIDOld.getOfferCollection().remove(offer);
                adminIDOld = em.merge(adminIDOld);
            }
            if (adminIDNew != null && !adminIDNew.equals(adminIDOld)) {
                adminIDNew.getOfferCollection().add(offer);
                adminIDNew = em.merge(adminIDNew);
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

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
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
            Administrato adminID = offer.getAdminID();
            if (adminID != null) {
                adminID.getOfferCollection().remove(offer);
                adminID = em.merge(adminID);
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
