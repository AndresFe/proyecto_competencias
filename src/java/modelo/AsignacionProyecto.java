/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "asignacion_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionProyecto.findAll", query = "SELECT a FROM AsignacionProyecto a"),
    @NamedQuery(name = "AsignacionProyecto.findById", query = "SELECT a FROM AsignacionProyecto a WHERE a.id = :id")})
public class AsignacionProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingeniero idIngeniero;
    @JoinColumn(name = "id_proyecto_software", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProyectoSoftware idProyectoSoftware;

    public AsignacionProyecto() {
    }

    public AsignacionProyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingeniero getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Ingeniero idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public ProyectoSoftware getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(ProyectoSoftware idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
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
        if (!(object instanceof AsignacionProyecto)) {
            return false;
        }
        AsignacionProyecto other = (AsignacionProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsignacionProyecto[ id=" + id + " ]";
    }
    
}
