/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.CantidadProyectosSenior;

/**
 *
 * @author andres
 */
@Local
public interface CantidadProyectosSeniorFacadeLocal {

    void create(CantidadProyectosSenior cantidadProyectosSenior);

    void edit(CantidadProyectosSenior cantidadProyectosSenior);

    void remove(CantidadProyectosSenior cantidadProyectosSenior);

    CantidadProyectosSenior find(Object id);

    List<CantidadProyectosSenior> findAll();

    List<CantidadProyectosSenior> findRange(int[] range);

    int count();
    
}
