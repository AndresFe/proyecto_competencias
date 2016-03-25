/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.IngenieroLenguaje;

/**
 *
 * @author andres
 */
@Stateless
public class IngenieroLenguajeFacade extends AbstractFacade<IngenieroLenguaje> implements IngenieroLenguajeFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngenieroLenguajeFacade() {
        super(IngenieroLenguaje.class);
    }
    
}
