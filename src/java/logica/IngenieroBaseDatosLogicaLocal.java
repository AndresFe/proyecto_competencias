/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenieroBaseDatos;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroBaseDatosLogicaLocal {
    
    public void registrarIngenieroBaseDatos(IngenieroBaseDatos baseDatos) throws Exception;
    public void modificarIngenieroBaseDatos(IngenieroBaseDatos baseDatos) throws Exception;
    public IngenieroBaseDatos consultarxCodigoIngenieroBaseDatos(int codigo) throws Exception;
    public List<IngenieroBaseDatos> consultarTodosIngenieroBaseDatos() throws Exception;
    
}
