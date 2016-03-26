/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.SistemaOperativoProyecto;

/**
 *
 * @author andres
 */
@Local
public interface SistemaOperativoProyectoLogicaLocal {
    
    public void registrarSistemaOperativoProyecto(SistemaOperativoProyecto sistemaO) throws Exception;
    public void modificarSistemaOperativoProyecto(SistemaOperativoProyecto sistemaO) throws Exception;
    public SistemaOperativoProyecto consultarxCodigoSistemaOperativoProyecto(int codigo) throws Exception;
    public List<SistemaOperativoProyecto> consultarTodosSistemaOperativoProyecto() throws Exception;
    
}
