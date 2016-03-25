/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.ProyectoSoftware;

/**
 *
 * @author andres
 */
@Stateless
public class ProyectoSoftwareFacade extends AbstractFacade<ProyectoSoftware> implements ProyectoSoftwareFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoSoftwareFacade() {
        super(ProyectoSoftware.class);
    }
    
}
