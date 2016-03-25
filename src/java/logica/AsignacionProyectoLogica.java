/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.AsignacionProyecto;
import persistencia.AsignacionProyectoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class AsignacionProyectoLogica implements AsignacionProyectoLogicaLocal {
    
    @EJB
    AsignacionProyectoFacade asignacionProyectoDAO;

    @Override
    public void registrarAsignacionProyecto(AsignacionProyecto proyecto) throws Exception {
        if(proyecto == null){
            throw new Exception("Campos vacíos");
        }else{
            if(proyecto.getId() == null || proyecto.getId().equals("")){
                throw new Exception("El ID de la Asignacion es obligatorio");
            }if(proyecto.getIdProyectoSoftware() == null || proyecto.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del proyecto de software es obligatorio");
            }if(proyecto.getIdIngeniero() == null || proyecto.getIdIngeniero().equals("")){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }
            AsignacionProyecto objAsignacion = asignacionProyectoDAO.find(proyecto.getId());
            if(objAsignacion != null){
                throw new Exception("Esta Asignación proyecto ya se encuentra registrado en la base de datos");
            }else{
                asignacionProyectoDAO.create(objAsignacion);
            }
        }
    }

    @Override
    public void modificarAsignacionProyecto(AsignacionProyecto proyecto) throws Exception {
        if(proyecto == null){
            throw new Exception("Campos vacíos");
        }else{
            if(proyecto.getId() == null || proyecto.getId().equals("")){
                throw new Exception("El ID de la Asignacion es obligatorio");
            }if(proyecto.getIdProyectoSoftware() == null || proyecto.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del proyecto de software es obligatorio");
            }if(proyecto.getIdIngeniero() == null || proyecto.getIdIngeniero().equals("")){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }
            AsignacionProyecto objAsignacion = asignacionProyectoDAO.find(proyecto.getId());
            if(objAsignacion != null){
                objAsignacion.setId(proyecto.getId());
                objAsignacion.setIdProyectoSoftware(proyecto.getIdProyectoSoftware());
                objAsignacion.setIdIngeniero(proyecto.getIdIngeniero());
                asignacionProyectoDAO.edit(objAsignacion);
            }else{
                throw new Exception("Esta Asignación de Proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public AsignacionProyecto consultarxCodigoAsignacionProyecto(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Proyecto es obligatorio");
        }else{
            return asignacionProyectoDAO.find(codigo);
        }
    }

    @Override
    public List<AsignacionProyecto> consultarTodosAsignacionProyecto() throws Exception {
        return asignacionProyectoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
