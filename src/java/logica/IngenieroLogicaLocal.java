/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingeniero;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroLogicaLocal {
    
    public void registrarIngeniero(Ingeniero ingeniero) throws Exception;
    public void modificarIngeniero(Ingeniero ingeniero) throws Exception;
    public void eliminarIngeniero(Ingeniero ingeniero) throws Exception;
    public Ingeniero consultarxCodigoIngeniero(int codigo) throws Exception;
    public List<Ingeniero> consultarTodasIngeniero() throws Exception;
}
