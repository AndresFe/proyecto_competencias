/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.HoraTrabajoJunior;

/**
 *
 * @author andres
 */
@Local
public interface HoraTrabajoJuniorFacadeLocal {

    void create(HoraTrabajoJunior horaTrabajoJunior);

    void edit(HoraTrabajoJunior horaTrabajoJunior);

    void remove(HoraTrabajoJunior horaTrabajoJunior);

    HoraTrabajoJunior find(Object id);

    List<HoraTrabajoJunior> findAll();

    List<HoraTrabajoJunior> findRange(int[] range);

    int count();
    
}
