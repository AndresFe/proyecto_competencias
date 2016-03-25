/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.SeminarioCurso;
import persistencia.SeminarioCursoFacade;

/**
 *
 * @author andres
 */
@Stateless
public class SeminarioCursoLogica implements SeminarioCursoLogicaLocal {
    
    @EJB
    SeminarioCursoFacade seminarioCursoDAO;

    @Override
    public void registrarIngenieroSo(SeminarioCurso curso) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(curso == null){
            throw new Exception("Campos vacíos");
        }else{
            if(curso.getId() == null || curso.getId().equals("")){
                throw new Exception("El id es obligatorio");
            }if(curso.getIdIngeniero() == null || curso.getIdIngeniero().equals("")){
                throw new Exception("El id del ingeniero es obligatorio");
            }if(curso.getNombreSeminarioCurso() == null || curso.getNombreSeminarioCurso().equals("")){
                throw new Exception("El nombre del seminario/curso es obligatorio");
            }if(curso.getLugarSeminarioCurso() == null || curso.getLugarSeminarioCurso().equals("")){
                throw new Exception("El Lugar del seminario/curso es obligatorio");
            }if(curso.getFechaInicioCursoSeminario() == null || curso.getFechaInicioCursoSeminario().equals("")){
                throw new Exception("La fecha de inicio del seminario/curso es obligatorio");
            }if(curso.getFechaFinCursoSeminario() == null || curso.getFechaFinCursoSeminario().equals("")){
                throw new Exception("La fecha de finalización del seminario/curso es obligatorio");
            }
            SeminarioCurso objSeminarioCurso = seminarioCursoDAO.find(curso.getId());
            if(objSeminarioCurso != null){
                throw new Exception("Este seminario/curso ya esta registrado al ingeniero");
            }else{
                seminarioCursoDAO.create(objSeminarioCurso);
            }
        }
    }

    @Override
    public void modificarIngenieroSo(SeminarioCurso curso) throws Exception {
        if(curso == null){
            throw new Exception("Campos vacíos");
        }else{
            if(curso.getId() == null || curso.getId().equals("")){
                throw new Exception("El id es obligatorio");
            }if(curso.getIdIngeniero() == null || curso.getIdIngeniero().equals("")){
                throw new Exception("El id del ingeniero es obligatorio");
            }if(curso.getNombreSeminarioCurso() == null || curso.getNombreSeminarioCurso().equals("")){
                throw new Exception("El nombre del seminario/curso es obligatorio");
            }if(curso.getLugarSeminarioCurso() == null || curso.getLugarSeminarioCurso().equals("")){
                throw new Exception("El Lugar del seminario/curso es obligatorio");
            }if(curso.getFechaInicioCursoSeminario() == null || curso.getFechaInicioCursoSeminario().equals("")){
                throw new Exception("La fecha de inicio del seminario/curso es obligatorio");
            }if(curso.getFechaFinCursoSeminario() == null || curso.getFechaFinCursoSeminario().equals("")){
                throw new Exception("La fecha de finalización del seminario/curso es obligatorio");
            }
            SeminarioCurso objSeminarioCurso = seminarioCursoDAO.find(curso.getId());
            if(objSeminarioCurso != null){
                objSeminarioCurso.setId(curso.getId());
                objSeminarioCurso.setIdIngeniero(curso.getIdIngeniero());
                objSeminarioCurso.setNombreSeminarioCurso(curso.getNombreSeminarioCurso());
                objSeminarioCurso.setLugarSeminarioCurso(curso.getLugarSeminarioCurso());
                objSeminarioCurso.setFechaInicioCursoSeminario(curso.getFechaInicioCursoSeminario());
                objSeminarioCurso.setFechaFinCursoSeminario(curso.getFechaFinCursoSeminario());
                seminarioCursoDAO.edit(objSeminarioCurso);
            }else{
                throw new Exception("Este seminario/curso no está registrado en la base de datos");
            }
        }
    }

    @Override
    public SeminarioCurso consultarxCodigoIngenieroSo(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Sistema Operativo es obligatorio");
        }else{
            return seminarioCursoDAO.find(codigo);
        }
    }

    @Override
    public List<SeminarioCurso> consultarTodosIngenieroSo() throws Exception {
        return seminarioCursoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
