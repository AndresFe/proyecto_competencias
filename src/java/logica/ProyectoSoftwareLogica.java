/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.ProyectoSoftware;
import persistencia.ProyectoSoftwareFacade;

/**
 *
 * @author andres
 */
@Stateless
public class ProyectoSoftwareLogica implements ProyectoSoftwareLogicaLocal {

    @EJB
    ProyectoSoftwareFacade proyectoSoftwareDAO;
    
    @Override
    public void registrarProyectoSoftware(ProyectoSoftware proyecto) throws Exception {
        if(proyecto == null){
            throw new Exception("Campos vacíos");
        }else{
            if(proyecto.getId() == null || proyecto.getId().equals("")){
                throw new Exception("El ID del proyecto es obligatorio");
            }if(proyecto.getIdIngenieroSenior() == null || proyecto.getIdIngenieroSenior().equals("")){
                throw new Exception("El ID del ingeniero senior del proyecto es obligatorio");
            }if(proyecto.getDesarrolladores() == null || proyecto.getDesarrolladores().equals("")){
                throw new Exception("El ID del grupo de desarrolladores del proyecto es obligatorio");
            }
            ProyectoSoftware objProyecto = proyectoSoftwareDAO.find(proyecto.getId());
            if(objProyecto != null){
                throw new Exception("Este proyecto ya se encuentra registrado en la base de datos");
            }else{
                proyectoSoftwareDAO.create(objProyecto);
            }
        }
    }

    @Override
    public void modificarProyectoSoftware(ProyectoSoftware proyecto) throws Exception {
        if(proyecto == null){
            throw new Exception("Campos vacíos");
        }else{
            if(proyecto.getId() == null || proyecto.getId().equals("")){
                throw new Exception("El ID del proyecto es obligatorio");
            }if(proyecto.getIdIngenieroSenior() == null || proyecto.getIdIngenieroSenior().equals("")){
                throw new Exception("El ID del ingeniero senior del proyecto es obligatorio");
            }if(proyecto.getDesarrolladores() == null || proyecto.getDesarrolladores().equals("")){
                throw new Exception("El ID del grupo de desarrolladores del proyecto es obligatorio");
            }
            ProyectoSoftware objProyecto = proyectoSoftwareDAO.find(proyecto.getId());
            if(objProyecto != null){
                objProyecto.setId(proyecto.getId());
                objProyecto.setIdIngenieroSenior(proyecto.getIdIngenieroSenior());
                objProyecto.setDesarrolladores(proyecto.getDesarrolladores());  
                proyectoSoftwareDAO.edit(objProyecto);
            }else{
                throw new Exception("Este Proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public ProyectoSoftware consultarxCodigoProyectoSoftware(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Proyecto es obligatorio");
        }else{
            return proyectoSoftwareDAO.find(codigo);
        }
    }

    @Override
    public List<ProyectoSoftware> consultarTodosProyectoSoftware() throws Exception {
        return proyectoSoftwareDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
