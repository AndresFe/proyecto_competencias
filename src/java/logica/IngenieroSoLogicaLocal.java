/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenieroSo;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroSoLogicaLocal {
    
    public void registrarIngenieroSo(IngenieroSo sistemaO) throws Exception;
    public void modificarIngenieroSo(IngenieroSo sistemaO) throws Exception;
    public IngenieroSo consultarxCodigoIngenieroSo(int codigo) throws Exception;
    public List<IngenieroSo> consultarTodosIngenieroSo() throws Exception;
    
}
