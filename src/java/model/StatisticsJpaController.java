/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Datastore.Entities.Statistics;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.exceptions.NonexistentEntityException;
import model.exceptions.PreexistingEntityException;
import model.exceptions.RollbackFailureException;

/**
 *
 * @author root
 */
public class StatisticsJpaController implements Serializable {

    public StatisticsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Statistics statistics) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
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
            if (findStatistics(statistics.getAdvertID()) != null) {
                throw new PreexistingEntityException("Statistics " + statistics + " already exists.", ex);
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
                Integer id = statistics.getAdvertID();
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
        try {
            utx.begin();
            em = getEntityManager();
            Statistics statistics;
            try {
                statistics = em.getReference(Statistics.class, id);
                statistics.getAdvertID();
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
