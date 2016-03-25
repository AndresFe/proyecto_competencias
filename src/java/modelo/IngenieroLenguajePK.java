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
public class IngenieroLenguajePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_area_conocimiento")
    private int idAreaConocimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lenguaje")
    private String lenguaje;

    public IngenieroLenguajePK() {
    }

    public IngenieroLenguajePK(int idAreaConocimiento, String lenguaje) {
        this.idAreaConocimiento = idAreaConocimiento;
        this.lenguaje = lenguaje;
    }

    public int getIdAreaConocimiento() {
        return idAreaConocimiento;
    }

    public void setIdAreaConocimiento(int idAreaConocimiento) {
        this.idAreaConocimiento = idAreaConocimiento;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAreaConocimiento;
        hash += (lenguaje != null ? lenguaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngenieroLenguajePK)) {
            return false;
        }
        IngenieroLenguajePK other = (IngenieroLenguajePK) object;
        if (this.idAreaConocimiento != other.idAreaConocimiento) {
            return false;
        }
        if ((this.lenguaje == null && other.lenguaje != null) || (this.lenguaje != null && !this.lenguaje.equals(other.lenguaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenieroLenguajePK[ idAreaConocimiento=" + idAreaConocimiento + ", lenguaje=" + lenguaje + " ]";
    }
    
}
