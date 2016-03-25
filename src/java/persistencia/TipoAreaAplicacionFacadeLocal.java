/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoAreaAplicacion;

/**
 *
 * @author andres
 */
@Local
public interface TipoAreaAplicacionFacadeLocal {

    void create(TipoAreaAplicacion tipoAreaAplicacion);

    void edit(TipoAreaAplicacion tipoAreaAplicacion);

    void remove(TipoAreaAplicacion tipoAreaAplicacion);

    TipoAreaAplicacion find(Object id);

    List<TipoAreaAplicacion> findAll();

    List<TipoAreaAplicacion> findRange(int[] range);

    int count();
    
}
