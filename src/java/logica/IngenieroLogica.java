/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ingeniero;
import persistencia.IngenieroFacadeLocal;

/**
 *
 * @author andres
 */
@Stateless
public class IngenieroLogica implements IngenieroLogicaLocal {
    
    @EJB
    IngenieroFacadeLocal ingenieroDAO;

    @Override
    public void registrarIngeniero(Ingeniero ingeniero) throws Exception {
        if(ingeniero == null){
            throw new Exception("Campos vacíos");
        }else{
            if(ingeniero.getTipoIngeniero() == null){
                throw new Exception("El Tipo de Ingeniero es obligatorio");
            }if(ingeniero.getNombre() == null  || ingeniero.getNombre().equals("")) {
                throw new Exception("El Nombre del Ingeniero es obligatorio");
            }if(ingeniero.getApellido() == null || ingeniero.getApellido().equals("")){
                throw new Exception("El Apellido del Ingeniero es obligatorio");
            }if(ingeniero.getCedula() == null || ingeniero.getCedula().equals("")){
                throw new Exception("El Número de Cédula del Ingeniero es obligatorio");
            }if(ingeniero.getEmail() == null || ingeniero.getEmail().equals("")){
                throw new Exception("El e-mail del Ingeniero es obligatorio");
            }if(ingeniero.getTelefonoFijo() == null || ingeniero.getTelefonoFijo().equals("")){
                throw new Exception("El número de Telefono fijo del Ingeniero es obligatorio");
            }if(ingeniero.getTelefonoMovil() == null || ingeniero.getTelefonoMovil().equals("")){
                throw new Exception("El número de Telefono móvil del Ingeniero es obligatorio");                
            }if(ingeniero.getDireccion() == null || ingeniero.getDireccion().equals("")){
                throw new Exception("La dirección del Ingeniero es obligatorio");
            }if(ingeniero.getFechaNacimiento() == null || ingeniero.getFechaNacimiento().equals("")){
                throw new Exception("La fecha de nacimiento del Ingeniero es obligatorio");
            }if(ingeniero.getEdad() <= 0 ) {
                throw new Exception("La Edad del Ingeniero es obligatorio");
            }if(ingeniero.getSexo() == null || ingeniero.getSexo().equals("")){
                throw new Exception("La tipo de sexo del Ingeniero es obligatorio");
            }if(ingeniero.getFechaIngreso() == null || ingeniero.getFechaIngreso().equals("")){
                throw new Exception("La fecha de ingreso del Ingeniero es obligatorio");
            }if(ingeniero.getPassword() == null || ingeniero.getPassword().equals("")){
                throw new Exception("La contraseña del Ingeniero es obligatorio");
            }           
            Ingeniero objIngeniero = ingenieroDAO.find(ingeniero.getId());
            if(objIngeniero != null){
                throw new Exception("El Ingeniero ya existe en la base de datos");
            }else{
                ingenieroDAO.create(ingeniero);
            }
        }
    }

