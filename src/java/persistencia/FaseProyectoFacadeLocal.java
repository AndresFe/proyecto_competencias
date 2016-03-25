/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.FaseProyecto;

/**
 *
 * @author andres
 */
@Local
public interface FaseProyectoFacadeLocal {

    void create(FaseProyecto faseProyecto);

    void edit(FaseProyecto faseProyecto);

    void remove(FaseProyecto faseProyecto);

    FaseProyecto find(Object id);

    List<FaseProyecto> findAll();

    List<FaseProyecto> findRange(int[] range);

    int count();
    
}
