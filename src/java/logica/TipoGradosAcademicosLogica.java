/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.TipoGradosAcademicos;
import persistencia.TipoGradosAcademicosFacade;

/**
 *
 * @author andres
 */
@Stateless
public class TipoGradosAcademicosLogica implements TipoGradosAcademicosLogicaLocal {
    
    @EJB
    TipoGradosAcademicosFacade tipoGradosDAO;

    @Override
    public void registrarTipoGradosAcademicos(TipoGradosAcademicos grado) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(grado == null){
            throw new Exception("Campos vacíos");
        }else{
            if(grado.getId() == null || grado.getId().equals("")){
                throw new Exception("El ID del tipo de grado es obligatorio");
            }if(grado.getNombreTipoGrado() == null || grado.getNombreTipoGrado().equals("")){
                throw new Exception("El Nombre del tipo de grado es obligatorio");
            }
            TipoGradosAcademicos objTipoGrado = tipoGradosDAO.find(grado.getId());
            if(objTipoGrado != null){
                throw new Exception("Este tipo de grado ya está registrado");
            }else{
                tipoGradosDAO.create(objTipoGrado);
            }
        }
    }

    @Override
    public void modificarTipoGradosAcademicos(TipoGradosAcademicos grado) throws Exception {
        if(grado == null){
            throw new Exception("Campos vacíos");
        }else{
            if(grado.getId() == null || grado.getId().equals("")){
                throw new Exception("El ID del tipo de grado es obligatorio");
            }if(grado.getNombreTipoGrado() == null || grado.getNombreTipoGrado().equals("")){
                throw new Exception("El Nombre del tipo de grado es obligatorio");
            }
            TipoGradosAcademicos objTipoGrado = tipoGradosDAO.find(grado.getId());
            if(objTipoGrado != null){
                objTipoGrado.setId(grado.getId());
                objTipoGrado.setNombreTipoGrado(grado.getNombreTipoGrado());
                tipoGradosDAO.edit(objTipoGrado);
            }else{
                throw new Exception("Este tipo de grado no está en la base de datos");
            }
        }
    }

    @Override
    public TipoGradosAcademicos consultarxCodigoTipoGradosAcademicos(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Sistema Operativo es obligatorio");
        }else{
            return tipoGradosDAO.find(codigo);
        }
    }

    @Override
    public List<TipoGradosAcademicos> consultarTodosTipoGradosAcademicos() throws Exception {
        return tipoGradosDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
