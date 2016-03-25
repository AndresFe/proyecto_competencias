/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.PresupuestoJefeDesarrollo;

/**
 *
 * @author andres
 */
@Local
public interface PresupuestoJefeDesarrolloLogicaLocal {
    
    public void registrarPresupuestoJefeDesarrollo(PresupuestoJefeDesarrollo cantidad) throws Exception;
    public void modificarPresupuestoJefeDesarrollo(PresupuestoJefeDesarrollo cantidad) throws Exception;
    public PresupuestoJefeDesarrollo consultarxCodigoPresupuestoJefeDesarrollo(int codigo) throws Exception;
    public List<PresupuestoJefeDesarrollo> consultarTodosPresupuestoJefeDesarrollo() throws Exception;
}
