/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.AreaConocimiento;
import persistencia.AreaConocimientoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class AreaConocimientoLogica implements AreaConocimientoLogicaLocal {
    
    @EJB
    AreaConocimientoFacade ingenieroDAO;

    @Override
    public void registrarAreaConocimiento(AreaConocimiento area) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(area == null){
            throw new Exception("Campos vacíos");
        }else{            
            if(area.getId() == null || area.getId().equals(0)){
                throw new Exception("El id es obligatorio");                
            }
            if(area.getIdIngeniero() == null ){// Llave foranea para identificar el ingeniero
                throw new Exception("El identificador del ingeniero es obligatorio");                
            }
            AreaConocimiento objAreaConocimiento = ingenieroDAO.find(area.getId());
            if(objAreaConocimiento != null){
                throw new Exception("Este área de conocimiento ya existe en la base de datos");                
            }else{
                ingenieroDAO.create(objAreaConocimiento);
            }
        }
    }

    @Override
    public void modificarAreaConocimiento(AreaConocimiento area) throws Exception {
        if(area == null){
            throw new Exception("Campos vacíos");
        }else{            
            if(area.getId() == null || area.getId().equals(0)){
                throw new Exception("El id es obligatorio");                
            }
            if(area.getIdIngeniero() == null ){// Llave foranea para identificar el ingeniero
                throw new Exception("El identificador del ingeniero es obligatorio");                
            }
            AreaConocimiento objAreaConocimiento = ingenieroDAO.find(area.getId());
            if(objAreaConocimiento != null){
                objAreaConocimiento.setIdIngeniero(area.getIdIngeniero());
                ingenieroDAO.edit(objAreaConocimiento);
            }else{
                throw new Exception("Esta area de conocimiento no existe en la base de datos");                
            }
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
