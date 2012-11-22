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
import Datastore.Entities.Businessadvert;
import Datastore.Entities.BusinessadvertPK;
import Datastore.Entities.Registeredclient;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author root
 */
public class BusinessadvertJpaController implements Serializable {

    public BusinessadvertJpaController() {

    }
    @Resource private UserTransaction utx;
    @PersistenceUnit private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Businessadvert businessadvert) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (businessadvert.getBusinessadvertPK() == null) {
            businessadvert.setBusinessadvertPK(new BusinessadvertPK());
        }
        businessadvert.getBusinessadvertPK().setClientID(businessadvert.getRegisteredclient().getClientID());
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        try {
            utx.begin();
            em = getEntityManager();
            Administrato adminID = businessadvert.getAdminID();
            if (adminID != null) {
                adminID = em.getReference(adminID.getClass(), adminID.getAdminID());
                businessadvert.setAdminID(adminID);
            }
            Registeredclient registeredclient = businessadvert.getRegisteredclient();
            if (registeredclient != null) {
                registeredclient = em.getReference(registeredclient.getClass(), registeredclient.getClientID());
                businessadvert.setRegisteredclient(registeredclient);
            }
            em.persist(businessadvert);
            if (adminID != null) {
                adminID.getBusinessadvertCollection().add(businessadvert);
                adminID = em.merge(adminID);
            }
            if (registeredclient != null) {
                registeredclient.getBusinessadvertCollection().add(businessadvert);
                registeredclient = em.merge(registeredclient);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findBusinessadvert(businessadvert.getBusinessadvertPK()) != null) {
                throw new PreexistingEntityException("Businessadvert " + businessadvert + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Businessadvert businessadvert) throws NonexistentEntityException, RollbackFailureException, Exception {
        businessadvert.getBusinessadvertPK().setClientID(businessadvert.getRegisteredclient().getClientID());
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Businessadvert persistentBusinessadvert = em.find(Businessadvert.class, businessadvert.getBusinessadvertPK());
            Administrato adminIDOld = persistentBusinessadvert.getAdminID();
            Administrato adminIDNew = businessadvert.getAdminID();
            Registeredclient registeredclientOld = persistentBusinessadvert.getRegisteredclient();
            Registeredclient registeredclientNew = businessadvert.getRegisteredclient();
            if (adminIDNew != null) {
                adminIDNew = em.getReference(adminIDNew.getClass(), adminIDNew.getAdminID());
                businessadvert.setAdminID(adminIDNew);
            }
            if (registeredclientNew != null) {
                registeredclientNew = em.getReference(registeredclientNew.getClass(), registeredclientNew.getClientID());
                businessadvert.setRegisteredclient(registeredclientNew);
            }
            businessadvert = em.merge(businessadvert);
            if (adminIDOld != null && !adminIDOld.equals(adminIDNew)) {
                adminIDOld.getBusinessadvertCollection().remove(businessadvert);
                adminIDOld = em.merge(adminIDOld);
            }
            if (adminIDNew != null && !adminIDNew.equals(adminIDOld)) {
                adminIDNew.getBusinessadvertCollection().add(businessadvert);
                adminIDNew = em.merge(adminIDNew);
            }
            if (registeredclientOld != null && !registeredclientOld.equals(registeredclientNew)) {
                registeredclientOld.getBusinessadvertCollection().remove(businessadvert);
                registeredclientOld = em.merge(registeredclientOld);
            }
            if (registeredclientNew != null && !registeredclientNew.equals(registeredclientOld)) {
                registeredclientNew.getBusinessadvertCollection().add(businessadvert);
                registeredclientNew = em.merge(registeredclientNew);
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
                BusinessadvertPK id = businessadvert.getBusinessadvertPK();
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

    public void destroy(BusinessadvertPK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        Context ctx = new InitialContext();
        this.utx = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        
        try {
            utx.begin();
            em = getEntityManager();
            Businessadvert businessadvert;
            try {
                businessadvert = em.getReference(Businessadvert.class, id);
                businessadvert.getBusinessadvertPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The businessadvert with id " + id + " no longer exists.", enfe);
            }
            Administrato adminID = businessadvert.getAdminID();
            if (adminID != null) {
                adminID.getBusinessadvertCollection().remove(businessadvert);
                adminID = em.merge(adminID);
            }
            Registeredclient registeredclient = businessadvert.getRegisteredclient();
            if (registeredclient != null) {
                registeredclient.getBusinessadvertCollection().remove(businessadvert);
                registeredclient = em.merge(registeredclient);
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

    public Businessadvert findBusinessadvert(BusinessadvertPK id) {
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
    
}
