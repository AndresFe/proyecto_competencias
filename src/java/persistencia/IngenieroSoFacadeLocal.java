/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.IngenieroSo;

/**
 *
 * @author andres
 */
@Local
public interface IngenieroSoFacadeLocal {

    void create(IngenieroSo ingenieroSo);

    void edit(IngenieroSo ingenieroSo);

    void remove(IngenieroSo ingenieroSo);

    IngenieroSo find(Object id);

    List<IngenieroSo> findAll();

    List<IngenieroSo> findRange(int[] range);

    int count();
    
}
