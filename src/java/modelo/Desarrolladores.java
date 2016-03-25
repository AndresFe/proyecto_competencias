/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "desarrolladores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desarrolladores.findAll", query = "SELECT d FROM Desarrolladores d"),
    @NamedQuery(name = "Desarrolladores.findById", query = "SELECT d FROM Desarrolladores d WHERE d.id = :id"),
    @NamedQuery(name = "Desarrolladores.findByFechaInicio", query = "SELECT d FROM Desarrolladores d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Desarrolladores.findByFechaFin", query = "SELECT d FROM Desarrolladores d WHERE d.fechaFin = :fechaFin")})
public class Desarrolladores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desarrolladores")
    private List<ProyectoSoftware> proyectoSoftwareList;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingeniero idIngeniero;
    @JoinColumn(name = "id_proyecto_software", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProyectoSoftware idProyectoSoftware;

    public Desarrolladores() {
    }

    public Desarrolladores(Integer id) {
        this.id = id;
    }

    public Desarrolladores(Integer id, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<ProyectoSoftware> getProyectoSoftwareList() {
        return proyectoSoftwareList;
    }

    public void setProyectoSoftwareList(List<ProyectoSoftware> proyectoSoftwareList) {
        this.proyectoSoftwareList = proyectoSoftwareList;
    }

    public Ingeniero getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Ingeniero idIngeniero) {
        this.idIngeniero = idIngeniero;
    }

    public ProyectoSoftware getIdProyectoSoftware() {
        return idProyectoSoftware;
    }

    public void setIdProyectoSoftware(ProyectoSoftware idProyectoSoftware) {
        this.idProyectoSoftware = idProyectoSoftware;
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
        if (!(object instanceof Desarrolladores)) {
            return false;
        }
        Desarrolladores other = (Desarrolladores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Desarrolladores[ id=" + id + " ]";
    }
    
}
