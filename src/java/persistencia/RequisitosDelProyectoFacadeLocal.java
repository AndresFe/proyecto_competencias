/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.RequisitosDelProyecto;

/**
 *
 * @author andres
 */
@Local
public interface RequisitosDelProyectoFacadeLocal {

    void create(RequisitosDelProyecto requisitosDelProyecto);

    void edit(RequisitosDelProyecto requisitosDelProyecto);

    void remove(RequisitosDelProyecto requisitosDelProyecto);

    RequisitosDelProyecto find(Object id);

    List<RequisitosDelProyecto> findAll();

    List<RequisitosDelProyecto> findRange(int[] range);

    int count();
    
}
