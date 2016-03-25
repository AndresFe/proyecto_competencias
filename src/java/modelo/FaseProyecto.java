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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "fase_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaseProyecto.findAll", query = "SELECT f FROM FaseProyecto f"),
    @NamedQuery(name = "FaseProyecto.findById", query = "SELECT f FROM FaseProyecto f WHERE f.id = :id"),
    @NamedQuery(name = "FaseProyecto.findByNombreFaseProyecto", query = "SELECT f FROM FaseProyecto f WHERE f.nombreFaseProyecto = :nombreFaseProyecto"),
    @NamedQuery(name = "FaseProyecto.findByFecha", query = "SELECT f FROM FaseProyecto f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "FaseProyecto.findByEstado", query = "SELECT f FROM FaseProyecto f WHERE f.estado = :estado")})
public class FaseProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_fase_proyecto")
    private String nombreFaseProyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoFaseProyecto")
    private List<ProyectoSoftwareDetalle> proyectoSoftwareDetalleList;

    public FaseProyecto() {
    }

    public FaseProyecto(Integer id) {
        this.id = id;
    }

    public FaseProyecto(Integer id, String nombreFaseProyecto, Date fecha, boolean estado) {
        this.id = id;
        this.nombreFaseProyecto = nombreFaseProyecto;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFaseProyecto() {
        return nombreFaseProyecto;
    }

    public void setNombreFaseProyecto(String nombreFaseProyecto) {
        this.nombreFaseProyecto = nombreFaseProyecto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ProyectoSoftwareDetalle> getProyectoSoftwareDetalleList() {
        return proyectoSoftwareDetalleList;
    }

    public void setProyectoSoftwareDetalleList(List<ProyectoSoftwareDetalle> proyectoSoftwareDetalleList) {
        this.proyectoSoftwareDetalleList = proyectoSoftwareDetalleList;
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
        if (!(object instanceof FaseProyecto)) {
            return false;
        }
        FaseProyecto other = (FaseProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.FaseProyecto[ id=" + id + " ]";
    }
    
}
