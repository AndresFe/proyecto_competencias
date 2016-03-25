/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.AsignacionProyecto;

/**
 *
 * @author andres
 */
@Local
public interface AsignacionProyectoLogicaLocal {
    
    public void registrarAsignacionProyecto(AsignacionProyecto proyecto) throws Exception;
    public void modificarAsignacionProyecto(AsignacionProyecto proyecto) throws Exception;
    public AsignacionProyecto consultarxCodigoAsignacionProyecto(int codigo) throws Exception;
    public List<AsignacionProyecto> consultarTodosAsignacionProyecto() throws Exception;
    
}
