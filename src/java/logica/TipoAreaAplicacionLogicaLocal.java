/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoAreaAplicacion;

/**
 *
 * @author andres
 */
@Local
public interface TipoAreaAplicacionLogicaLocal {
    
    public void registrarTipoAreaAplicacion(TipoAreaAplicacion area) throws Exception;
    public void modificarTipoAreaAplicacion(TipoAreaAplicacion area) throws Exception;
    public TipoAreaAplicacion consultarxCodigoTipoAreaAplicacion(int codigo) throws Exception;
    public List<TipoAreaAplicacion> consultarTodosTipoAreaAplicacion() throws Exception;
    
}
