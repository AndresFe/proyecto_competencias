/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.AsignacionProyecto;

/**
 *
 * @author andres
 */
@Local
public interface AsignacionProyectoFacadeLocal {

    void create(AsignacionProyecto asignacionProyecto);

    void edit(AsignacionProyecto asignacionProyecto);

    void remove(AsignacionProyecto asignacionProyecto);

    AsignacionProyecto find(Object id);

    List<AsignacionProyecto> findAll();

    List<AsignacionProyecto> findRange(int[] range);

    int count();
    
}
