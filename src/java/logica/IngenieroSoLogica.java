/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.IngenieroSo;
import persistencia.IngenieroSoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class IngenieroSoLogica implements IngenieroSoLogicaLocal {
    
    @EJB
    IngenieroSoFacade sistemaOperativoDAO;

    @Override
    public void registrarIngenieroSo(IngenieroSo sistemaO) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(sistemaO == null){
            throw new Exception("Campos vacíos");
        }else{
            if(sistemaO.getAreaConocimiento() == null){
                throw new Exception("Esta identificador del área de conocimiento es obligatorio");
            }if(sistemaO.getIngenieroSoPK() == null){
                throw new Exception("El nombre del Sistema Operativo es obligatorio");
            }
            IngenieroSo objSistemaO = sistemaOperativoDAO.find(sistemaO.getAreaConocimiento());
            if(objSistemaO != null){
                throw new Exception("Este sistema operativo ya esta registrado al ingeniero");
            }else{
                sistemaOperativoDAO.create(objSistemaO);
            }
        }
    }

    @Override
    public void modificarIngenieroSo(IngenieroSo sistemaO) throws Exception {
        if(sistemaO == null){
            throw new Exception("Campos vacíos");
        }else{
            if(sistemaO.getAreaConocimiento() == null){
                throw new Exception("Esta identificador del área de conocimiento no existe");
            }if(sistemaO.getIngenieroSoPK() == null){
                throw new Exception("El nombre del Sistema Operativo es obligatorio");
            }
            IngenieroSo objSistemaO = sistemaOperativoDAO.find(sistemaO.getAreaConocimiento());
            if(objSistemaO != null){
                objSistemaO.setAreaConocimiento(sistemaO.getAreaConocimiento());
                objSistemaO.setIngenieroSoPK(sistemaO.getIngenieroSoPK());
                sistemaOperativoDAO.edit(objSistemaO);
            }else{
                throw new Exception("Este sistema operativo no está registrado en la base de datos");
            }
        }
    }

    @Override
    public IngenieroSo consultarxCodigoIngenieroSo(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Sistema Operativo es obligatorio");
        }else{
            return sistemaOperativoDAO.find(codigo);
        }
    }

    @Override
    public List<IngenieroSo> consultarTodosIngenieroSo() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return sistemaOperativoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
