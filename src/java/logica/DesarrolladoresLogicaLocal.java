/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Desarrolladores;

/**
 *
 * @author andres
 */
@Local
public interface DesarrolladoresLogicaLocal {
    
    public void registrarDesarrolladores(Desarrolladores equipo) throws Exception;
    public void modificarDesarrolladores(Desarrolladores equipo) throws Exception;
    public Desarrolladores consultarxCodigoDesarrolladores(int codigo) throws Exception;
    public List<Desarrolladores> consultarTodosDesarrolladores() throws Exception;
}
