/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Datastore.Entities.Administrato;
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
public class AdministratoJpaController implements Serializable {

    public AdministratoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrato administrato) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(administrato);
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

    public void edit(Administrato administrato) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            administrato = em.merge(administrato);
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

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
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
