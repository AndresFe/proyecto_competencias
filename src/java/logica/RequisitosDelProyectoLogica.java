/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.RequisitosDelProyecto;
import persistencia.RequisitosDelProyectoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class RequisitosDelProyectoLogica implements RequisitosDelProyectoLogicaLocal {
    
    @EJB
    RequisitosDelProyectoFacade requesitosProyectoDAO;

    @Override
    public void registrarRequisitosDelProyecto(RequisitosDelProyecto requisito) throws Exception {
        if(requisito == null){
            throw new Exception("Campos vacíos");
        }else{
            if(requisito.getId() == null || requisito.getId().equals("")){
                throw new Exception("El ID de los Requisitos es obligatorio");
            }if(requisito.getIdProyectoSoftware() == null || requisito.equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(requisito.getDescripcion() == null || requisito.getDescripcion().equals("")){
                throw new Exception("La Descripcion del Requisito es obligatorio");
            }if(requisito.getTipo() == null || requisito.getTipo().equals("")){
                throw new Exception("El ID del Tipo de Requisito es obligatorio");
            }/*if(requisito.getEstado()){
               }*/
            RequisitosDelProyecto objRequisitos = requesitosProyectoDAO.find(requisito.getId());
            if(objRequisitos !=  null){
                throw new Exception("Los requisitos del proyecto ya se encuentran registrados en la base de datos");
            }else{
                requesitosProyectoDAO.create(objRequisitos);
            }
        }
    }

    @Override
    public void modificarRequisitosDelProyecto(RequisitosDelProyecto requisito) throws Exception {
        if(requisito == null){
            throw new Exception("Campos vacíos");
        }else{
            if(requisito.getId() == null || requisito.getId().equals("")){
                throw new Exception("El ID de los Requisitos es obligatorio");
            }if(requisito.getIdProyectoSoftware() == null || requisito.equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(requisito.getDescripcion() == null || requisito.getDescripcion().equals("")){
                throw new Exception("La Descripcion del Requisito es obligatorio");
            }if(requisito.getTipo() == null || requisito.getTipo().equals("")){
                throw new Exception("El ID del Tipo de Requisito es obligatorio");
            }/*if(requisito.getEstado()){
               }*/
            RequisitosDelProyecto objRequisitos = requesitosProyectoDAO.find(requisito.getId());
            if(objRequisitos !=  null){
                objRequisitos.setId(requisito.getId());
                objRequisitos.setIdProyectoSoftware(requisito.getIdProyectoSoftware());
                objRequisitos.setDescripcion(requisito.getDescripcion());
                objRequisitos.setTipo(requisito.getTipo());
                objRequisitos.setEstado(requisito.getEstado());
                requesitosProyectoDAO.edit(objRequisitos);
            }else{
                throw new Exception("Este requisito del proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public RequisitosDelProyecto consultarxCodigoRequisitosDelProyecto(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Requisito del  Proyecto es obligatorio");
        }else{
            return requesitosProyectoDAO.find(codigo);
        }
    }

    @Override
    public List<RequisitosDelProyecto> consultarTodosRequisitosDelProyecto() throws Exception {
        return requesitosProyectoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
