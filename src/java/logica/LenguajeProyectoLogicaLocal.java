/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.LenguajeProyecto;

/**
 *
 * @author andres
 */
@Local
public interface LenguajeProyectoLogicaLocal {
    
    public void registrarLenguajeProyecto(LenguajeProyecto lenguaje) throws Exception;
    public void modificarLenguajeProyecto(LenguajeProyecto lenguaje) throws Exception;
    public LenguajeProyecto consultarxCodigoLenguajeProyecto(int codigo) throws Exception;
    public List<LenguajeProyecto> consultarTodosLenguajeProyecto() throws Exception;
    
}
