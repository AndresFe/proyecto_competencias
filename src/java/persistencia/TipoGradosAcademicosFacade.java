/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipoGradosAcademicos;

/**
 *
 * @author andres
 */
@Stateless
public class TipoGradosAcademicosFacade extends AbstractFacade<TipoGradosAcademicos> implements TipoGradosAcademicosFacadeLocal {
    @PersistenceContext(unitName = "ProyectoCompetenciasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoGradosAcademicosFacade() {
        super(TipoGradosAcademicos.class);
    }
    
}
