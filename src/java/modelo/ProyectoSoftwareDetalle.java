/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "proyecto_software_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoSoftwareDetalle.findAll", query = "SELECT p FROM ProyectoSoftwareDetalle p"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByIdProyectoSoftware", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.idProyectoSoftware = :idProyectoSoftware"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByCodigoProyecto", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.codigoProyecto = :codigoProyecto"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByNombre", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByFechaIngresoAlSistema", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.fechaIngresoAlSistema = :fechaIngresoAlSistema"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByFechaAsignacionProyecto", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.fechaAsignacionProyecto = :fechaAsignacionProyecto"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByFechaLiberacion", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.fechaLiberacion = :fechaLiberacion"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByVersionPrograma", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.versionPrograma = :versionPrograma"),
    @NamedQuery(name = "ProyectoSoftwareDetalle.findByCostoProyecto", query = "SELECT p FROM ProyectoSoftwareDetalle p WHERE p.costoProyecto = :costoProyecto")})
public class ProyectoSoftwareDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto_software")
    private Integer idProyectoSoftware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "codigo_proyecto")
    private String codigoProyecto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso_al_sistema")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoAlSistema;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion_proyecto")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_liberacion")
    @Temporal(TemporalType.DATE)
    private Date fechaLiberacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "version_programa")
    private String versionPrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo_proyecto")
    private long costoProyecto;
    @JoinColumn(name = "base_datos_compatible", referencedColumnName = "id_proyecto_software")
    @ManyToOne(optional = false)
    private BaseDatosProyecto baseDatosCompatible;
    @JoinColumn(name = "sistema_operativo_compatible", referencedColumnName = "id_proyecto_software")
    @ManyToOne(optional = false)
    private SistemaOperativoProyecto sistemaOperativoCompatible;
    @JoinColumn(name = "lenguaje", referencedColumnName = "id_proyecto_software")
    @ManyToOne(optional = false)
    private LenguajeProyecto lenguaje;
    @JoinColumn(name = "tipo_fase_proyecto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FaseProyecto tipoFaseProyecto;
    @JoinColumn(name = "tipo_area_aplicacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAreaAplicacion tipoAreaAplicacion;

    public ProyectoSoftwareDetalle() {
    }

    public ProyectoSoftwareDetalle(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public ProyectoSoftwareDetalle(Integer idProyectoSoftware, String codigoProyecto, String nombre, Date fechaIngresoAlSistema, Date fechaAsignacionProyecto, Date fechaLiberacion, String versionPrograma, long costoProyecto) {
        this.idProyectoSoftware = idProyectoSoftware;
        this.codigoProyecto = codigoProyecto;
        this.nombre = nombre;
        this.fechaIngresoAlSistema = fechaIngresoAlSistema;
        this.fechaAsignacionProyecto = fechaAsignacionProyecto;
        this.fechaLiberacion = fechaLiberacion;
        this.versionPrograma = versionPrograma;
        this.costoProyecto = costoProyecto;
    }

    public Integer getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public String getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(String codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngresoAlSistema() {
        return fechaIngresoAlSistema;
    }

    public void setFechaIngresoAlSistema(Date fechaIngresoAlSistema) {
        this.fechaIngresoAlSistema = fechaIngresoAlSistema;
    }

    public Date getFechaAsignacionProyecto() {
        return fechaAsignacionProyecto;
    }

    public void setFechaAsignacionProyecto(Date fechaAsignacionProyecto) {
        this.fechaAsignacionProyecto = fechaAsignacionProyecto;
    }

    public Date getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(Date fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    public String getVersionPrograma() {
        return versionPrograma;
    }

    public void setVersionPrograma(String versionPrograma) {
        this.versionPrograma = versionPrograma;
    }

    public long getCostoProyecto() {
        return costoProyecto;
    }

    public void setCostoProyecto(long costoProyecto) {
        this.costoProyecto = costoProyecto;
    }

    public BaseDatosProyecto getBaseDatosCompatible() {
        return baseDatosCompatible;
    }

    public void setBaseDatosCompatible(BaseDatosProyecto baseDatosCompatible) {
        this.baseDatosCompatible = baseDatosCompatible;
    }

    public SistemaOperativoProyecto getSistemaOperativoCompatible() {
        return sistemaOperativoCompatible;
    }

    public void setSistemaOperativoCompatible(SistemaOperativoProyecto sistemaOperativoCompatible) {
        this.sistemaOperativoCompatible = sistemaOperativoCompatible;
    }

    public LenguajeProyecto getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(LenguajeProyecto lenguaje) {
        this.lenguaje = lenguaje;
    }

    public FaseProyecto getTipoFaseProyecto() {
        return tipoFaseProyecto;
    }

    public void setTipoFaseProyecto(FaseProyecto tipoFaseProyecto) {
        this.tipoFaseProyecto = tipoFaseProyecto;
    }

    public TipoAreaAplicacion getTipoAreaAplicacion() {
        return tipoAreaAplicacion;
    }

    public void setTipoAreaAplicacion(TipoAreaAplicacion tipoAreaAplicacion) {
        this.tipoAreaAplicacion = tipoAreaAplicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProyectoSoftware != null ? idProyectoSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoSoftwareDetalle)) {
            return false;
        }
        ProyectoSoftwareDetalle other = (ProyectoSoftwareDetalle) object;
        if ((this.idProyectoSoftware == null && other.idProyectoSoftware != null) || (this.idProyectoSoftware != null && !this.idProyectoSoftware.equals(other.idProyectoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectoSoftwareDetalle[ idProyectoSoftware=" + idProyectoSoftware + " ]";
    }
    
}
