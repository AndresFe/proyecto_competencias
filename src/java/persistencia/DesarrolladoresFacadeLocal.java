/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Desarrolladores;

/**
 *
 * @author andres
 */
@Local
public interface DesarrolladoresFacadeLocal {

    void create(Desarrolladores desarrolladores);

    void edit(Desarrolladores desarrolladores);

    void remove(Desarrolladores desarrolladores);

    Desarrolladores find(Object id);

    List<Desarrolladores> findAll();

    List<Desarrolladores> findRange(int[] range);

    int count();
    
}
