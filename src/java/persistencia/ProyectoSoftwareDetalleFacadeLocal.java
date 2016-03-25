/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.ProyectoSoftwareDetalle;

/**
 *
 * @author andres
 */
@Local
public interface ProyectoSoftwareDetalleFacadeLocal {

    void create(ProyectoSoftwareDetalle proyectoSoftwareDetalle);

    void edit(ProyectoSoftwareDetalle proyectoSoftwareDetalle);

    void remove(ProyectoSoftwareDetalle proyectoSoftwareDetalle);

    ProyectoSoftwareDetalle find(Object id);

    List<ProyectoSoftwareDetalle> findAll();

    List<ProyectoSoftwareDetalle> findRange(int[] range);

    int count();
    
}
