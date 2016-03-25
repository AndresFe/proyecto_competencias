/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Desarrolladores;

/**
 *
 * @author andres
 */
@Stateless
public class DesarrolladoresFacade extends AbstractFacade<Desarrolladores> implements DesarrolladoresFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DesarrolladoresFacade() {
        super(Desarrolladores.class);
    }
    
}
