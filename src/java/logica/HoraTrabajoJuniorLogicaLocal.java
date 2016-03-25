/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.HoraTrabajoJunior;

/**
 *
 * @author andres
 */
@Local
public interface HoraTrabajoJuniorLogicaLocal {
    
    public void registrarHoraTrabajoJunior(HoraTrabajoJunior hora) throws Exception;
    public void modificarHoraTrabajoJunior(HoraTrabajoJunior hora) throws Exception;
    public HoraTrabajoJunior consultarxCodigoHoraTrabajoJunior(int codigo) throws Exception;
    public List<HoraTrabajoJunior> consultarTodosHoraTrabajoJunior() throws Exception;
    
}
