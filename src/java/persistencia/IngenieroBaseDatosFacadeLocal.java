/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenieroBaseDatos;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroBaseDatosFacadeLocal {

    void create(IngenieroBaseDatos ingenieroBaseDatos);

    void edit(IngenieroBaseDatos ingenieroBaseDatos);

    void remove(IngenieroBaseDatos ingenieroBaseDatos);

    IngenieroBaseDatos find(Object id);

    List<IngenieroBaseDatos> findAll();

    List<IngenieroBaseDatos> findRange(int[] range);

    int count();
    
}
