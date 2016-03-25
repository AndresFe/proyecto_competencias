/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.ProyectoSoftwareDetalle;

/**
 *
 * @author andres
 */
@Local
public interface ProyectoSoftwareDetalleLogicaLocal {
    
    public void registrarProyectoSoftwareDetalle(ProyectoSoftwareDetalle proyecto) throws Exception;
    public void modificarProyectoSoftwareDetalle(ProyectoSoftwareDetalle proyecto) throws Exception;
    public ProyectoSoftwareDetalle consultarxCodigoProyectoSoftwareDetalle(int codigo) throws Exception;
    public List<ProyectoSoftwareDetalle> consultarTodosProyectoSoftwareDetalle() throws Exception;
    
}
