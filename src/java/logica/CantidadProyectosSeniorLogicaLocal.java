/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.CantidadProyectosSenior;

/**
 *
 * @author andres
 */
@Local
public interface CantidadProyectosSeniorLogicaLocal {
    
    public void registrarCantidadProyectosSenior(CantidadProyectosSenior cantidad) throws Exception;
    public void modificarCantidadProyectosSenior(CantidadProyectosSenior cantidad) throws Exception;
    public CantidadProyectosSenior consultarxCodigoCantidadProyectosSenior(int codigo) throws Exception;
    public List<CantidadProyectosSenior> consultarTodosCantidadProyectosSenior() throws Exception;
    
}
