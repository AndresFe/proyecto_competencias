/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenieroLenguaje;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroLenguajeLogicaLocal {
    
    public void registrarIngenieroLenguaje(IngenieroLenguaje lenguaje) throws Exception;
    public void modificarIngenieroLenguaje(IngenieroLenguaje lenguaje) throws Exception;
    public IngenieroLenguaje consultarxCodigoIngenieroLenguaje(int codigo) throws Exception;
    public List<IngenieroLenguaje> consultarTodosIngenieroLenguaje() throws Exception;
    
}
