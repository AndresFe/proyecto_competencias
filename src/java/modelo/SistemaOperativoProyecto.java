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
@Table(name = "sistema_operativo_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaOperativoProyecto.findAll", query = "SELECT s FROM SistemaOperativoProyecto s"),
    @NamedQuery(name = "SistemaOperativoProyecto.findByIdProyectoSoftware", query = "SELECT s FROM SistemaOperativoProyecto s WHERE s.idProyectoSoftware = :idProyectoSoftware"),
    @NamedQuery(name = "SistemaOperativoProyecto.findByNombreSistemaOperativo", query = "SELECT s FROM SistemaOperativoProyecto s WHERE s.nombreSistemaOperativo = :nombreSistemaOperativo")})
public class SistemaOperativoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_proyecto_software")
    private Integer idProyectoSoftware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_sistema_operativo")
    private String nombreSistemaOperativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sistemaOperativoCompatible")
    private List<ProyectoSoftwareDetalle> proyectoSoftwareDetalleList;

    public SistemaOperativoProyecto() {
    }

    public SistemaOperativoProyecto(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public SistemaOperativoProyecto(Integer idProyectoSoftware, String nombreSistemaOperativo) {
        this.idProyectoSoftware = idProyectoSoftware;
        this.nombreSistemaOperativo = nombreSistemaOperativo;
    }

    public Integer getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(Integer idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
    }

    public String getNombreSistemaOperativo() {
        return nombreSistemaOperativo;
    }

    public void setNombreSistemaOperativo(String nombreSistemaOperativo) {
        this.nombreSistemaOperativo = nombreSistemaOperativo;
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
        if (!(object instanceof SistemaOperativoProyecto)) {
            return false;
        }
        SistemaOperativoProyecto other = (SistemaOperativoProyecto) object;
        if ((this.idProyectoSoftware == null && other.idProyectoSoftware != null) || (this.idProyectoSoftware != null && !this.idProyectoSoftware.equals(other.idProyectoSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SistemaOperativoProyecto[ idProyectoSoftware=" + idProyectoSoftware + " ]";
    }
    
}
