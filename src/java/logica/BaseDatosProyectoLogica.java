/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.BaseDatosProyecto;
import persistencia.BaseDatosProyectoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class BaseDatosProyectoLogica implements BaseDatosProyectoLogicaLocal {
    
    @EJB
    BaseDatosProyectoFacade baseDatosDAO;

    @Override
    public void registrarBaseDatosProyecto(BaseDatosProyecto baseDatos) throws Exception {
        if(baseDatos == null){
            throw new Exception("Campos vacíos");
        }else{
           if(baseDatos.getIdProyectoSoftware() == null || baseDatos.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(baseDatos.getNombreBaseDatos() == null || baseDatos.getNombreBaseDatos().equals("")){
                throw new Exception("El Nombre de la Base de Datos del Proyecto de Software es obligatorio");
            }
            
            BaseDatosProyecto objBaseDatos = baseDatosDAO.find(baseDatos.getIdProyectoSoftware());
            if(objBaseDatos != null){
                throw new Exception("Esta Base de Datos del Proyecto ya se encuentran registrado en la base de datos");
            }else{
                baseDatosDAO.create(objBaseDatos);
            }
        }
    }

    @Override
    public void modificarBaseDatosProyecto(BaseDatosProyecto baseDatos) throws Exception {
        if(baseDatos == null){
            throw new Exception("Campos vacíos");
        }else{
           if(baseDatos.getIdProyectoSoftware() == null || baseDatos.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(baseDatos.getNombreBaseDatos() == null || baseDatos.getNombreBaseDatos().equals("")){
                throw new Exception("El Nombre de la Base de Datos del Proyecto de Software es obligatorio");
            }
            
            BaseDatosProyecto objBaseDatos = baseDatosDAO.find(baseDatos.getIdProyectoSoftware());
            if(objBaseDatos != null){
                objBaseDatos.setIdProyectoSoftware(baseDatos.getIdProyectoSoftware());
                objBaseDatos.setNombreBaseDatos(baseDatos.getNombreBaseDatos());
                baseDatosDAO.edit(objBaseDatos);
            }else{
                throw new Exception("Esta Base de Datos del Proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public BaseDatosProyecto consultarxCodigoBaseDatosProyecto(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código de la Base Datos del Proyecto es obligatorio");
        }else{
            return baseDatosDAO.find(codigo);
        }
    }

    @Override
    public List<BaseDatosProyecto> consultarTodosBaseDatosProyecto() throws Exception {
        return baseDatosDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
