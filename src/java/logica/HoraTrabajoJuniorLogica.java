/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.HoraTrabajoJunior;
import persistencia.HoraTrabajoJuniorFacade;

/**
 *
 * @author andres
 */
@Stateless
public class HoraTrabajoJuniorLogica implements HoraTrabajoJuniorLogicaLocal {
    
    @EJB
    HoraTrabajoJuniorFacade horaTrabajoDAO;

    @Override
    public void registrarHoraTrabajoJunior(HoraTrabajoJunior hora) throws Exception {
        if(hora == null){
            throw new Exception("Campos vacíos");
        }else{
            if(hora.getIdIngeniero() == null || hora.getIdIngeniero().equals("")){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(hora.getCantidadHoraTrabajo() <= 0){
                throw new Exception("El numero de horas de trabajo del Ingeniero es obligatorio");
            }
            HoraTrabajoJunior objHoraTrabajoJunior = horaTrabajoDAO.find(hora.getIdIngeniero());
            if(objHoraTrabajoJunior != null){
                throw new Exception("Las horas de trabajo de este ingeniero junior ya están registradas");
            }else{
                horaTrabajoDAO.create(objHoraTrabajoJunior);
            }
        }
    }

    @Override
    public void modificarHoraTrabajoJunior(HoraTrabajoJunior hora) throws Exception {
        if(hora == null){
            throw new Exception("Campos vacíos");
        }else{
            if(hora.getIdIngeniero() == null || hora.getIdIngeniero().equals("")){
                throw new Exception("El ID del Ingeniero es obligatorio");
            }if(hora.getCantidadHoraTrabajo() <= 0){
                throw new Exception("El numero de horas de trabajo del Ingeniero es obligatorio");
            }
            HoraTrabajoJunior objHoraTrabajoJunior = horaTrabajoDAO.find(hora.getIdIngeniero());
            if(objHoraTrabajoJunior != null){
                objHoraTrabajoJunior.setIdIngeniero(hora.getIdIngeniero());
                objHoraTrabajoJunior.setCantidadHoraTrabajo(hora.getCantidadHoraTrabajo());
                horaTrabajoDAO.edit(objHoraTrabajoJunior);
            }else{
                throw new Exception("Este ingeniero junior no tiene horas de trabajo registrada");
            }
        }
    }

    @Override
    public HoraTrabajoJunior consultarxCodigoHoraTrabajoJunior(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El ID del ingeniero es obligatorio");
        }else{
            return horaTrabajoDAO.find(codigo);
        }
    }

    @Override
    public List<HoraTrabajoJunior> consultarTodosHoraTrabajoJunior() throws Exception {
        return horaTrabajoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
