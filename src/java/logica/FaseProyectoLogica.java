/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.FaseProyecto;
import persistencia.FaseProyectoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class FaseProyectoLogica implements FaseProyectoLogicaLocal {
    
    @EJB
    FaseProyectoFacade faseProyectoDAO;

    @Override
    public void registrarFaseProyecto(FaseProyecto fase) throws Exception {
        if(fase == null){
            throw new Exception("Campos vacíos");
        }else{
            if(fase.getId() == null || fase.getId().equals("")){
                throw new Exception("El ID de la Fase del Proyecto es obligatorio");
            }if(fase.getNombreFaseProyecto() == null || fase.getNombreFaseProyecto().equals("")){
                throw new Exception("El Nombre de la Fase del Proyecto es obligatorio");
            }if(fase.getFecha() == null || fase.getFecha().equals("")){
                throw new Exception("La Fecha de la Fase del Proyecto es obligatorio");
            }/*if(fase.getEstado()){
                throw new Exception("El Estado de la Fase del Proyecto es obligatorio");
            }*/
            FaseProyecto objFase = faseProyectoDAO.find(fase.getId());
            if(objFase != null){
                throw new Exception("Esta Fase del Proyecto ya se encuentran registrado en la base de datos");
            }else{
                faseProyectoDAO.create(objFase);
            }
        }
    }

    @Override
    public void modificarFaseProyecto(FaseProyecto fase) throws Exception {
        if(fase == null){
            throw new Exception("Campos vacíos");
        }else{
            if(fase.getId() == null || fase.getId().equals("")){
                throw new Exception("El ID de la Fase del Proyecto es obligatorio");
            }if(fase.getNombreFaseProyecto() == null || fase.getNombreFaseProyecto().equals("")){
                throw new Exception("El Nombre de la Fase del Proyecto es obligatorio");
            }if(fase.getFecha() == null || fase.getFecha().equals("")){
                throw new Exception("La Fecha de la Fase del Proyecto es obligatorio");
            }/*if(fase.getEstado()){
                throw new Exception("El Estado de la Fase del Proyecto es obligatorio");
            }*/
            FaseProyecto objFase = faseProyectoDAO.find(fase.getId());
            if(objFase != null){
                objFase.setId(fase.getId());
                objFase.setNombreFaseProyecto(fase.getNombreFaseProyecto());
                objFase.setFecha(fase.getFecha());
                objFase.setEstado(fase.getEstado());
                faseProyectoDAO.edit(objFase);
            }else{
                throw new Exception("Esta Fase del Proyecto no se encuentra registrado en la base de datos");
            }
        }
    }

    @Override
    public FaseProyecto consultarxCodigoFaseProyecto(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código de la Fase del Proyecto es obligatorio");
        }else{
            return faseProyectoDAO.find(codigo);
        }
    }

    @Override
    public List<FaseProyecto> consultarTodosFaseProyecto() throws Exception {
        return faseProyectoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
