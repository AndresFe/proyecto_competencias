/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoGradosAcademicos;

/**
 *
 * @author andres
 */
@Local
public interface TipoGradosAcademicosLogicaLocal {
    
    public void registrarTipoGradosAcademicos(TipoGradosAcademicos grado) throws Exception;
    public void modificarTipoGradosAcademicos(TipoGradosAcademicos grado) throws Exception;
    public TipoGradosAcademicos consultarxCodigoTipoGradosAcademicos(int codigo) throws Exception;
    public List<TipoGradosAcademicos> consultarTodosTipoGradosAcademicos() throws Exception;
    
}
