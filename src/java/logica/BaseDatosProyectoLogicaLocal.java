/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.BaseDatosProyecto;

/**
 *
 * @author andres
 */
@Local
public interface BaseDatosProyectoLogicaLocal {
    
    public void registrarBaseDatosProyecto(BaseDatosProyecto baseDatos) throws Exception;
    public void modificarBaseDatosProyecto(BaseDatosProyecto baseDatos) throws Exception;
    public BaseDatosProyecto consultarxCodigoBaseDatosProyecto(int codigo) throws Exception;
    public List<BaseDatosProyecto> consultarTodosBaseDatosProyecto() throws Exception;
    
}
