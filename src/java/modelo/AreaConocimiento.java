/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "area_conocimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaConocimiento.findAll", query = "SELECT a FROM AreaConocimiento a"),
    @NamedQuery(name = "AreaConocimiento.findById", query = "SELECT a FROM AreaConocimiento a WHERE a.id = :id")})
public class AreaConocimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaConocimiento")
    private List<IngenieroSo> ingenieroSoList;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingeniero idIngeniero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaConocimiento")
    private List<IngenieroLenguaje> ingenieroLenguajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaConocimiento")
    private List<IngenieroBaseDatos> ingenieroBaseDatosList;

    public AreaConocimiento() {
    }

    public AreaConocimiento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<IngenieroSo> getIngenieroSoList() {
        return ingenieroSoList;
    }

    public void setIngenieroSoList(List<IngenieroSo> ingenieroSoList) {
        this.ingenieroSoList = ingenieroSoList;
    }

    public Ingeniero getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Ingeniero idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    @XmlTransient
    public List<IngenieroLenguaje> getIngenieroLenguajeList() {
        return ingenieroLenguajeList;
    }

    public void setIngenieroLenguajeList(List<IngenieroLenguaje> ingenieroLenguajeList) {
        this.ingenieroLenguajeList = ingenieroLenguajeList;
    }

    @XmlTransient
    public List<IngenieroBaseDatos> getIngenieroBaseDatosList() {
        return ingenieroBaseDatosList;
    }

    public void setIngenieroBaseDatosList(List<IngenieroBaseDatos> ingenieroBaseDatosList) {
        this.ingenieroBaseDatosList = ingenieroBaseDatosList;
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
        if (!(object instanceof AreaConocimiento)) {
            return false;
        }
        AreaConocimiento other = (AreaConocimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AreaConocimiento[ id=" + id + " ]";
    }
    
}
