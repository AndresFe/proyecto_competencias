/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author andres
 */
@Embeddable
public class IngenieroBaseDatosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_area_conocimiento")
    private int idAreaConocimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "base_de_datos")
    private String baseDeDatos;

    public IngenieroBaseDatosPK() {
    }

    public IngenieroBaseDatosPK(int idAreaConocimiento, String baseDeDatos) {
        this.idAreaConocimiento = idAreaConocimiento;
        this.baseDeDatos = baseDeDatos;
    }

    public int getIdAreaConocimiento() {
        return idAreaConocimiento;
    }

    public void setIdAreaConocimiento(int idAreaConocimiento) {
        this.idAreaConocimiento = idAreaConocimiento;
    }

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAreaConocimiento;
        hash += (baseDeDatos != null ? baseDeDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngenieroBaseDatosPK)) {
            return false;
        }
        IngenieroBaseDatosPK other = (IngenieroBaseDatosPK) object;
        if (this.idAreaConocimiento != other.idAreaConocimiento) {
            return false;
        }
        if ((this.baseDeDatos == null && other.baseDeDatos != null) || (this.baseDeDatos != null && !this.baseDeDatos.equals(other.baseDeDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenieroBaseDatosPK[ idAreaConocimiento=" + idAreaConocimiento + ", baseDeDatos=" + baseDeDatos + " ]";
    }
    
}
