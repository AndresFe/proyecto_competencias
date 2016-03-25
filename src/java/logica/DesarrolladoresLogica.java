/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Desarrolladores;
import persistencia.DesarrolladoresFacade;

/**
 *
 * @author andres
 */
@Stateless
public class DesarrolladoresLogica implements DesarrolladoresLogicaLocal {
    
    @EJB
    DesarrolladoresFacade desarrolladoresDAO;

    @Override
    public void registrarDesarrolladores(Desarrolladores equipo) throws Exception {
        if(equipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(equipo.getId() == null || equipo.getId().equals("")){
                throw new Exception("El ID de los Desarrolladores es obligatorio");
            }if(equipo.getIdProyectoSoftware() == null || equipo.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del proyecto de software es obligatorio");
            }if(equipo.getIdIngeniero() == null || equipo.getIdIngeniero().equals("")){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(equipo.getFechaInicio() == null || equipo.getFechaInicio().equals("")){
                throw new Exception("La fecha de inicio es obligatorio");
            }if(equipo.getFechaFin() == null || equipo.getFechaFin().equals("")){
                throw new Exception("La fecha de finalizacion es obligatorio");
            }
            Desarrolladores objDesarrolladores = desarrolladoresDAO.find(equipo.getId());
            if(objDesarrolladores != null){
                throw new Exception("Este Desarrollador ya se encuentra registrado en la base de datos");
            }else{
                desarrolladoresDAO.create(objDesarrolladores);
            }
        }
    }

    @Override
    public void modificarDesarrolladores(Desarrolladores equipo) throws Exception {
        if(equipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(equipo.getId() == null || equipo.getId().equals("")){
                throw new Exception("El ID de los Desarrolladores es obligatorio");
            }if(equipo.getIdProyectoSoftware() == null || equipo.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del proyecto de software es obligatorio");
            }if(equipo.getIdIngeniero() == null || equipo.getIdIngeniero().equals("")){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(equipo.getFechaInicio() == null || equipo.getFechaInicio().equals("")){
                throw new Exception("La fecha de inicio es obligatorio");
            }if(equipo.getFechaFin() == null || equipo.getFechaFin().equals("")){
                throw new Exception("La fecha de finalizacion es obligatorio");
            }
            Desarrolladores objDesarrolladores = desarrolladoresDAO.find(equipo.getId());
            if(objDesarrolladores != null){
                objDesarrolladores.setId(equipo.getId());
                objDesarrolladores.setIdProyectoSoftware(equipo.getIdProyectoSoftware());
                objDesarrolladores.setIdIngeniero(equipo.getIdIngeniero());
                objDesarrolladores.setFechaInicio(equipo.getFechaInicio());
                objDesarrolladores.setFechaFin(equipo.getFechaFin());
                desarrolladoresDAO.edit(objDesarrolladores);
            }else{
                throw new Exception("Esta Desarrollador no está registrado en la base de datos");
            }
        }
    }

    @Override
    public Desarrolladores consultarxCodigoDesarrolladores(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Proyecto es obligatorio");
        }else{
            return desarrolladoresDAO.find(codigo);
        }
    }

    @Override
    public List<Desarrolladores> consultarTodosDesarrolladores() throws Exception {
        return desarrolladoresDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
