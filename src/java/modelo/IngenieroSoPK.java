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
public class IngenieroSoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_area_conocimiento")
    private int idAreaConocimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sistema_operativo")
    private String sistemaOperativo;

    public IngenieroSoPK() {
    }

    public IngenieroSoPK(int idAreaConocimiento, String sistemaOperativo) {
        this.idAreaConocimiento = idAreaConocimiento;
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getIdAreaConocimiento() {
        return idAreaConocimiento;
    }

    public void setIdAreaConocimiento(int idAreaConocimiento) {
        this.idAreaConocimiento = idAreaConocimiento;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAreaConocimiento;
        hash += (sistemaOperativo != null ? sistemaOperativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngenieroSoPK)) {
            return false;
        }
        IngenieroSoPK other = (IngenieroSoPK) object;
        if (this.idAreaConocimiento != other.idAreaConocimiento) {
            return false;
        }
        if ((this.sistemaOperativo == null && other.sistemaOperativo != null) || (this.sistemaOperativo != null && !this.sistemaOperativo.equals(other.sistemaOperativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngenieroSoPK[ idAreaConocimiento=" + idAreaConocimiento + ", sistemaOperativo=" + sistemaOperativo + " ]";
    }
    
}
