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
@Table(name = "hora_trabajo_junior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoraTrabajoJunior.findAll", query = "SELECT h FROM HoraTrabajoJunior h"),
    @NamedQuery(name = "HoraTrabajoJunior.findByIdIngeniero", query = "SELECT h FROM HoraTrabajoJunior h WHERE h.idIngeniero = :idIngeniero"),
    @NamedQuery(name = "HoraTrabajoJunior.findByCantidadHoraTrabajo", query = "SELECT h FROM HoraTrabajoJunior h WHERE h.cantidadHoraTrabajo = :cantidadHoraTrabajo")})
public class HoraTrabajoJunior implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ingeniero")
    private Integer idIngeniero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_hora_trabajo")
    private int cantidadHoraTrabajo;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingeniero ingeniero;

    public HoraTrabajoJunior() {
    }

    public HoraTrabajoJunior(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public HoraTrabajoJunior(Integer idIngeniero, int cantidadHoraTrabajo) {
        this.idIngeniero = idIngeniero;
        this.cantidadHoraTrabajo = cantidadHoraTrabajo;
    }

    public Integer getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Integer idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public int getCantidadHoraTrabajo() {
        return cantidadHoraTrabajo;
    }

    public void setCantidadHoraTrabajo(int cantidadHoraTrabajo) {
        this.cantidadHoraTrabajo = cantidadHoraTrabajo;
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
        if (!(object instanceof HoraTrabajoJunior)) {
            return false;
        }
        HoraTrabajoJunior other = (HoraTrabajoJunior) object;
        if ((this.idIngeniero == null && other.idIngeniero != null) || (this.idIngeniero != null && !this.idIngeniero.equals(other.idIngeniero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HoraTrabajoJunior[ idIngeniero=" + idIngeniero + " ]";
    }
    
}
