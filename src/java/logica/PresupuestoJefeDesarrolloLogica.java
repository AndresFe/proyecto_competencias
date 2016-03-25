/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.PresupuestoJefeDesarrollo;
import persistencia.PresupuestoJefeDesarrolloFacade;

/**
 *
 * @author andres
 */
@Stateless
public class PresupuestoJefeDesarrolloLogica implements PresupuestoJefeDesarrolloLogicaLocal {
    
    @EJB
    PresupuestoJefeDesarrolloFacade presupuestoJefeDesarrolloDAO;

    @Override
    public void registrarPresupuestoJefeDesarrollo(PresupuestoJefeDesarrollo cantidad) throws Exception {
        if(cantidad == null){
            throw new Exception("Campos vacíos");
        }else{
            if(cantidad.getIdIngeniero().equals("") || cantidad.getIdIngeniero() < 0){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(cantidad.getPresupuesto() < 0){
                throw new Exception("El presupuesto asignado al Ingeniero es obligatorio");
            }
            PresupuestoJefeDesarrollo objPresupuesto = presupuestoJefeDesarrolloDAO.find(cantidad.getIdIngeniero());
            if(objPresupuesto != null){
                throw new Exception("La cantidad de proyectos asignados al ingeniero ya están registradas");
            }else{
                presupuestoJefeDesarrolloDAO.create(objPresupuesto);
            }
        }
    }

    @Override
    public void modificarPresupuestoJefeDesarrollo(PresupuestoJefeDesarrollo cantidad) throws Exception {
        if(cantidad == null){
            throw new Exception("Campos vacíos");
        }else{
            if(cantidad.getIdIngeniero().equals("") || cantidad.getIdIngeniero() < 0){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(cantidad.getPresupuesto() < 0){
                throw new Exception("El presupuesto asignado al Ingeniero es obligatorio");
            }
            PresupuestoJefeDesarrollo objPresupuesto = presupuestoJefeDesarrolloDAO.find(cantidad.getIdIngeniero());
            if(objPresupuesto != null){
                objPresupuesto.setIdIngeniero(cantidad.getIdIngeniero());
                objPresupuesto.setPresupuesto(cantidad.getPresupuesto());
                presupuestoJefeDesarrolloDAO.edit(objPresupuesto);
            }else{
                throw new Exception("Este ingeniero no tiene un presupuesto asignado en la base de datos");
            }
        }
    }

    @Override
    public PresupuestoJefeDesarrollo consultarxCodigoPresupuestoJefeDesarrollo(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El ID del ingeniero es obligatorio");
        }else{
            return presupuestoJefeDesarrolloDAO.find(codigo);
        }
    }

    @Override
    public List<PresupuestoJefeDesarrollo> consultarTodosPresupuestoJefeDesarrollo() throws Exception {
        return presupuestoJefeDesarrolloDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
