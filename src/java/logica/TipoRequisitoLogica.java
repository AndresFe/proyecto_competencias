/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TipoRequisito;
import persistencia.TipoRequisitoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class TipoRequisitoLogica implements TipoRequisitoLogicaLocal {
    
    @EJB
    TipoRequisitoFacade tipoRequisitoDAO;

    @Override
    public void registrarTipoRequisito(TipoRequisito tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(tipo.getId() == null || tipo.getId().equals("")){
                throw new Exception("El ID del Tipo Requisito es obligatorio");
            }if(tipo.getNombre() == null || tipo.getNombre().equals("")){
                throw new Exception("El Nombre del Tipo de Requisito es obligatorio");
            }
            TipoRequisito objTipoRequisito = tipoRequisitoDAO.find(tipo.getId());
            if(objTipoRequisito != null){
                throw new Exception("Este tipo de Requisito ya se encuentran registrado en la base de datos");
            }else{
                tipoRequisitoDAO.create(objTipoRequisito);
            }
        }
    }

    @Override
    public void modificarTipoRequisito(TipoRequisito tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            if(tipo.getId() == null || tipo.getId().equals("")){
                throw new Exception("El ID del Area de Aplicacion es obligatorio");
            }if(tipo.getNombre() == null || tipo.getNombre().equals("")){
                throw new Exception("El Nombre del Tipo de Requisito es obligatorio");
            }
            TipoRequisito objTipoRequisito = tipoRequisitoDAO.find(tipo.getId());
            if(objTipoRequisito != null){
                objTipoRequisito.setId(tipo.getId());
                objTipoRequisito.setNombre(tipo.getNombre());
                tipoRequisitoDAO.edit(objTipoRequisito);
            }else{
                throw new Exception("Este Tipo de Requisito no esta registrada en la base de datos");
            }
        }
    }

    @Override
    public TipoRequisito consultarxCodigoTipoRequisito(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código Tipo de Requisito es obligatorio");
        }else{
            return tipoRequisitoDAO.find(codigo);
        }
    }

    @Override
    public List<TipoRequisito> consultarTodosTipoRequisito() throws Exception {
        return tipoRequisitoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
