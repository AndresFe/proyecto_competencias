/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.SeminarioCurso;

/**
 *
 * @author andres
 */
@Local
public interface SeminarioCursoFacadeLocal {

    void create(SeminarioCurso seminarioCurso);

    void edit(SeminarioCurso seminarioCurso);

    void remove(SeminarioCurso seminarioCurso);

    SeminarioCurso find(Object id);

    List<SeminarioCurso> findAll();

    List<SeminarioCurso> findRange(int[] range);

    int count();
    
}
