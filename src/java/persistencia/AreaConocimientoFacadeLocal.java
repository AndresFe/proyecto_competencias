/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.AreaConocimiento;

/**
 *
 * @author andres
 */
@Local
public interface AreaConocimientoFacadeLocal {

    void create(AreaConocimiento areaConocimiento);

    void edit(AreaConocimiento areaConocimiento);

    void remove(AreaConocimiento areaConocimiento);

    AreaConocimiento find(Object id);

    List<AreaConocimiento> findAll();

    List<AreaConocimiento> findRange(int[] range);

    int count();
    
}
