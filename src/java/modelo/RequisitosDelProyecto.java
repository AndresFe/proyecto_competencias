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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "requisitos_del_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitosDelProyecto.findAll", query = "SELECT r FROM RequisitosDelProyecto r"),
    @NamedQuery(name = "RequisitosDelProyecto.findById", query = "SELECT r FROM RequisitosDelProyecto r WHERE r.id = :id"),
    @NamedQuery(name = "RequisitosDelProyecto.findByDescripcion", query = "SELECT r FROM RequisitosDelProyecto r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RequisitosDelProyecto.findByEstado", query = "SELECT r FROM RequisitosDelProyecto r WHERE r.estado = :estado")})
public class RequisitosDelProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRequisitosProyecto")
    private List<GestionDeRequisitos> gestionDeRequisitosList;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoRequisito tipo;
    @JoinColumn(name = "id_proyecto_software", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProyectoSoftware idProyectoSoftware;

    public RequisitosDelProyecto() {
    }

    public RequisitosDelProyecto(Integer id) {
        this.id = id;
    }

    public RequisitosDelProyecto(Integer id, String descripcion, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<GestionDeRequisitos> getGestionDeRequisitosList() {
        return gestionDeRequisitosList;
    }

    public void setGestionDeRequisitosList(List<GestionDeRequisitos> gestionDeRequisitosList) {
        this.gestionDeRequisitosList = gestionDeRequisitosList;
    }

    public TipoRequisito getTipo() {
        return tipo;
    }

    public void setTipo(TipoRequisito tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof RequisitosDelProyecto)) {
            return false;
        }
        RequisitosDelProyecto other = (RequisitosDelProyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RequisitosDelProyecto[ id=" + id + " ]";
    }
    
}
