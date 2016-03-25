/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.GradosAcademicos;

/**
 *
 * @author andres
 */
@Local
public interface GradosAcademicosLogicaLocal {
    
    public void registrarGradosAcademicos(GradosAcademicos grado) throws Exception;
    public void modificarGradosAcademicos(GradosAcademicos grado) throws Exception;
    public GradosAcademicos consultarxCodigoGradosAcademicos(int codigo) throws Exception;
    public List<GradosAcademicos> consultarTodosGradosAcademicos() throws Exception;
    
}
