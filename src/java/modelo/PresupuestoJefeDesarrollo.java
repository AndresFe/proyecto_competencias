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
@Table(name = "presupuesto_jefe_desarrollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresupuestoJefeDesarrollo.findAll", query = "SELECT p FROM PresupuestoJefeDesarrollo p"),
    @NamedQuery(name = "PresupuestoJefeDesarrollo.findByIdIngeniero", query = "SELECT p FROM PresupuestoJefeDesarrollo p WHERE p.idIngeniero = :idIngeniero"),
    @NamedQuery(name = "PresupuestoJefeDesarrollo.findByPresupuesto", query = "SELECT p FROM PresupuestoJefeDesarrollo p WHERE p.presupuesto = :presupuesto")})
public class PresupuestoJefeDesarrollo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ingeniero")
    private Integer idIngeniero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto")
    private long presupuesto;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingeniero ingeniero;

    public PresupuestoJefeDesarrollo() {
    }

    public PresupuestoJefeDesarrollo(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public PresupuestoJefeDesarrollo(Integer idIngeniero, long presupuesto) {
        this.idIngeniero = idIngeniero;
        this.presupuesto = presupuesto;
    }

    public Integer getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
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
        if (!(object instanceof PresupuestoJefeDesarrollo)) {
            return false;
        }
        PresupuestoJefeDesarrollo other = (PresupuestoJefeDesarrollo) object;
        if ((this.idIngeniero == null && other.idIngeniero != null) || (this.idIngeniero != null && !this.idIngeniero.equals(other.idIngeniero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PresupuestoJefeDesarrollo[ idIngeniero=" + idIngeniero + " ]";
    }
    
}
