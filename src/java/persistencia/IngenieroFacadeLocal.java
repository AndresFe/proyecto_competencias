/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingeniero;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroFacadeLocal {

    void create(Ingeniero ingeniero);

    void edit(Ingeniero ingeniero);

    void remove(Ingeniero ingeniero);

    Ingeniero find(Object id);

    List<Ingeniero> findAll();

    List<Ingeniero> findRange(int[] range);

    int count();
    
}
