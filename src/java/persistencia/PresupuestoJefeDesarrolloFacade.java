/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.PresupuestoJefeDesarrollo;

/**
 *
 * @author andres
 */
@Stateless
public class PresupuestoJefeDesarrolloFacade extends AbstractFacade<PresupuestoJefeDesarrollo> implements PresupuestoJefeDesarrolloFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PresupuestoJefeDesarrolloFacade() {
        super(PresupuestoJefeDesarrollo.class);
    }
    
}
