/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenieroLenguaje;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroLenguajeFacadeLocal {

    void create(IngenieroLenguaje ingenieroLenguaje);

    void edit(IngenieroLenguaje ingenieroLenguaje);

    void remove(IngenieroLenguaje ingenieroLenguaje);

    IngenieroLenguaje find(Object id);

    List<IngenieroLenguaje> findAll();

    List<IngenieroLenguaje> findRange(int[] range);

    int count();
    
}
