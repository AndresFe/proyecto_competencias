/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ingeniero_lenguaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngenieroLenguaje.findAll", query = "SELECT i FROM IngenieroLenguaje i"),
    @NamedQuery(name = "IngenieroLenguaje.findByIdAreaConocimiento", query = "SELECT i FROM IngenieroLenguaje i WHERE i.ingenieroLenguajePK.idAreaConocimiento = :idAreaConocimiento"),
    @NamedQuery(name = "IngenieroLenguaje.findByLenguaje", query = "SELECT i FROM IngenieroLenguaje i WHERE i.ingenieroLenguajePK.lenguaje = :lenguaje")})
public class IngenieroLenguaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngenieroLenguajePK ingenieroLenguajePK;
    @JoinColumn(name = "id_area_conocimiento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AreaConocimiento areaConocimiento;

    public IngenieroLenguaje() {
    }

    public IngenieroLenguaje(IngenieroLenguajePK ingenieroLenguajePK) {
        this.ingenieroLenguajePK = ingenieroLenguajePK;
    }

    public IngenieroLenguaje(int idAreaConocimiento, String lenguaje) {
        this.ingenieroLenguajePK = new IngenieroLenguajePK(idAreaConocimiento, lenguaje);
    }

    public IngenieroLenguajePK getIngenieroLenguajePK() {
        return ingenieroLenguajePK;
    }

    public void setIngenieroLenguajePK(IngenieroLenguajePK ingenieroLenguajePK) {
        this.ingenieroLenguajePK = ingenieroLenguajePK;
    }

    public AreaConocimiento getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(AreaConocimiento areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingenieroLenguajePK != null ? ingenieroLenguajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngenieroLenguaje)) {
            return false;
        }
        IngenieroLenguaje other = (IngenieroLenguaje) object;
        if ((this.ingenieroLenguajePK == null && other.ingenieroLenguajePK != null) || (this.ingenieroLenguajePK != null && !this.ingenieroLenguajePK.equals(other.ingenieroLenguajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenieroLenguaje[ ingenieroLenguajePK=" + ingenieroLenguajePK + " ]";
    }
    
}
