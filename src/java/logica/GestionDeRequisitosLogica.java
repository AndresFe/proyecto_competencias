/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.GestionDeRequisitos;
import persistencia.GestionDeRequisitosFacade;

/**
 *
 * @author andres
 */
@Stateless
public class GestionDeRequisitosLogica implements GestionDeRequisitosLogicaLocal {
    
    @EJB
    GestionDeRequisitosFacade gestionRequisitoDAO;

    @Override
    public void registrarGestionDeRequisitos(GestionDeRequisitos requisito) throws Exception {
        if(requisito == null){
            throw new Exception("Campos vacíos");
        }else{
            if(requisito.getId() == null || requisito.getId().equals("")){
                throw new Exception("El ID de Gestion de Requisitos es obligatorio");
            }if(requisito.getIdRequisitosProyecto() == null || requisito.getIdRequisitosProyecto().equals("")){
                throw new Exception("El ID del Requisito del proyecto es obligatorio");
            }if(requisito.getNumeroSolicitud() < 0 ){
                throw new Exception("El Numero de Solicitud del proyecto es obligatorio");
            }if(requisito.getTitulo() == null || requisito.getTitulo().equals("")){
                throw new Exception("El Titulo de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getFechaSolicitud() == null || requisito.getFechaSolicitud().equals("")){
                throw new Exception("La fecha de solicitud de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getSolicitante() == null || requisito.getSolicitante().equals("")){
                throw new Exception("El Solicitante de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getOrigen() == null || requisito.getOrigen().equals("")){
                throw new Exception("El Origen de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getIdTipoEstado() == null || requisito.getIdTipoEstado().equals("")){
                throw new Exception("El ID del Tipo de Estado de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getPrioridadSolicitante() == null || requisito.getPrioridadSolicitante().equals("")){
                throw new Exception("La Prioridad de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getPrioridadRealizacion() == null || requisito.getPrioridadRealizacion().equals("")){
                throw new Exception("La Prioridad de Realización de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getVerificador() == null || requisito.getVerificador().equals("")){
                throw new Exception("El Verificador de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getFechaUltimaActualizacion() == null || requisito.getFechaUltimaActualizacion().equals("")){
                throw new Exception("La fecha de ultima actualizacion de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getRelease() == null || requisito.getRelease().equals("")){
                throw new Exception("El Release de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getEsfuerzo() == null || requisito.getEsfuerzo().equals("")){
                throw new Exception("El esfuerzo de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getDescripcion() == null || requisito.getDescripcion().equals("")){
                throw new Exception("La Descripcion de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getComentarios() == null || requisito.getComentarios().equals("")){
                throw new Exception("El Comentario de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getIdTipoSolicitud() == null || requisito.getIdTipoSolicitud().equals("")){
                throw new Exception("El ID del Tipo solicitud de la Gestión del Requisito del proyecto es obligatorio");
            }
            GestionDeRequisitos objGestion = gestionRequisitoDAO.find(requisito.getId());
            if(objGestion != null){
                throw new Exception("La Gestion de los requisitos del proyecto ya se encuentran registrados en la base de datos");
            }else{
                gestionRequisitoDAO.create(objGestion);
            }
        }
    }

    @Override
    public void modificarGestionDeRequisitos(GestionDeRequisitos requisito) throws Exception {
        if(requisito == null){
            throw new Exception("Campos vacíos");
        }else{
            if(requisito.getId() == null || requisito.getId().equals("")){
                throw new Exception("El ID de Gestion de Requisitos es obligatorio");
            }if(requisito.getIdRequisitosProyecto() == null || requisito.getIdRequisitosProyecto().equals("")){
                throw new Exception("El ID del Requisito del proyecto es obligatorio");
            }if(requisito.getNumeroSolicitud() < 0 ){
                throw new Exception("El Numero de Solicitud del proyecto es obligatorio");
            }if(requisito.getTitulo() == null || requisito.getTitulo().equals("")){
                throw new Exception("El Titulo de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getFechaSolicitud() == null || requisito.getFechaSolicitud().equals("")){
                throw new Exception("La fecha de solicitud de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getSolicitante() == null || requisito.getSolicitante().equals("")){
                throw new Exception("El Solicitante de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getOrigen() == null || requisito.getOrigen().equals("")){
                throw new Exception("El Origen de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getIdTipoEstado() == null || requisito.getIdTipoEstado().equals("")){
                throw new Exception("El ID del Tipo de Estado de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getPrioridadSolicitante() == null || requisito.getPrioridadSolicitante().equals("")){
                throw new Exception("La Prioridad de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getPrioridadRealizacion() == null || requisito.getPrioridadRealizacion().equals("")){
                throw new Exception("La Prioridad de Realización de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getVerificador() == null || requisito.getVerificador().equals("")){
                throw new Exception("El Verificador de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getFechaUltimaActualizacion() == null || requisito.getFechaUltimaActualizacion().equals("")){
                throw new Exception("La fecha de ultima actualizacion de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getRelease() == null || requisito.getRelease().equals("")){
                throw new Exception("El Release de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getEsfuerzo() == null || requisito.getEsfuerzo().equals("")){
                throw new Exception("El esfuerzo de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getDescripcion() == null || requisito.getDescripcion().equals("")){
                throw new Exception("La Descripcion de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getComentarios() == null || requisito.getComentarios().equals("")){
                throw new Exception("El Comentario de la Gestión del Requisito del proyecto es obligatorio");
            }if(requisito.getIdTipoSolicitud() == null || requisito.getIdTipoSolicitud().equals("")){
                throw new Exception("El ID del Tipo solicitud de la Gestión del Requisito del proyecto es obligatorio");
            }
            GestionDeRequisitos objGestion = gestionRequisitoDAO.find(requisito.getId());
            if(objGestion != null){
                objGestion.setId(requisito.getId());
                objGestion.setIdRequisitosProyecto(requisito.getIdRequisitosProyecto());
                objGestion.setNumeroSolicitud(requisito.getNumeroSolicitud());
                objGestion.setTitulo(requisito.getTitulo());
                objGestion.setFechaSolicitud(requisito.getFechaSolicitud());
                objGestion.setSolicitante(requisito.getSolicitante());
                objGestion.setOrigen(requisito.getOrigen());
                objGestion.setIdTipoEstado(requisito.getIdTipoEstado());
                objGestion.setPrioridadSolicitante(requisito.getPrioridadSolicitante());
                objGestion.setPrioridadRealizacion(requisito.getPrioridadRealizacion());
                objGestion.setVerificador(requisito.getVerificador());
                objGestion.setFechaUltimaActualizacion(requisito.getFechaUltimaActualizacion());
                objGestion.setRelease(requisito.getRelease());
                objGestion.setEsfuerzo(requisito.getEsfuerzo());
                objGestion.setDescripcion(requisito.getDescripcion());
                objGestion.setComentarios(requisito.getComentarios());
                objGestion.setIdTipoSolicitud(requisito.getIdTipoSolicitud());
                gestionRequisitoDAO.edit(objGestion);
            }else{
                throw new Exception("Esta Gestion de Requisito del proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public GestionDeRequisitos consultarxCodigoGestionDeRequisitos(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código de la Gestion de Requisito del Proyecto es obligatorio");
        }else{
            return gestionRequisitoDAO.find(codigo);
        }
    }

    @Override
    public List<GestionDeRequisitos> consultarTodosGestionDeRequisitos() throws Exception {
        return gestionRequisitoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
