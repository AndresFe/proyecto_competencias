/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.SeminarioCurso;

/**
 *
 * @author andres
 */
@Local
public interface SeminarioCursoLogicaLocal {
    
    public void registrarIngenieroSo(SeminarioCurso curso) throws Exception;
    public void modificarIngenieroSo(SeminarioCurso curso) throws Exception;
    public SeminarioCurso consultarxCodigoIngenieroSo(int codigo) throws Exception;
    public List<SeminarioCurso> consultarTodosIngenieroSo() throws Exception;
    
}
