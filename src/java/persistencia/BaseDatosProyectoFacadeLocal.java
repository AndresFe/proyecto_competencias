/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.BaseDatosProyecto;

/**
 *
 * @author andres
 */
@Local
public interface BaseDatosProyectoFacadeLocal {

    void create(BaseDatosProyecto baseDatosProyecto);

    void edit(BaseDatosProyecto baseDatosProyecto);

    void remove(BaseDatosProyecto baseDatosProyecto);

    BaseDatosProyecto find(Object id);

    List<BaseDatosProyecto> findAll();

    List<BaseDatosProyecto> findRange(int[] range);

    int count();
    
}
