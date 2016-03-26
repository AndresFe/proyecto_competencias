/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.LenguajeProyecto;
import persistencia.LenguajeProyectoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class LenguajeProyectoLogica implements LenguajeProyectoLogicaLocal {
    
    @EJB
    LenguajeProyectoFacade lenguajeProyectoDAO;
    

    @Override
    public void registrarLenguajeProyecto(LenguajeProyecto lenguaje) throws Exception {
        if(lenguaje == null){
            throw new Exception("Campos vacíos");
        }else{
            if(lenguaje.getIdProyectoSoftware() == null || lenguaje.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(lenguaje.getLenguaje() == null || lenguaje.getLenguaje().equals("")){
                throw new Exception("El Lenguaje del Proyecto de Software es obligatorio");
            }
            
            LenguajeProyecto objLenguaje = lenguajeProyectoDAO.find(lenguaje.getIdProyectoSoftware());
            if(objLenguaje != null){
                throw new Exception("Este Lenguaje del Proyecto ya se encuentran registrado en la base de datos");
            }else{
                lenguajeProyectoDAO.create(objLenguaje);
            }
        }
    }

    @Override
    public void modificarLenguajeProyecto(LenguajeProyecto lenguaje) throws Exception {
        if(lenguaje == null){
            throw new Exception("Campos vacíos");
        }else{
            if(lenguaje.getIdProyectoSoftware() == null || lenguaje.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(lenguaje.getLenguaje() == null || lenguaje.getLenguaje().equals("")){
                throw new Exception("El Lenguaje del Proyecto de Software es obligatorio");
            }
            
            LenguajeProyecto objLenguaje = lenguajeProyectoDAO.find(lenguaje.getIdProyectoSoftware());
            if(objLenguaje != null){
                objLenguaje.setIdProyectoSoftware(lenguaje.getIdProyectoSoftware());
                objLenguaje.setLenguaje(lenguaje.getLenguaje());
                lenguajeProyectoDAO.edit(objLenguaje);
            }else{
                throw new Exception("Esta Lenguaje del Proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public LenguajeProyecto consultarxCodigoLenguajeProyecto(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Lenguaje del Proyecto es obligatorio");
        }else{
            return lenguajeProyectoDAO.find(codigo);
        }
    }

    @Override
    public List<LenguajeProyecto> consultarTodosLenguajeProyecto() throws Exception {
        return lenguajeProyectoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
