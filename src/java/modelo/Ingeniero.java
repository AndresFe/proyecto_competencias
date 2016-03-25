/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "ingeniero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingeniero.findAll", query = "SELECT i FROM Ingeniero i"),
    @NamedQuery(name = "Ingeniero.findById", query = "SELECT i FROM Ingeniero i WHERE i.id = :id"),
    @NamedQuery(name = "Ingeniero.findByNombre", query = "SELECT i FROM Ingeniero i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Ingeniero.findByApellido", query = "SELECT i FROM Ingeniero i WHERE i.apellido = :apellido"),
    @NamedQuery(name = "Ingeniero.findByCedula", query = "SELECT i FROM Ingeniero i WHERE i.cedula = :cedula"),
    @NamedQuery(name = "Ingeniero.findByEmail", query = "SELECT i FROM Ingeniero i WHERE i.email = :email"),
    @NamedQuery(name = "Ingeniero.findByPassword", query = "SELECT i FROM Ingeniero i WHERE i.password = :password"),
    @NamedQuery(name = "Ingeniero.findByTelefonoFijo", query = "SELECT i FROM Ingeniero i WHERE i.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "Ingeniero.findByTelefonoMovil", query = "SELECT i FROM Ingeniero i WHERE i.telefonoMovil = :telefonoMovil"),
    @NamedQuery(name = "Ingeniero.findByDireccion", query = "SELECT i FROM Ingeniero i WHERE i.direccion = :direccion"),
    @NamedQuery(name = "Ingeniero.findByFechaNacimiento", query = "SELECT i FROM Ingeniero i WHERE i.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Ingeniero.findByEdad", query = "SELECT i FROM Ingeniero i WHERE i.edad = :edad"),
    @NamedQuery(name = "Ingeniero.findBySexo", query = "SELECT i FROM Ingeniero i WHERE i.sexo = :sexo"),
    @NamedQuery(name = "Ingeniero.findByFechaIngreso", query = "SELECT i FROM Ingeniero i WHERE i.fechaIngreso = :fechaIngreso")})
public class Ingeniero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cedula")
    private String cedula;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "telefono_movil")
    private String telefonoMovil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngeniero")
    private List<SeminarioCurso> seminarioCursoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingeniero")
    private PresupuestoJefeDesarrollo presupuestoJefeDesarrollo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngeniero")
    private List<AreaConocimiento> areaConocimientoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingeniero")
    private CantidadProyectosSenior cantidadProyectosSenior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngenieroSenior")
    private List<ProyectoSoftware> proyectoSoftwareList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingeniero")
    private HoraTrabajoJunior horaTrabajoJunior;
    @JoinColumn(name = "tipo_ingeniero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoIngeniero tipoIngeniero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngeniero")
    private List<GradosAcademicos> gradosAcademicosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngeniero")
    private List<AsignacionProyecto> asignacionProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngeniero")
    private List<Desarrolladores> desarrolladoresList;

    public Ingeniero() {
    }

    public Ingeniero(Integer id) {
        this.id = id;
    }

    public Ingeniero(Integer id, String nombre, String apellido, String cedula, String email, String password, String telefonoFijo, String telefonoMovil, String direccion, Date fechaNacimiento, int edad, String sexo, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
        this.password = password;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @XmlTransient
    public List<SeminarioCurso> getSeminarioCursoList() {
        return seminarioCursoList;
    }

    public void setSeminarioCursoList(List<SeminarioCurso> seminarioCursoList) {
        this.seminarioCursoList = seminarioCursoList;
    }

    public PresupuestoJefeDesarrollo getPresupuestoJefeDesarrollo() {
        return presupuestoJefeDesarrollo;
    }

    public void setPresupuestoJefeDesarrollo(PresupuestoJefeDesarrollo presupuestoJefeDesarrollo) {
        this.presupuestoJefeDesarrollo = presupuestoJefeDesarrollo;
    }

    @XmlTransient
    public List<AreaConocimiento> getAreaConocimientoList() {
        return areaConocimientoList;
    }

    public void setAreaConocimientoList(List<AreaConocimiento> areaConocimientoList) {
        this.areaConocimientoList = areaConocimientoList;
    }

    public CantidadProyectosSenior getCantidadProyectosSenior() {
        return cantidadProyectosSenior;
    }

    public void setCantidadProyectosSenior(CantidadProyectosSenior cantidadProyectosSenior) {
        this.cantidadProyectosSenior = cantidadProyectosSenior;
    }

    @XmlTransient
    public List<ProyectoSoftware> getProyectoSoftwareList() {
        return proyectoSoftwareList;
    }

    public void setProyectoSoftwareList(List<ProyectoSoftware> proyectoSoftwareList) {
        this.proyectoSoftwareList = proyectoSoftwareList;
    }

    public HoraTrabajoJunior getHoraTrabajoJunior() {
        return horaTrabajoJunior;
    }

    public void setHoraTrabajoJunior(HoraTrabajoJunior horaTrabajoJunior) {
        this.horaTrabajoJunior = horaTrabajoJunior;
    }

    public TipoIngeniero getTipoIngeniero() {
        return tipoIngeniero;
    }

    public void setTipoIngeniero(TipoIngeniero tipoIngeniero) {
        this.tipoIngeniero = tipoIngeniero;
    }

    @XmlTransient
    public List<GradosAcademicos> getGradosAcademicosList() {
        return gradosAcademicosList;
    }

    public void setGradosAcademicosList(List<GradosAcademicos> gradosAcademicosList) {
        this.gradosAcademicosList = gradosAcademicosList;
    }

    @XmlTransient
    public List<AsignacionProyecto> getAsignacionProyectoList() {
        return asignacionProyectoList;
    }

    public void setAsignacionProyectoList(List<AsignacionProyecto> asignacionProyectoList) {
        this.asignacionProyectoList = asignacionProyectoList;
    }

    @XmlTransient
    public List<Desarrolladores> getDesarrolladoresList() {
        return desarrolladoresList;
    }

    public void setDesarrolladoresList(List<Desarrolladores> desarrolladoresList) {
        this.desarrolladoresList = desarrolladoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingeniero)) {
            return false;
        }
        Ingeniero other = (Ingeniero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingeniero[ id=" + id + " ]";
    }
    
}
