/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoRequisito;

/**
 *
 * @author andres
 */
@Local
public interface TipoRequisitoLogicaLocal {
    
    public void registrarTipoRequisito(TipoRequisito tipo) throws Exception;
    public void modificarTipoRequisito(TipoRequisito tipo) throws Exception;
    public TipoRequisito consultarxCodigoTipoRequisito(int codigo) throws Exception;
    public List<TipoRequisito> consultarTodosTipoRequisito() throws Exception;
}
