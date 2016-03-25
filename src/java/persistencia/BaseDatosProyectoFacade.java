/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.BaseDatosProyecto;

/**
 *
 * @author andres
 */
@Stateless
public class BaseDatosProyectoFacade extends AbstractFacade<BaseDatosProyecto> implements BaseDatosProyectoFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BaseDatosProyectoFacade() {
        super(BaseDatosProyecto.class);
    }
    
}
