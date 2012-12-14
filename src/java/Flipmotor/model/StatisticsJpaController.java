/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.model;

import Flipmotor.Entities.Statistics;
import Flipmotor.model.exceptions.NonexistentEntityException;
import Flipmotor.model.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
public class StatisticsJpaController implements Serializable {

    public StatisticsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU"); 

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Statistics statistics) throws RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(statistics);
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

    public void edit(Statistics statistics) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            statistics = em.merge(statistics);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = statistics.getStatID();
                if (findStatistics(id) == null) {
                    throw new NonexistentEntityException("The statistics with id " + id + " no longer exists.");
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
            Statistics statistics;
            try {
                statistics = em.getReference(Statistics.class, id);
                statistics.getStatID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The statistics with id " + id + " no longer exists.", enfe);
            }
            em.remove(statistics);
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

    public List<Statistics> findStatisticsEntities() {
        return findStatisticsEntities(true, -1, -1);
    }

    public List<Statistics> findStatisticsEntities(int maxResults, int firstResult) {
        return findStatisticsEntities(false, maxResults, firstResult);
    }

    private List<Statistics> findStatisticsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Statistics.class));
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

    public Statistics findStatistics(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Statistics.class, id);
        } finally {
            em.close();
        }
    }

    public int getStatisticsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Statistics> rt = cq.from(Statistics.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
