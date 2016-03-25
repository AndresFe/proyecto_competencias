/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.LenguajeProyecto;

/**
 *
 * @author andres
 */
@Local
public interface LenguajeProyectoFacadeLocal {

    void create(LenguajeProyecto lenguajeProyecto);

    void edit(LenguajeProyecto lenguajeProyecto);

    void remove(LenguajeProyecto lenguajeProyecto);

    LenguajeProyecto find(Object id);

    List<LenguajeProyecto> findAll();

    List<LenguajeProyecto> findRange(int[] range);

    int count();
    
}
