/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.IngenieroLenguaje;
import persistencia.IngenieroLenguajeFacade;

/**
 *
 * @author andres
 */
@Stateless
public class IngenieroLenguajeLogica implements IngenieroLenguajeLogicaLocal {
    
    @EJB
    IngenieroLenguajeFacade lenguajeDAO;

    @Override
    public void registrarIngenieroLenguaje(IngenieroLenguaje lenguaje) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(lenguaje == null){
            throw new Exception("Campos vacíos");
        }else{
            if(lenguaje.getAreaConocimiento() == null){ //
                throw new Exception("Esta identificador del área de conocimiento no existe");
            }if(lenguaje.getIngenieroLenguajePK() == null || lenguaje.getIngenieroLenguajePK().equals("")){
                throw new Exception("El nombre del Lenguaje es obligatorio");
            }
            IngenieroLenguaje objIngenieroLenguaje = lenguajeDAO.find(lenguaje);
            if(objIngenieroLenguaje != null){
                throw new Exception("Este lenguaje ya esta registrado al ingeniero");
            }else{
                lenguajeDAO.create(objIngenieroLenguaje);
            }
        }
    }

    @Override
    public void modificarIngenieroLenguaje(IngenieroLenguaje lenguaje) throws Exception {
        if(lenguaje == null){
            throw new Exception("Campos vacíos");
        }else{
            if(lenguaje.getAreaConocimiento() == null){ //
                throw new Exception("Esta identificador del área de conocimiento no existe");
            }if(lenguaje.getIngenieroLenguajePK() == null || lenguaje.getIngenieroLenguajePK().equals("")){
                throw new Exception("El nombre del Lenguaje es obligatorio");
            }
            IngenieroLenguaje objIngenieroLenguaje = lenguajeDAO.find(lenguaje);
            if(objIngenieroLenguaje != null){
                objIngenieroLenguaje.setAreaConocimiento(lenguaje.getAreaConocimiento());
                objIngenieroLenguaje.setIngenieroLenguajePK(lenguaje.getIngenieroLenguajePK());
                lenguajeDAO.edit(objIngenieroLenguaje);
            }else{
                throw new Exception("Este lenguaje no está en la base de datos");
            }
        }
    }

    @Override
    public IngenieroLenguaje consultarxCodigoIngenieroLenguaje(int codigo) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(codigo <= 0){
            throw new Exception("El código del Lenguaje es obligatorio");
        }else{
            return lenguajeDAO.find(codigo);
        }
    }

    @Override
    public List<IngenieroLenguaje> consultarTodosIngenieroLenguaje() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return lenguajeDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
