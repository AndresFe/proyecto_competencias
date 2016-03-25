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
@Table(name = "lenguaje_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LenguajeProyecto.findAll", query = "SELECT l FROM LenguajeProyecto l"),
    @NamedQuery(name = "LenguajeProyecto.findByIdProyectoSoftware", query = "SELECT l FROM LenguajeProyecto l WHERE l.idProyectoSoftware = :idProyectoSoftware"),
    @NamedQuery(name = "LenguajeProyecto.findByLenguaje", query = "SELECT l FROM LenguajeProyecto l WHERE l.lenguaje = :lenguaje")})
public class LenguajeProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto_software")
    private Integer idProyectoSoftware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "lenguaje")
    private String lenguaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lenguaje")
    private List<ProyectoSoftwareDetalle> proyectoSoftwareDetalleList;

    public LenguajeProyecto() {
    }

    public LenguajeProyecto(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public LenguajeProyecto(Integer idProyectoSoftware, String lenguaje) {
        this.idProyectoSoftware = idProyectoSoftware;
        this.lenguaje = lenguaje;
    }

    public Integer getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
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
        if (!(object instanceof LenguajeProyecto)) {
            return false;
        }
        LenguajeProyecto other = (LenguajeProyecto) object;
        if ((this.idProyectoSoftware == null && other.idProyectoSoftware != null) || (this.idProyectoSoftware != null && !this.idProyectoSoftware.equals(other.idProyectoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LenguajeProyecto[ idProyectoSoftware=" + idProyectoSoftware + " ]";
    }
    
}
