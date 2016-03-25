/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "base_datos_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseDatosProyecto.findAll", query = "SELECT b FROM BaseDatosProyecto b"),
    @NamedQuery(name = "BaseDatosProyecto.findByIdProyectoSoftware", query = "SELECT b FROM BaseDatosProyecto b WHERE b.idProyectoSoftware = :idProyectoSoftware"),
    @NamedQuery(name = "BaseDatosProyecto.findByNombreBaseDatos", query = "SELECT b FROM BaseDatosProyecto b WHERE b.nombreBaseDatos = :nombreBaseDatos")})
public class BaseDatosProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto_software")
    private Integer idProyectoSoftware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_base_datos")
    private String nombreBaseDatos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseDatosCompatible")
    private List<ProyectoSoftwareDetalle> proyectoSoftwareDetalleList;

    public BaseDatosProyecto() {
    }

    public BaseDatosProyecto(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public BaseDatosProyecto(Integer idProyectoSoftware, String nombreBaseDatos) {
        this.idProyectoSoftware = idProyectoSoftware;
        this.nombreBaseDatos = nombreBaseDatos;
    }

    public Integer getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
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
        hash += (idProyectoSoftware != null ? idProyectoSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaseDatosProyecto)) {
            return false;
        }
        BaseDatosProyecto other = (BaseDatosProyecto) object;
        if ((this.idProyectoSoftware == null && other.idProyectoSoftware != null) || (this.idProyectoSoftware != null && !this.idProyectoSoftware.equals(other.idProyectoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.BaseDatosProyecto[ idProyectoSoftware=" + idProyectoSoftware + " ]";
    }
    
}
