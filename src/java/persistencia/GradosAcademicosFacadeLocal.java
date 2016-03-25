/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GradosAcademicos;

/**
 *
 * @author andres
 */
@Local
public interface GradosAcademicosFacadeLocal {

    void create(GradosAcademicos gradosAcademicos);

    void edit(GradosAcademicos gradosAcademicos);

    void remove(GradosAcademicos gradosAcademicos);

    GradosAcademicos find(Object id);

    List<GradosAcademicos> findAll();

    List<GradosAcademicos> findRange(int[] range);

    int count();
    
}
