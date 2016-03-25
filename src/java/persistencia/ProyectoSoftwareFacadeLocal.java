/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.ProyectoSoftware;

/**
 *
 * @author andres
 */
@Local
public interface ProyectoSoftwareFacadeLocal {

    void create(ProyectoSoftware proyectoSoftware);

    void edit(ProyectoSoftware proyectoSoftware);

    void remove(ProyectoSoftware proyectoSoftware);

    ProyectoSoftware find(Object id);

    List<ProyectoSoftware> findAll();

    List<ProyectoSoftware> findRange(int[] range);

    int count();
    
}
