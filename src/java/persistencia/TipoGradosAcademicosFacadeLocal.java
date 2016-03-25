/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoGradosAcademicos;

/**
 *
 * @author andres
 */
@Local
public interface TipoGradosAcademicosFacadeLocal {

    void create(TipoGradosAcademicos tipoGradosAcademicos);

    void edit(TipoGradosAcademicos tipoGradosAcademicos);

    void remove(TipoGradosAcademicos tipoGradosAcademicos);

    TipoGradosAcademicos find(Object id);

    List<TipoGradosAcademicos> findAll();

    List<TipoGradosAcademicos> findRange(int[] range);

    int count();
    
}
