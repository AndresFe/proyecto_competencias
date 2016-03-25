/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TipoIngeniero;
import persistencia.TipoIngenieroFacade;

/**
 *
 * @author andres
 */
@Stateless
public class TipoIngenieroLogica implements TipoIngenieroLogicaLocal {
    
    @EJB
    TipoIngenieroFacade ingenieroDAO;

    @Override
    public void registrarTipoIngeniero(TipoIngeniero tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            /*if(tipo.getId() == null || tipo.getId().equals(0)){
                throw new Exception("El id es obligatorio");                
            } */
            
            if(tipo.getNombreTipoIngeniero() == null || tipo.getNombreTipoIngeniero().equals("")){
                throw new Exception("El Nombre del tipo de ingeniero es obligatorio");                
            }
            TipoIngeniero objTipo = ingenieroDAO.find(tipo.getId());
            if(objTipo != null){
                throw new Exception("Este nombre de tipo de ingeniero ya existe en la base de datos");                
            }else{
                ingenieroDAO.create(objTipo);
            }
        }
    }

    @Override
    public void modificarTipoIngeniero(TipoIngeniero tipo) throws Exception {
        if(tipo == null){
            throw new Exception("Campos vacíos");
        }else{
            /*if(tipo.getId() == null || tipo.getId().equals(0)){
                throw new Exception("El id es obligatorio");                
            } */
            
            if(tipo.getNombreTipoIngeniero() == null || tipo.getNombreTipoIngeniero().equals("")){
                throw new Exception("El Nombre del tipo de ingeniero es obligatorio");                
            }
            TipoIngeniero objTipo = ingenieroDAO.find(tipo.getId());
            if(objTipo != null){
                objTipo.setNombreTipoIngeniero(tipo.getNombreTipoIngeniero());
                ingenieroDAO.edit(objTipo);
            }else{
                throw new Exception("Este Nombre del tipo de ingeniero no existe en la base de datos");                
            }
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
