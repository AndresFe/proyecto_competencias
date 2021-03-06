/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoEstado;

/**
 *
 * @author andres
 */
@Local
public interface TipoEstadoFacadeLocal {

    void create(TipoEstado tipoEstado);

    void edit(TipoEstado tipoEstado);

    void remove(TipoEstado tipoEstado);

    TipoEstado find(Object id);

    List<TipoEstado> findAll();

    List<TipoEstado> findRange(int[] range);

    int count();
    
}
