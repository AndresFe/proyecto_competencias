/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TipoEstado;
import persistencia.TipoEstadoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class TipoEstadoLogica implements TipoEstadoLogicaLocal {

    @EJB
    TipoEstadoFacade tipoEstadoDAO;
    
    @Override
    public void registrarTipoEstado(TipoEstado tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(tipo.getId() == null || tipo.getId().equals("")){
                throw new Exception("El ID del Tipo Estado  es obligatorio");
            }if(tipo.getNombreTipoEstado() == null || tipo.getNombreTipoEstado().equals("")){
                throw new Exception("El Nombre del Tipo Estado es obligatorio");
            }
            TipoEstado objTipoEstado = tipoEstadoDAO.find(tipo.getId());
            if(objTipoEstado != null){
                throw new Exception("Este Tipo de Estado ya se encuentran registrado en la base de datos");
            }else{
                tipoEstadoDAO.create(objTipoEstado);
            }
        }
    }

    @Override
    public void modificarTipoEstado(TipoEstado tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(tipo.getId() == null || tipo.getId().equals("")){
                throw new Exception("El ID del Tipo Estado  es obligatorio");
            }if(tipo.getNombreTipoEstado() == null || tipo.getNombreTipoEstado().equals("")){
                throw new Exception("El Nombre del Tipo Estado es obligatorio");
            }
            TipoEstado objTipoEstado = tipoEstadoDAO.find(tipo.getId());
            if(objTipoEstado != null){
                objTipoEstado.setId(tipo.getId());
                objTipoEstado.setNombreTipoEstado(tipo.getNombreTipoEstado());
                tipoEstadoDAO.edit(objTipoEstado);
            }else{
                throw new Exception("Este Tipo de Estado no esta registrada en la base de datos");
            }
        }
    }

    @Override
    public TipoEstado consultarxCodigoTipoEstado(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código Tipo de Estado es obligatorio");
        }else{
            return tipoEstadoDAO.find(codigo);
        }
    }

    @Override
    public List<TipoEstado> consultarTodosTipoEstado() throws Exception {
        return tipoEstadoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
