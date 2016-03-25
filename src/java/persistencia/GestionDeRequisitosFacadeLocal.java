/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GestionDeRequisitos;

/**
 *
 * @author andres
 */
@Local
public interface GestionDeRequisitosFacadeLocal {

    void create(GestionDeRequisitos gestionDeRequisitos);

    void edit(GestionDeRequisitos gestionDeRequisitos);

    void remove(GestionDeRequisitos gestionDeRequisitos);

    GestionDeRequisitos find(Object id);

    List<GestionDeRequisitos> findAll();

    List<GestionDeRequisitos> findRange(int[] range);

    int count();
    
}
