/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipoEstado;

/**
 *
 * @author andres
 */
@Stateless
public class TipoEstadoFacade extends AbstractFacade<TipoEstado> implements TipoEstadoFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEstadoFacade() {
        super(TipoEstado.class);
    }
    
}
