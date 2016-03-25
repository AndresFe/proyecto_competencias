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
@Table(name = "proyecto_software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoSoftware.findAll", query = "SELECT p FROM ProyectoSoftware p"),
    @NamedQuery(name = "ProyectoSoftware.findById", query = "SELECT p FROM ProyectoSoftware p WHERE p.id = :id")})
public class ProyectoSoftware implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "desarrolladores", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Desarrolladores desarrolladores;
    @JoinColumn(name = "id_ingeniero_senior", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingeniero idIngenieroSenior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoSoftware")
    private List<AsignacionProyecto> asignacionProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoSoftware")
    private List<RequisitosDelProyecto> requisitosDelProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyectoSoftware")
    private List<Desarrolladores> desarrolladoresList;

    public ProyectoSoftware() {
    }

    public ProyectoSoftware(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Desarrolladores getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(Desarrolladores desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public Ingeniero getIdIngenieroSenior() {
        return idIngenieroSenior;
    }

    public void setIdIngenieroSenior(Ingeniero idIngenieroSenior) {
        this.idIngenieroSenior = idIngenieroSenior;
    }

    @XmlTransient
    public List<AsignacionProyecto> getAsignacionProyectoList() {
        return asignacionProyectoList;
    }

    public void setAsignacionProyectoList(List<AsignacionProyecto> asignacionProyectoList) {
        this.asignacionProyectoList = asignacionProyectoList;
    }

    @XmlTransient
    public List<RequisitosDelProyecto> getRequisitosDelProyectoList() {
        return requisitosDelProyectoList;
    }

    public void setRequisitosDelProyectoList(List<RequisitosDelProyecto> requisitosDelProyectoList) {
        this.requisitosDelProyectoList = requisitosDelProyectoList;
    }

    @XmlTransient
    public List<Desarrolladores> getDesarrolladoresList() {
        return desarrolladoresList;
    }

    public void setDesarrolladoresList(List<Desarrolladores> desarrolladoresList) {
        this.desarrolladoresList = desarrolladoresList;
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
        if (!(object instanceof ProyectoSoftware)) {
            return false;
        }
        ProyectoSoftware other = (ProyectoSoftware) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectoSoftware[ id=" + id + " ]";
    }
    
}
