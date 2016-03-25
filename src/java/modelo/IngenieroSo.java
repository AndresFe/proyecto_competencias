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
@Table(name = "ingeniero_so")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngenieroSo.findAll", query = "SELECT i FROM IngenieroSo i"),
    @NamedQuery(name = "IngenieroSo.findByIdAreaConocimiento", query = "SELECT i FROM IngenieroSo i WHERE i.ingenieroSoPK.idAreaConocimiento = :idAreaConocimiento"),
    @NamedQuery(name = "IngenieroSo.findBySistemaOperativo", query = "SELECT i FROM IngenieroSo i WHERE i.ingenieroSoPK.sistemaOperativo = :sistemaOperativo")})
public class IngenieroSo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngenieroSoPK ingenieroSoPK;
    @JoinColumn(name = "id_area_conocimiento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AreaConocimiento areaConocimiento;

    public IngenieroSo() {
    }

    public IngenieroSo(IngenieroSoPK ingenieroSoPK) {
        this.ingenieroSoPK = ingenieroSoPK;
    }

    public IngenieroSo(int idAreaConocimiento, String sistemaOperativo) {
        this.ingenieroSoPK = new IngenieroSoPK(idAreaConocimiento, sistemaOperativo);
    }

    public IngenieroSoPK getIngenieroSoPK() {
        return ingenieroSoPK;
    }

    public void setIngenieroSoPK(IngenieroSoPK ingenieroSoPK) {
        this.ingenieroSoPK = ingenieroSoPK;
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
        hash += (ingenieroSoPK != null ? ingenieroSoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngenieroSo)) {
            return false;
        }
        IngenieroSo other = (IngenieroSo) object;
        if ((this.ingenieroSoPK == null && other.ingenieroSoPK != null) || (this.ingenieroSoPK != null && !this.ingenieroSoPK.equals(other.ingenieroSoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenieroSo[ ingenieroSoPK=" + ingenieroSoPK + " ]";
    }
    
}
