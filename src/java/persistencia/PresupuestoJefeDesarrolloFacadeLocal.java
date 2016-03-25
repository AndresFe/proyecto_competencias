/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.PresupuestoJefeDesarrollo;

/**
 *
 * @author andres
 */
@Local
public interface PresupuestoJefeDesarrolloFacadeLocal {

    void create(PresupuestoJefeDesarrollo presupuestoJefeDesarrollo);

    void edit(PresupuestoJefeDesarrollo presupuestoJefeDesarrollo);

    void remove(PresupuestoJefeDesarrollo presupuestoJefeDesarrollo);

    PresupuestoJefeDesarrollo find(Object id);

    List<PresupuestoJefeDesarrollo> findAll();

    List<PresupuestoJefeDesarrollo> findRange(int[] range);

    int count();
    
}
