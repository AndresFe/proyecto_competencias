/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.FaseProyecto;

/**
 *
 * @author andres
 */
@Local
public interface FaseProyectoLogicaLocal {
    
    public void registrarFaseProyecto(FaseProyecto fase) throws Exception;
    public void modificarFaseProyecto(FaseProyecto fase) throws Exception;
    public FaseProyecto consultarxCodigoFaseProyecto(int codigo) throws Exception;
    public List<FaseProyecto> consultarTodosFaseProyecto() throws Exception;
}
