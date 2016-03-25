/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoIngeniero;

/**
 *
 * @author andres
 */
@Local
public interface TipoIngenieroFacadeLocal {

    void create(TipoIngeniero tipoIngeniero);

    void edit(TipoIngeniero tipoIngeniero);

    void remove(TipoIngeniero tipoIngeniero);

    TipoIngeniero find(Object id);

    List<TipoIngeniero> findAll();

    List<TipoIngeniero> findRange(int[] range);

    int count();
    
}
