/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TipoAreaAplicacion;
import persistencia.TipoAreaAplicacionFacade;

/**
 *
 * @author andres
 */
@Stateless
public class TipoAreaAplicacionLogica implements TipoAreaAplicacionLogicaLocal {
    
    @EJB
    TipoAreaAplicacionFacade tipoAreaAplicacionDAO;

    @Override
    public void registrarTipoAreaAplicacion(TipoAreaAplicacion area) throws Exception {
        if(area == null){
            throw new Exception("Campos vacíos");
        }else{
            if(area.getId() == null || area.getId().equals("")){
                throw new Exception("El ID del Area de Aplicacion es obligatorio");
            }if(area.getNombreTipo() == null || area.getNombreTipo().equals("")){
                throw new Exception("El Nombre del Tipo del Area de Aplicacion es obligatorio");
            }
            TipoAreaAplicacion objTipoArea = tipoAreaAplicacionDAO.find(area.getId());
            if(objTipoArea != null){
                throw new Exception("Este tipo de Area de Aplicacion ya se encuentran registrados en la base de datos");
            }else{
                tipoAreaAplicacionDAO.create(objTipoArea);
            }
        }
    }

    @Override
    public void modificarTipoAreaAplicacion(TipoAreaAplicacion area) throws Exception {
        if(area == null){
            throw new Exception("Campos vacíos");
        }else{
            if(area.getId() == null || area.getId().equals("")){
                throw new Exception("El ID del Area de Aplicacion es obligatorio");
            }if(area.getNombreTipo() == null || area.getNombreTipo().equals("")){
                throw new Exception("El Nombre del Tipo del Area de Aplicacion es obligatorio");
            }
            TipoAreaAplicacion objTipoArea = tipoAreaAplicacionDAO.find(area.getId());
            if(objTipoArea != null){
                objTipoArea.setId(area.getId());
                objTipoArea.setNombreTipo(area.getNombreTipo());
                tipoAreaAplicacionDAO.edit(objTipoArea);
            }else{
                throw new Exception("Este tipo de Area de Aplicacion no esta registrada en la base de datos");
            }
        }
    }

    @Override
    public TipoAreaAplicacion consultarxCodigoTipoAreaAplicacion(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código Tipo de Area de Aplicacion es obligatorio");
        }else{
            return tipoAreaAplicacionDAO.find(codigo);
        }
    }

    @Override
    public List<TipoAreaAplicacion> consultarTodosTipoAreaAplicacion() throws Exception {
        return tipoAreaAplicacionDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