    @Override
    public void modificarIngeniero(Ingeniero ingeniero) throws Exception {
        if(ingeniero == null){
            throw new Exception("Campos vacíos");
        }else{
            if(ingeniero.getTipoIngeniero() == null){
                throw new Exception("El Tipo de Ingeniero es obligatorio");
            }if(ingeniero.getNombre() == null  || ingeniero.getNombre().equals("")) {
                throw new Exception("El Nombre del Ingeniero es obligatorio");
            }if(ingeniero.getApellido() == null || ingeniero.getApellido().equals("")){
                throw new Exception("El Apellido del Ingeniero es obligatorio");
            }if(ingeniero.getCedula() == null || ingeniero.getCedula().equals("")){
                throw new Exception("El Número de Cédula del Ingeniero es obligatorio");
            }if(ingeniero.getEmail() == null || ingeniero.getEmail().equals("")){
                throw new Exception("El e-mail del Ingeniero es obligatorio");
            }if(ingeniero.getTelefonoFijo() == null || ingeniero.getTelefonoFijo().equals("")){
                throw new Exception("El número de Telefono fijo del Ingeniero es obligatorio");
            }if(ingeniero.getTelefonoMovil() == null || ingeniero.getTelefonoMovil().equals("")){
                throw new Exception("El número de Telefono móvil del Ingeniero es obligatorio");                
            }if(ingeniero.getDireccion() == null || ingeniero.getDireccion().equals("")){
                throw new Exception("La dirección del Ingeniero es obligatorio");
            }if(ingeniero.getFechaNacimiento() == null || ingeniero.getFechaNacimiento().equals("")){
                throw new Exception("La fecha de nacimiento del Ingeniero es obligatorio");
            }if(ingeniero.getEdad() <= 0 ) {
                throw new Exception("La Edad del Ingeniero es obligatorio");
            }if(ingeniero.getSexo() == null || ingeniero.getSexo().equals("")){
                throw new Exception("La tipo de sexo del Ingeniero es obligatorio");
            }if(ingeniero.getFechaIngreso() == null || ingeniero.getFechaIngreso().equals("")){
                throw new Exception("La fecha de ingreso del Ingeniero es obligatorio");
            }}if(ingeniero.getPassword() == null || ingeniero.getPassword().equals("")){
                throw new Exception("La contraseña del Ingeniero es obligatorio");
            }
            Ingeniero objIngeniero = ingenieroDAO.find(ingeniero.getId());
            if(objIngeniero != null){
                objIngeniero.setTipoIngeniero(ingeniero.getTipoIngeniero());
                objIngeniero.setNombre(ingeniero.getNombre());
                objIngeniero.setApellido(ingeniero.getApellido());
                objIngeniero.setCedula(ingeniero.getCedula());
                objIngeniero.setEmail(ingeniero.getEmail());
                objIngeniero.setTelefonoFijo(ingeniero.getTelefonoFijo());
                objIngeniero.setTelefonoMovil(ingeniero.getTelefonoMovil());
                objIngeniero.setDireccion(ingeniero.getDireccion());
                objIngeniero.setFechaNacimiento(ingeniero.getFechaNacimiento());
                objIngeniero.setEdad(ingeniero.getEdad());
                objIngeniero.setSexo(ingeniero.getSexo());
                objIngeniero.setFechaIngreso(ingeniero.getFechaIngreso());
                objIngeniero.setPassword(ingeniero.getPassword());
                ingenieroDAO.edit(objIngeniero);
            }else{
                throw new Exception("El Ingeniero no existe en la base de datos");
            } 
        }

    @Override
    public void eliminarIngeniero(Ingeniero ingeniero) throws Exception {
        Ingeniero objIngeniero = ingenieroDAO.find(ingeniero.getId());
            if(objIngeniero != null){
                if(objIngeniero.getSeminarioCursoList().size() > 0){
                    throw new Exception("El Ingeniero tiene cursos de seminarios asociados");
                }else if(objIngeniero.getAreaConocimientoList().size() > 0){
                    throw new Exception("El Ingeniero tiene áreas de conocimientos asociados");
                }else if(objIngeniero.getProyectoSoftwareList().size() > 0) {
                    throw new Exception("El Ingeniero tiene proyectos de software asociados");
                }else if(objIngeniero.getGradosAcademicosList().size() > 0){
                    throw new Exception("El Ingeniero tiene grados académicos asociados");
                }else if(objIngeniero.getAsignacionProyectoList().size() > 0){
                    throw new Exception("El Ingeniero tiene asignaciones de proyectos asociados");
                }else if(objIngeniero.getDesarrolladoresList().size() > 0){
                    throw new Exception("El Ingeniero está asociado a una lista de desarrolladores");
                }else{
                    ingenieroDAO.remove(objIngeniero);
                }
            }else{
                throw new Exception("El Ingeniero no está en la base de datos");
            }
    }

    @Override
    public Ingeniero consultarxCodigoIngeniero(int codigo) throws Exception {
        if(codigo <= 0){
            throw new Exception("El código del Ingeniero es obligatorio");
        }else{
            return ingenieroDAO.find(codigo);
        }
    }

    @Override
    public List<Ingeniero> consultarTodasIngeniero() throws Exception {
        return ingenieroDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
