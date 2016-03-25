/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "grados_academicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradosAcademicos.findAll", query = "SELECT g FROM GradosAcademicos g"),
    @NamedQuery(name = "GradosAcademicos.findById", query = "SELECT g FROM GradosAcademicos g WHERE g.id = :id"),
    @NamedQuery(name = "GradosAcademicos.findByCentroFormacion", query = "SELECT g FROM GradosAcademicos g WHERE g.centroFormacion = :centroFormacion"),
    @NamedQuery(name = "GradosAcademicos.findByTituloObtenido", query = "SELECT g FROM GradosAcademicos g WHERE g.tituloObtenido = :tituloObtenido")})
public class GradosAcademicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "centro_formacion")
    private String centroFormacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "titulo_obtenido")
    private String tituloObtenido;
    @JoinColumn(name = "tipo_grado_academico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoGradosAcademicos tipoGradoAcademico;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingeniero idIngeniero;

    public GradosAcademicos() {
    }

    public GradosAcademicos(Integer id) {
        this.id = id;
    }

    public GradosAcademicos(Integer id, String centroFormacion, String tituloObtenido) {
        this.id = id;
        this.centroFormacion = centroFormacion;
        this.tituloObtenido = tituloObtenido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCentroFormacion() {
        return centroFormacion;
    }

    public void setCentroFormacion(String centroFormacion) {
        this.centroFormacion = centroFormacion;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }

    public TipoGradosAcademicos getTipoGradoAcademico() {
        return tipoGradoAcademico;
    }

    public void setTipoGradoAcademico(TipoGradosAcademicos tipoGradoAcademico) {
        this.tipoGradoAcademico = tipoGradoAcademico;
    }

    public Ingeniero getIdIngeniero() {
        return idIngeniero;
    }

    public void setIdIngeniero(Ingeniero idIngeniero) {
        this.idIngeniero = idIngeniero;
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
        if (!(object instanceof GradosAcademicos)) {
            return false;
        }
        GradosAcademicos other = (GradosAcademicos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GradosAcademicos[ id=" + id + " ]";
    }
    
}
