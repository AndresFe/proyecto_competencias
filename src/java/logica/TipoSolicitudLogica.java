/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TipoSolicitud;
import persistencia.TipoSolicitudFacade;

/**
 *
 * @author andres
 */
@Stateless
public class TipoSolicitudLogica implements TipoSolicitudLogicaLocal {
    @EJB
    TipoSolicitudFacade tipoSolicitudDAO;
    

    @Override
    public void registrarTipoSolicitud(TipoSolicitud tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(tipo.getId() == null || tipo.getId().equals("")){
                throw new Exception("El ID del Tipo Solicitud  es obligatorio");
            }if(tipo.getNombreTipoSolicitud() == null || tipo.getNombreTipoSolicitud().equals("")){
                throw new Exception("El Nombre del Tipo Solicitud es obligatorio");
            }
            TipoSolicitud objTipoSolicitud = tipoSolicitudDAO.find(tipo.getId());
            if(objTipoSolicitud != null){
                throw new Exception("Este Tipo de Solicitud ya se encuentran registrado en la base de datos");
            }else{
                tipoSolicitudDAO.create(objTipoSolicitud);
            }
        }
    }

    @Override
    public void modificarTipoSolicitud(TipoSolicitud tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(tipo.getId() == null || tipo.getId().equals("")){
                throw new Exception("El ID del Tipo Solicitud  es obligatorio");
            }if(tipo.getNombreTipoSolicitud() == null || tipo.getNombreTipoSolicitud().equals("")){
                throw new Exception("El Nombre del Tipo Solicitud es obligatorio");
            }
            TipoSolicitud objTipoSolicitud = tipoSolicitudDAO.find(tipo.getId());
            if(objTipoSolicitud != null){
                objTipoSolicitud.setId(tipo.getId());
                objTipoSolicitud.setNombreTipoSolicitud(tipo.getNombreTipoSolicitud());
                tipoSolicitudDAO.edit(objTipoSolicitud);
            }else{
                throw new Exception("Este Tipo de Solicitud no esta registrada en la base de datos");
            }
        }
    }

    @Override
    public TipoSolicitud consultarxCodigoTipoSolicitud(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código Tipo de Solicitud es obligatorio");
        }else{
            return tipoSolicitudDAO.find(codigo);
        }
    }

    @Override
    public List<TipoSolicitud> consultarTodosTipoSolicitud() throws Exception {
        return tipoSolicitudDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
