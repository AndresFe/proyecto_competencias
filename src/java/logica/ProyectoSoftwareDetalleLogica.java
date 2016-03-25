/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.ProyectoSoftwareDetalle;
import persistencia.ProyectoSoftwareDetalleFacade;

/**
 *
 * @author andres
 */
@Stateless
public class ProyectoSoftwareDetalleLogica implements ProyectoSoftwareDetalleLogicaLocal {

    @EJB
    ProyectoSoftwareDetalleFacade proyectoDetalleDAO;
    
    @Override
    public void registrarProyectoSoftwareDetalle(ProyectoSoftwareDetalle proyecto) throws Exception {
        if(proyecto == null) {
            throw new Exception("Campos vacíos");            
        }else{
            if(proyecto.getIdProyectoSoftware() == null || proyecto.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del proyecto de software es obligatorio");
            }if(proyecto.getCodigoProyecto() == null || proyecto.getCodigoProyecto().equals("")){
                throw new Exception("El Codigo del proyecto es obligatorio");
            }if(proyecto.getNombre() == null || proyecto.getNombre().equals("")){
                throw new Exception("El Nombre del proyecto es obligatorio");
            }if(proyecto.getTipoAreaAplicacion() == null || proyecto.getTipoAreaAplicacion().equals("")){
                throw new Exception("El Tipo de Area de Aplicación del proyecto es obligatorio");
            }if(proyecto.getFechaIngresoAlSistema() == null || proyecto.getFechaIngresoAlSistema().equals("")){
                throw new Exception("El Fecha de ingreso al sistema del proyecto es obligatorio");
            }if(proyecto.getFechaAsignacionProyecto() == null || proyecto.getFechaAsignacionProyecto().equals("")){
                throw new Exception("El Fecha de asignacion del proyecto es obligatorio");
            }if(proyecto.getFechaLiberacion() == null || proyecto.getFechaLiberacion().equals("")){
                throw new Exception("El Fecha de liberacion del proyecto es obligatorio");
            }if(proyecto.getTipoFaseProyecto() == null || proyecto.getTipoFaseProyecto().equals("")){
                throw new Exception("El Tipo de fase de desarrollo del proyecto es obligatorio");
            }if(proyecto.getVersionPrograma() == null || proyecto.getVersionPrograma().equals("")){
                throw new Exception("La version del proyecto es obligatorio");
            }if(proyecto.getLenguaje() == null || proyecto.getLenguaje().equals("")){
                throw new Exception("El ID de los lenguajes asociados al proyecto es obligatorio");
            }if(proyecto.getSistemaOperativoCompatible() == null || proyecto.getSistemaOperativoCompatible().equals("")){
                throw new Exception("El ID de los Sistemas operativos asociados al proyecto es obligatorio");
            }if(proyecto.getBaseDatosCompatible() == null || proyecto.getBaseDatosCompatible().equals("")){
                throw new Exception("El ID de las base de datos asociados al proyecto es obligatorio");
            }if(proyecto.getCostoProyecto() < 0){
                throw new Exception("El Costo asociado al proyecto es obligatorio");
            }
            ProyectoSoftwareDetalle objProyecto = proyectoDetalleDAO.find(proyecto.getIdProyectoSoftware());
            if(objProyecto != null){
                throw new Exception("Este detalle del proyecto de Software ya se encuentra registrado en la base de datos");
            }else{
                proyectoDetalleDAO.create(objProyecto);
            }
        }
    }

