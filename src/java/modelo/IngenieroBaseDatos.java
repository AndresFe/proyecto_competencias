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
@Table(name = "ingeniero_base_datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IngenieroBaseDatos.findAll", query = "SELECT i FROM IngenieroBaseDatos i"),
    @NamedQuery(name = "IngenieroBaseDatos.findByIdAreaConocimiento", query = "SELECT i FROM IngenieroBaseDatos i WHERE i.ingenieroBaseDatosPK.idAreaConocimiento = :idAreaConocimiento"),
    @NamedQuery(name = "IngenieroBaseDatos.findByBaseDeDatos", query = "SELECT i FROM IngenieroBaseDatos i WHERE i.ingenieroBaseDatosPK.baseDeDatos = :baseDeDatos")})
public class IngenieroBaseDatos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngenieroBaseDatosPK ingenieroBaseDatosPK;
    @JoinColumn(name = "id_area_conocimiento", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private AreaConocimiento areaConocimiento;

    public IngenieroBaseDatos() {
    }

    public IngenieroBaseDatos(IngenieroBaseDatosPK ingenieroBaseDatosPK) {
        this.ingenieroBaseDatosPK = ingenieroBaseDatosPK;
    }

    public IngenieroBaseDatos(int idAreaConocimiento, String baseDeDatos) {
        this.ingenieroBaseDatosPK = new IngenieroBaseDatosPK(idAreaConocimiento, baseDeDatos);
    }

    public IngenieroBaseDatosPK getIngenieroBaseDatosPK() {
        return ingenieroBaseDatosPK;
    }

    public void setIngenieroBaseDatosPK(IngenieroBaseDatosPK ingenieroBaseDatosPK) {
        this.ingenieroBaseDatosPK = ingenieroBaseDatosPK;
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
        hash += (ingenieroBaseDatosPK != null ? ingenieroBaseDatosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngenieroBaseDatos)) {
            return false;
        }
        IngenieroBaseDatos other = (IngenieroBaseDatos) object;
        if ((this.ingenieroBaseDatosPK == null && other.ingenieroBaseDatosPK != null) || (this.ingenieroBaseDatosPK != null && !this.ingenieroBaseDatosPK.equals(other.ingenieroBaseDatosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenieroBaseDatos[ ingenieroBaseDatosPK=" + ingenieroBaseDatosPK + " ]";
    }
    
}
