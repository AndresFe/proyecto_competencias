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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "cantidad_proyectos_senior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CantidadProyectosSenior.findAll", query = "SELECT c FROM CantidadProyectosSenior c"),
    @NamedQuery(name = "CantidadProyectosSenior.findByIdIngeniero", query = "SELECT c FROM CantidadProyectosSenior c WHERE c.idIngeniero = :idIngeniero"),
    @NamedQuery(name = "CantidadProyectosSenior.findByCantidadProyectosAsignados", query = "SELECT c FROM CantidadProyectosSenior c WHERE c.cantidadProyectosAsignados = :cantidadProyectosAsignados")})
public class CantidadProyectosSenior implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ingeniero")
    private Integer idIngeniero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_proyectos_asignados")
    private int cantidadProyectosAsignados;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingeniero ingeniero;

    public CantidadProyectosSenior() {
    }

    public CantidadProyectosSenior(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public CantidadProyectosSenior(Integer idIngeniero, int cantidadProyectosAsignados) {
        this.idIngeniero = idIngeniero;
        this.cantidadProyectosAsignados = cantidadProyectosAsignados;
    }

    public Integer getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public int getCantidadProyectosAsignados() {
        return cantidadProyectosAsignados;
    }

    public void setCantidadProyectosAsignados(int cantidadProyectosAsignados) {
        this.cantidadProyectosAsignados = cantidadProyectosAsignados;
    }

    public Ingeniero getIngeniero() {
        return ingeniero;
    }

    public void setIngeniero(Ingeniero ingeniero) {
        this.ingeniero = ingeniero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngeniero != null ? idIngeniero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantidadProyectosSenior)) {
            return false;
        }
        CantidadProyectosSenior other = (CantidadProyectosSenior) object;
        if ((this.idIngeniero == null && other.idIngeniero != null) || (this.idIngeniero != null && !this.idIngeniero.equals(other.idIngeniero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CantidadProyectosSenior[ idIngeniero=" + idIngeniero + " ]";
    }
    
}
