/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.RequisitosDelProyecto;

/**
 *
 * @author andres
 */
@Local
public interface RequisitosDelProyectoLogicaLocal {
    
    public void registrarRequisitosDelProyecto(RequisitosDelProyecto requisito) throws Exception;
    public void modificarRequisitosDelProyecto(RequisitosDelProyecto requisito) throws Exception;
    public RequisitosDelProyecto consultarxCodigoRequisitosDelProyecto(int codigo) throws Exception;
    public List<RequisitosDelProyecto> consultarTodosRequisitosDelProyecto() throws Exception;
    
}
