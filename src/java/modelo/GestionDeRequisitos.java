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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "gestion_de_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionDeRequisitos.findAll", query = "SELECT g FROM GestionDeRequisitos g"),
    @NamedQuery(name = "GestionDeRequisitos.findById", query = "SELECT g FROM GestionDeRequisitos g WHERE g.id = :id"),
    @NamedQuery(name = "GestionDeRequisitos.findByNumeroSolicitud", query = "SELECT g FROM GestionDeRequisitos g WHERE g.numeroSolicitud = :numeroSolicitud"),
    @NamedQuery(name = "GestionDeRequisitos.findByTitulo", query = "SELECT g FROM GestionDeRequisitos g WHERE g.titulo = :titulo"),
    @NamedQuery(name = "GestionDeRequisitos.findByFechaSolicitud", query = "SELECT g FROM GestionDeRequisitos g WHERE g.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "GestionDeRequisitos.findBySolicitante", query = "SELECT g FROM GestionDeRequisitos g WHERE g.solicitante = :solicitante"),
    @NamedQuery(name = "GestionDeRequisitos.findByOrigen", query = "SELECT g FROM GestionDeRequisitos g WHERE g.origen = :origen"),
    @NamedQuery(name = "GestionDeRequisitos.findByPrioridadSolicitante", query = "SELECT g FROM GestionDeRequisitos g WHERE g.prioridadSolicitante = :prioridadSolicitante"),
    @NamedQuery(name = "GestionDeRequisitos.findByPrioridadRealizacion", query = "SELECT g FROM GestionDeRequisitos g WHERE g.prioridadRealizacion = :prioridadRealizacion"),
    @NamedQuery(name = "GestionDeRequisitos.findByVerificador", query = "SELECT g FROM GestionDeRequisitos g WHERE g.verificador = :verificador"),
    @NamedQuery(name = "GestionDeRequisitos.findByFechaUltimaActualizacion", query = "SELECT g FROM GestionDeRequisitos g WHERE g.fechaUltimaActualizacion = :fechaUltimaActualizacion"),
    @NamedQuery(name = "GestionDeRequisitos.findByRelease", query = "SELECT g FROM GestionDeRequisitos g WHERE g.release = :release"),
    @NamedQuery(name = "GestionDeRequisitos.findByEsfuerzo", query = "SELECT g FROM GestionDeRequisitos g WHERE g.esfuerzo = :esfuerzo"),
    @NamedQuery(name = "GestionDeRequisitos.findByDescripcion", query = "SELECT g FROM GestionDeRequisitos g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GestionDeRequisitos.findByComentarios", query = "SELECT g FROM GestionDeRequisitos g WHERE g.comentarios = :comentarios")})
public class GestionDeRequisitos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_solicitud")
    private long numeroSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "solicitante")
    private String solicitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prioridad_solicitante")
    private String prioridadSolicitante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prioridad_realizacion")
    private String prioridadRealizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "verificador")
    private String verificador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ultima_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "release")
    @Temporal(TemporalType.DATE)
    private Date release;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "esfuerzo")
    private String esfuerzo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "id_tipo_solicitud", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoSolicitud idTipoSolicitud;
    @JoinColumn(name = "id_tipo_estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoEstado idTipoEstado;
    @JoinColumn(name = "id_requisitos_proyecto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RequisitosDelProyecto idRequisitosProyecto;

    public GestionDeRequisitos() {
    }

    public GestionDeRequisitos(Integer id) {
        this.id = id;
    }

    public GestionDeRequisitos(Integer id, long numeroSolicitud, String titulo, Date fechaSolicitud, String solicitante, String origen, String prioridadSolicitante, String prioridadRealizacion, String verificador, Date fechaUltimaActualizacion, Date release, String esfuerzo, String descripcion, String comentarios) {
        this.id = id;
        this.numeroSolicitud = numeroSolicitud;
        this.titulo = titulo;
        this.fechaSolicitud = fechaSolicitud;
        this.solicitante = solicitante;
        this.origen = origen;
        this.prioridadSolicitante = prioridadSolicitante;
        this.prioridadRealizacion = prioridadRealizacion;
        this.verificador = verificador;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
        this.release = release;
        this.esfuerzo = esfuerzo;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(long numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getPrioridadSolicitante() {
        return prioridadSolicitante;
    }

    public void setPrioridadSolicitante(String prioridadSolicitante) {
        this.prioridadSolicitante = prioridadSolicitante;
    }

    public String getPrioridadRealizacion() {
        return prioridadRealizacion;
    }

    public void setPrioridadRealizacion(String prioridadRealizacion) {
        this.prioridadRealizacion = prioridadRealizacion;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getEsfuerzo() {
        return esfuerzo;
    }

    public void setEsfuerzo(String esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public TipoSolicitud getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(TipoSolicitud idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public TipoEstado getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(TipoEstado idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public RequisitosDelProyecto getIdRequisitosProyecto() {
        return idRequisitosProyecto;
    }

    public void setIdRequisitosProyecto(RequisitosDelProyecto idRequisitosProyecto) {
        this.idRequisitosProyecto = idRequisitosProyecto;
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
        if (!(object instanceof GestionDeRequisitos)) {
            return false;
        }
        GestionDeRequisitos other = (GestionDeRequisitos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GestionDeRequisitos[ id=" + id + " ]";
    }
    
}
