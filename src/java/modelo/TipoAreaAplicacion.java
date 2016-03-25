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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipo_area_aplicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAreaAplicacion.findAll", query = "SELECT t FROM TipoAreaAplicacion t"),
    @NamedQuery(name = "TipoAreaAplicacion.findById", query = "SELECT t FROM TipoAreaAplicacion t WHERE t.id = :id"),
    @NamedQuery(name = "TipoAreaAplicacion.findByNombreTipo", query = "SELECT t FROM TipoAreaAplicacion t WHERE t.nombreTipo = :nombreTipo")})
public class TipoAreaAplicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_tipo")
    private String nombreTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoAreaAplicacion")
    private List<ProyectoSoftwareDetalle> proyectoSoftwareDetalleList;

    public TipoAreaAplicacion() {
    }

    public TipoAreaAplicacion(Integer id) {
        this.id = id;
    }

    public TipoAreaAplicacion(Integer id, String nombreTipo) {
        this.id = id;
        this.nombreTipo = nombreTipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
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
        if (!(object instanceof TipoAreaAplicacion)) {
            return false;
        }
        TipoAreaAplicacion other = (TipoAreaAplicacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TipoAreaAplicacion[ id=" + id + " ]";
    }
    
}
