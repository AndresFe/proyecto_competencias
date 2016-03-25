/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.AreaConocimiento;

/**
 *
 * @author andres
 */
@Local
public interface AreaConocimientoLogicaLocal {
    
    public void registrarAreaConocimiento(AreaConocimiento area) throws Exception;
    public void modificarAreaConocimiento(AreaConocimiento area) throws Exception;
    
}
