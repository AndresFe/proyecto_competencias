/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.SistemaOperativoProyecto;

/**
 *
 * @author andres
 */
@Local
public interface SistemaOperativoProyectoFacadeLocal {

    void create(SistemaOperativoProyecto sistemaOperativoProyecto);

    void edit(SistemaOperativoProyecto sistemaOperativoProyecto);

    void remove(SistemaOperativoProyecto sistemaOperativoProyecto);

    SistemaOperativoProyecto find(Object id);

    List<SistemaOperativoProyecto> findAll();

    List<SistemaOperativoProyecto> findRange(int[] range);

    int count();
    
}
