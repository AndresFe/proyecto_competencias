/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.TipoIngeniero;

/**
 *
 * @author andres
 */
@Local
public interface TipoIngenieroLogicaLocal {
    
    public void registrarTipoIngeniero(TipoIngeniero tipo) throws Exception;
    public void modificarTipoIngeniero(TipoIngeniero tipo) throws Exception;
}
