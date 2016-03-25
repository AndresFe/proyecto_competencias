/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.IngenieroBaseDatos;
import persistencia.IngenieroBaseDatosFacade;

/**
 *
 * @author andres
 */
@Stateless
public class IngenieroBaseDatosLogica implements IngenieroBaseDatosLogicaLocal {
    
    @EJB
    IngenieroBaseDatosFacade baseDatosDAO;

    @Override
    public void registrarIngenieroBaseDatos(IngenieroBaseDatos baseDatos) throws Exception {
        if(baseDatos == null){
            throw new Exception("Campos vacíos");
        }else{
            if(baseDatos.getAreaConocimiento() == null || baseDatos.getAreaConocimiento().equals("")){
                throw new Exception("Esta identificador del área de conocimiento no existe");
            }if(baseDatos.getIngenieroBaseDatosPK() == null || baseDatos.getIngenieroBaseDatosPK().equals("")){
                throw new Exception("El nombre de la base de datos es obligatorio");
            }
            IngenieroBaseDatos objBaseDatos = baseDatosDAO.find(baseDatos.getAreaConocimiento());
            if(objBaseDatos != null){
                throw new Exception("Esta Base de Datos ya está registrado al ingeniero");
            }else{
                baseDatosDAO.create(objBaseDatos);
            }
        }
    }

    @Override
    public void modificarIngenieroBaseDatos(IngenieroBaseDatos baseDatos) throws Exception {
        if(baseDatos == null){
            throw new Exception("Campos vacíos");
        }else{
            if(baseDatos.getAreaConocimiento() == null || baseDatos.getAreaConocimiento().equals("")){
                throw new Exception("Esta identificador del área de conocimiento no existe");
            }if(baseDatos.getIngenieroBaseDatosPK() == null || baseDatos.getIngenieroBaseDatosPK().equals("")){
                throw new Exception("El nombre de la base de datos es obligatorio");
            }
            IngenieroBaseDatos objBaseDatos = baseDatosDAO.find(baseDatos.getAreaConocimiento());
            if(objBaseDatos != null){
                objBaseDatos.setAreaConocimiento(baseDatos.getAreaConocimiento());
                objBaseDatos.setIngenieroBaseDatosPK(baseDatos.getIngenieroBaseDatosPK());
                baseDatosDAO.edit(objBaseDatos);
            }else{
                throw new Exception("Este nombre de Base de Datos no está registrada en la base de datos");
            }
        }
    }

    @Override
    public IngenieroBaseDatos consultarxCodigoIngenieroBaseDatos(int codigo) throws Exception {
         if(codigo <= 0){
            throw new Exception("El código del Lenguaje es obligatorio");
        }else{
            return baseDatosDAO.find(codigo);
        }
    }

    @Override
    public List<IngenieroBaseDatos> consultarTodosIngenieroBaseDatos() throws Exception {
        return baseDatosDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
