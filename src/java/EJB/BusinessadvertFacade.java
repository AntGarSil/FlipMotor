/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Flipmotor.Entities.Businessadvert;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class BusinessadvertFacade extends AbstractFacade<Businessadvert> {
    @PersistenceContext(unitName = "ProjectPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public BusinessadvertFacade() {
        super(Businessadvert.class);
    }
    
}
