/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.SistemaOperativoProyecto;
import persistencia.SistemaOperativoProyectoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class SistemaOperativoProyectoLogica implements SistemaOperativoProyectoLogicaLocal {
    
    @EJB
    SistemaOperativoProyectoFacade sistemaOperativoProyectoDAO;

    @Override
    public void registrarSistemaOperativoProyecto(SistemaOperativoProyecto sistemaO) throws Exception {
        if(sistemaO == null){
            throw new Exception("Campos vacíos");
        }else{
            if(sistemaO.getIdProyectoSoftware() == null || sistemaO.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(sistemaO.getNombreSistemaOperativo() == null || sistemaO.getNombreSistemaOperativo().equals("")){
                throw new Exception("El Sistema Operativo del Proyecto de Software es obligatorio");
            }
            SistemaOperativoProyecto objSistemaOperativo = sistemaOperativoProyectoDAO.find(sistemaO.getIdProyectoSoftware());
            if(objSistemaOperativo != null){
                throw new Exception("Este Sistema Operativo del Proyecto ya se encuentran registrado en la base de datos");
            }else{
                sistemaOperativoProyectoDAO.create(objSistemaOperativo);
            }            
        }
    }

    @Override
    public void modificarSistemaOperativoProyecto(SistemaOperativoProyecto sistemaO) throws Exception {
        if(sistemaO == null){
            throw new Exception("Campos vacíos");
        }else{
            if(sistemaO.getIdProyectoSoftware() == null || sistemaO.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del Proyecto de Software es obligatorio");
            }if(sistemaO.getNombreSistemaOperativo() == null || sistemaO.getNombreSistemaOperativo().equals("")){
                throw new Exception("El Sistema Operativo del Proyecto de Software es obligatorio");
            }
            SistemaOperativoProyecto objSistemaOperativo = sistemaOperativoProyectoDAO.find(sistemaO.getIdProyectoSoftware());
            if(objSistemaOperativo != null){
                objSistemaOperativo.setIdProyectoSoftware(sistemaO.getIdProyectoSoftware());
                objSistemaOperativo.setNombreSistemaOperativo(sistemaO.getNombreSistemaOperativo());
                sistemaOperativoProyectoDAO.edit(objSistemaOperativo);
            }else{
                throw new Exception("Este Sistema Operativo del Proyecto no está registrado en la base de datos");
            }
        }
    }

    @Override
    public SistemaOperativoProyecto consultarxCodigoSistemaOperativoProyecto(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Lenguaje del Proyecto es obligatorio");
        }else{
            return sistemaOperativoProyectoDAO.find(codigo);
        }
    }

    @Override
    public List<SistemaOperativoProyecto> consultarTodosSistemaOperativoProyecto() throws Exception {
        return sistemaOperativoProyectoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