    @Override
    public void modificarProyectoSoftwareDetalle(ProyectoSoftwareDetalle proyecto) throws Exception {
        if(proyecto == null) {
            throw new Exception("Campos vacíos");            
        }else{
            if(proyecto.getIdProyectoSoftware() == null || proyecto.getIdProyectoSoftware().equals("")){
                throw new Exception("El ID del proyecto de software es obligatorio");
            }if(proyecto.getCodigoProyecto() == null || proyecto.getCodigoProyecto().equals("")){
                throw new Exception("El Codigo del proyecto es obligatorio");
            }if(proyecto.getNombre() == null || proyecto.getNombre().equals("")){
                throw new Exception("El Nombre del proyecto es obligatorio");
            }if(proyecto.getTipoAreaAplicacion() == null || proyecto.getTipoAreaAplicacion().equals("")){
                throw new Exception("El Tipo de Area de Aplicación del proyecto es obligatorio");
            }if(proyecto.getFechaIngresoAlSistema() == null || proyecto.getFechaIngresoAlSistema().equals("")){
                throw new Exception("El Fecha de ingreso al sistema del proyecto es obligatorio");
            }if(proyecto.getFechaAsignacionProyecto() == null || proyecto.getFechaAsignacionProyecto().equals("")){
                throw new Exception("El Fecha de asignacion del proyecto es obligatorio");
            }if(proyecto.getFechaLiberacion() == null || proyecto.getFechaLiberacion().equals("")){
                throw new Exception("El Fecha de liberacion del proyecto es obligatorio");
            }if(proyecto.getTipoFaseProyecto() == null || proyecto.getTipoFaseProyecto().equals("")){
                throw new Exception("El Tipo de fase de desarrollo del proyecto es obligatorio");
            }if(proyecto.getVersionPrograma() == null || proyecto.getVersionPrograma().equals("")){
                throw new Exception("La version del proyecto es obligatorio");
            }if(proyecto.getLenguaje() == null || proyecto.getLenguaje().equals("")){
                throw new Exception("El ID de los lenguajes asociados al proyecto es obligatorio");
            }if(proyecto.getSistemaOperativoCompatible() == null || proyecto.getSistemaOperativoCompatible().equals("")){
                throw new Exception("El ID de los Sistemas operativos asociados al proyecto es obligatorio");
            }if(proyecto.getBaseDatosCompatible() == null || proyecto.getBaseDatosCompatible().equals("")){
                throw new Exception("El ID de las base de datos asociados al proyecto es obligatorio");
            }if(proyecto.getCostoProyecto() < 0){
                throw new Exception("El Costo asociado al proyecto es obligatorio");
            }
            ProyectoSoftwareDetalle objProyecto = proyectoDetalleDAO.find(proyecto.getIdProyectoSoftware());
            if(objProyecto != null){
                objProyecto.setIdProyectoSoftware(proyecto.getIdProyectoSoftware());
                objProyecto.setCodigoProyecto(proyecto.getCodigoProyecto());
                objProyecto.setNombre(proyecto.getNombre());
                objProyecto.setTipoAreaAplicacion(proyecto.getTipoAreaAplicacion());
                objProyecto.setFechaIngresoAlSistema(proyecto.getFechaIngresoAlSistema());
                objProyecto.setFechaAsignacionProyecto(proyecto.getFechaAsignacionProyecto());
                objProyecto.setFechaLiberacion(proyecto.getFechaLiberacion());
                objProyecto.setTipoFaseProyecto(proyecto.getTipoFaseProyecto());
                objProyecto.setVersionPrograma(proyecto.getVersionPrograma());
                objProyecto.setLenguaje(proyecto.getLenguaje());
                objProyecto.setSistemaOperativoCompatible(proyecto.getSistemaOperativoCompatible());
                objProyecto.setBaseDatosCompatible(proyecto.getBaseDatosCompatible());
                objProyecto.setCostoProyecto(proyecto.getCostoProyecto());
                proyectoDetalleDAO.edit(objProyecto);
            }else{
                throw new Exception("El detalle del proyecto de Software no está registrado en la base de datos");
            }
        }
    }

    @Override
    public ProyectoSoftwareDetalle consultarxCodigoProyectoSoftwareDetalle(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del detalle del Proyecto es obligatorio");
        }else{
            return proyectoDetalleDAO.find(codigo);
        }
    }

    @Override
    public List<ProyectoSoftwareDetalle> consultarTodosProyectoSoftwareDetalle() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return proyectoDetalleDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
