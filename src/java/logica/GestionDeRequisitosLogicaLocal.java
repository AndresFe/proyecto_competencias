/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.GestionDeRequisitos;

/**
 *
 * @author andres
 */
@Local
public interface GestionDeRequisitosLogicaLocal {
    
    public void registrarGestionDeRequisitos(GestionDeRequisitos requisito) throws Exception;
    public void modificarGestionDeRequisitos(GestionDeRequisitos requisito) throws Exception;
    public GestionDeRequisitos consultarxCodigoGestionDeRequisitos(int codigo) throws Exception;
    public List<GestionDeRequisitos> consultarTodosGestionDeRequisitos() throws Exception;
    
}
