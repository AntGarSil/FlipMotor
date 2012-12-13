/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.model;

import Flipmotor.Entities.Fav;
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
import Flipmotor.Entities.Registeredclient;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
public class FavJpaController implements Serializable {

    public FavJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public FavJpaController() {
        
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fav fav) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vehicleadvert code = fav.getCode();
            if (code != null) {
                code = em.getReference(code.getClass(), code.getCode());
                fav.setCode(code);
            }
            Registeredclient clientID = fav.getClientID();
            if (clientID != null) {
                clientID = em.getReference(clientID.getClass(), clientID.getClientID());
                fav.setClientID(clientID);
            }
            em.persist(fav);
            if (code != null) {
                code.getFavCollection().add(fav);
                code = em.merge(code);
            }
            if (clientID != null) {
                clientID.getFavCollection().add(fav);
                clientID = em.merge(clientID);
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

    public void edit(Fav fav) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Fav persistentFav = em.find(Fav.class, fav.getId());
            Vehicleadvert codeOld = persistentFav.getCode();
            Vehicleadvert codeNew = fav.getCode();
            Registeredclient clientIDOld = persistentFav.getClientID();
            Registeredclient clientIDNew = fav.getClientID();
            if (codeNew != null) {
                codeNew = em.getReference(codeNew.getClass(), codeNew.getCode());
                fav.setCode(codeNew);
            }
            if (clientIDNew != null) {
                clientIDNew = em.getReference(clientIDNew.getClass(), clientIDNew.getClientID());
                fav.setClientID(clientIDNew);
            }
            fav = em.merge(fav);
            if (codeOld != null && !codeOld.equals(codeNew)) {
                codeOld.getFavCollection().remove(fav);
                codeOld = em.merge(codeOld);
            }
            if (codeNew != null && !codeNew.equals(codeOld)) {
                codeNew.getFavCollection().add(fav);
                codeNew = em.merge(codeNew);
            }
            if (clientIDOld != null && !clientIDOld.equals(clientIDNew)) {
                clientIDOld.getFavCollection().remove(fav);
                clientIDOld = em.merge(clientIDOld);
            }
            if (clientIDNew != null && !clientIDNew.equals(clientIDOld)) {
                clientIDNew.getFavCollection().add(fav);
                clientIDNew = em.merge(clientIDNew);
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
                Integer id = fav.getId();
                if (findFav(id) == null) {
                    throw new NonexistentEntityException("The fav with id " + id + " no longer exists.");
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
            Fav fav;
            try {
                fav = em.getReference(Fav.class, id);
                fav.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fav with id " + id + " no longer exists.", enfe);
            }
            Vehicleadvert code = fav.getCode();
            if (code != null) {
                code.getFavCollection().remove(fav);
                code = em.merge(code);
            }
            Registeredclient clientID = fav.getClientID();
            if (clientID != null) {
                clientID.getFavCollection().remove(fav);
                clientID = em.merge(clientID);
            }
            em.remove(fav);
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

    public List<Fav> findFavEntities() {
        return findFavEntities(true, -1, -1);
    }

    public List<Fav> findFavEntities(int maxResults, int firstResult) {
        return findFavEntities(false, maxResults, firstResult);
    }

    private List<Fav> findFavEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fav.class));
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

    public Fav findFav(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fav.class, id);
        } finally {
            em.close();
        }
    }

    public int getFavCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fav> rt = cq.from(Fav.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
