/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoEstado;

/**
 *
 * @author andres
 */
@Local
public interface TipoEstadoLogicaLocal {
    
    public void registrarTipoEstado(TipoEstado tipo) throws Exception;
    public void modificarTipoEstado(TipoEstado tipo) throws Exception;
    public TipoEstado consultarxCodigoTipoEstado(int codigo) throws Exception;
    public List<TipoEstado> consultarTodosTipoEstado() throws Exception;
    
}
