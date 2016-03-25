/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.CantidadProyectosSenior;
import persistencia.CantidadProyectosSeniorFacade;

/**
 *
 * @author andres
 */
@Stateless
public class CantidadProyectosSeniorLogica implements CantidadProyectosSeniorLogicaLocal {
    
    @EJB
    CantidadProyectosSeniorFacade cantidadProyectosDAO;

    @Override
    public void registrarCantidadProyectosSenior(CantidadProyectosSenior cantidad) throws Exception {
        if(cantidad == null){
            throw new Exception("Campos vacíos");
        }else{
            if(cantidad.getIdIngeniero().equals("") || cantidad.getIdIngeniero() <= 0){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(cantidad.getCantidadProyectosAsignados() < 0){
                throw new Exception("El numero de proyectos asignados al Ingeniero es obligatorio");
            }
            CantidadProyectosSenior objCantidadProyectos = cantidadProyectosDAO.find(cantidad.getIdIngeniero());
            if(objCantidadProyectos != null){
                throw new Exception("La cantidad de proyectos asignados al ingeniero ya están registradas");
            }else{
                cantidadProyectosDAO.create(objCantidadProyectos);
            }
        }
    }

    @Override
    public void modificarCantidadProyectosSenior(CantidadProyectosSenior cantidad) throws Exception {
        if(cantidad == null){
            throw new Exception("Campos vacíos");
        }else{
            if(cantidad.getIdIngeniero().equals("") || cantidad.getIdIngeniero() <= 0){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(cantidad.getCantidadProyectosAsignados() < 0){
                throw new Exception("El numero de proyectos asignados al Ingeniero es obligatorio");
            }
            CantidadProyectosSenior objCantidadProyectos = cantidadProyectosDAO.find(cantidad.getIdIngeniero());
            if(objCantidadProyectos != null){
                objCantidadProyectos.setIdIngeniero(cantidad.getIdIngeniero());
                objCantidadProyectos.setCantidadProyectosAsignados(cantidad.getCantidadProyectosAsignados());
                cantidadProyectosDAO.edit(objCantidadProyectos);
            }else{
                throw new Exception("Este ingeniero no tiene proyectos asignados registrados");
            }
        }
    }

    @Override
    public  CantidadProyectosSenior consultarxCodigoCantidadProyectosSenior(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El ID del ingeniero es obligatorio");
        }else{
            return cantidadProyectosDAO.find(codigo);
        }
    }

    @Override
    public List<CantidadProyectosSenior> consultarTodosCantidadProyectosSenior() throws Exception {
        return cantidadProyectosDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
