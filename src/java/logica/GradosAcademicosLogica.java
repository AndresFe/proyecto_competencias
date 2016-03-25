/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.GradosAcademicos;
import persistencia.GradosAcademicosFacade;

/**
 *
 * @author andres
 */
@Stateless
    public class GradosAcademicosLogica implements GradosAcademicosLogicaLocal {
    
    @EJB
    GradosAcademicosFacade gradosAcademicosDAO;

    @Override
    public void registrarGradosAcademicos(GradosAcademicos grado) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(grado == null){
            throw new Exception("Campos vacíos");
        }else{
            if(grado.getId() == null || grado.getId().equals("")){
                throw new Exception("El ID del grado academico es obligatorio");
            }if(grado.getIdIngeniero() == null || grado.getIdIngeniero().equals("")){
                throw new Exception("El ID del ingeniero es obligatorio");
            }if(grado.getTipoGradoAcademico() == null || grado.getTipoGradoAcademico().equals("")){
                throw new Exception("El ID del tipo de grado académico es obligatorio");
            }if(grado.getCentroFormacion() == null || grado.getCentroFormacion().equals("")){
                throw new Exception("El centro de formación del grado academico es obligatorio");
            }if(grado.getTituloObtenido() == null || grado.getTituloObtenido().equals("")){
                throw new Exception("El Titulo obtenido es obligatorio");
            }
            GradosAcademicos objGradosAcademicos = gradosAcademicosDAO.find(grado.getId());
            if(objGradosAcademicos != null){
                throw new Exception("Este grado académico ya está registrado");
            }else{
                gradosAcademicosDAO.create(objGradosAcademicos);
            }
        }
    }

    @Override
    public void modificarGradosAcademicos(GradosAcademicos grado) throws Exception {
        if(grado == null){
            throw new Exception("Campos vacíos");
        }else{
            if(grado.getId() == null || grado.getId().equals("")){
                throw new Exception("El ID del grado academico es obligatorio");
            }if(grado.getIdIngeniero() == null || grado.getIdIngeniero().equals("")){
                throw new Exception("El ID del ingeniero es obligatorio");
            }if(grado.getTipoGradoAcademico() == null || grado.getTipoGradoAcademico().equals("")){
                throw new Exception("El ID del tipo de grado académico es obligatorio");
            }if(grado.getCentroFormacion() == null || grado.getCentroFormacion().equals("")){
                throw new Exception("El centro de formación del grado academico es obligatorio");
            }if(grado.getTituloObtenido() == null || grado.getTituloObtenido().equals("")){
                throw new Exception("El Titulo obtenido es obligatorio");
            }
            GradosAcademicos objGradosAcademicos = gradosAcademicosDAO.find(grado.getId());
            if(objGradosAcademicos != null){
                objGradosAcademicos.setId(grado.getId());
                objGradosAcademicos.setIdIngeniero(grado.getIdIngeniero());
                objGradosAcademicos.setTipoGradoAcademico(grado.getTipoGradoAcademico());
                objGradosAcademicos.setCentroFormacion(grado.getCentroFormacion());
                objGradosAcademicos.setTituloObtenido(grado.getTituloObtenido());
                gradosAcademicosDAO.edit(objGradosAcademicos);
            }else{
                throw new Exception("Este Grado Academico no está en la base de datos");
            }
        }
    }

    @Override
    public GradosAcademicos consultarxCodigoGradosAcademicos(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Sistema Operativo es obligatorio");
        }else{
            return gradosAcademicosDAO.find(codigo);
        }
    }

    @Override
    public List<GradosAcademicos> consultarTodosGradosAcademicos() throws Exception {
        return gradosAcademicosDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
