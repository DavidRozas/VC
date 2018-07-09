/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.per;

import entity.per.Detallearriendo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Davo
 */
@Stateless
public class DetallearriendoFacade extends AbstractFacade<Detallearriendo> {

    @PersistenceContext(unitName = "VcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetallearriendoFacade() {
        super(Detallearriendo.class);
    }
    
}
