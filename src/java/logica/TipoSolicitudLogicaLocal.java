/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoSolicitud;

/**
 *
 * @author andres
 */
@Local
public interface TipoSolicitudLogicaLocal {
    
    public void registrarTipoSolicitud(TipoSolicitud tipo) throws Exception;
    public void modificarTipoSolicitud(TipoSolicitud tipo) throws Exception;
    public TipoSolicitud consultarxCodigoTipoSolicitud(int codigo) throws Exception;
    public List<TipoSolicitud> consultarTodosTipoSolicitud() throws Exception;
    
}
