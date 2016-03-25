/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.ProyectoSoftware;

/**
 *
 * @author andres
 */
@Local

public interface ProyectoSoftwareLogicaLocal {
    
    public void registrarProyectoSoftware(ProyectoSoftware proyecto) throws Exception;
    public void modificarProyectoSoftware(ProyectoSoftware proyecto) throws Exception;
    public ProyectoSoftware consultarxCodigoProyectoSoftware(int codigo) throws Exception;
    public List<ProyectoSoftware> consultarTodosProyectoSoftware() throws Exception;
    
}
