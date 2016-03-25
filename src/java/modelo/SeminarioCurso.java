/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "seminario_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeminarioCurso.findAll", query = "SELECT s FROM SeminarioCurso s"),
    @NamedQuery(name = "SeminarioCurso.findById", query = "SELECT s FROM SeminarioCurso s WHERE s.id = :id"),
    @NamedQuery(name = "SeminarioCurso.findByNombreSeminarioCurso", query = "SELECT s FROM SeminarioCurso s WHERE s.nombreSeminarioCurso = :nombreSeminarioCurso"),
    @NamedQuery(name = "SeminarioCurso.findByLugarSeminarioCurso", query = "SELECT s FROM SeminarioCurso s WHERE s.lugarSeminarioCurso = :lugarSeminarioCurso"),
    @NamedQuery(name = "SeminarioCurso.findByFechaInicioCursoSeminario", query = "SELECT s FROM SeminarioCurso s WHERE s.fechaInicioCursoSeminario = :fechaInicioCursoSeminario"),
    @NamedQuery(name = "SeminarioCurso.findByFechaFinCursoSeminario", query = "SELECT s FROM SeminarioCurso s WHERE s.fechaFinCursoSeminario = :fechaFinCursoSeminario")})
public class SeminarioCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_seminario_curso")
    private String nombreSeminarioCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lugar_seminario_curso")
    private String lugarSeminarioCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_curso_seminario")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioCursoSeminario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_curso_seminario")
    @Temporal(TemporalType.DATE)
    private Date fechaFinCursoSeminario;
    @JoinColumn(name = "id_ingeniero", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingeniero idIngeniero;

    public SeminarioCurso() {
    }

    public SeminarioCurso(Integer id) {
        this.id = id;
    }

    public SeminarioCurso(Integer id, String nombreSeminarioCurso, String lugarSeminarioCurso, Date fechaInicioCursoSeminario, Date fechaFinCursoSeminario) {
        this.id = id;
        this.nombreSeminarioCurso = nombreSeminarioCurso;
        this.lugarSeminarioCurso = lugarSeminarioCurso;
        this.fechaInicioCursoSeminario = fechaInicioCursoSeminario;
        this.fechaFinCursoSeminario = fechaFinCursoSeminario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSeminarioCurso() {
        return nombreSeminarioCurso;
    }

    public void setNombreSeminarioCurso(String nombreSeminarioCurso) {
        this.nombreSeminarioCurso = nombreSeminarioCurso;
    }

    public String getLugarSeminarioCurso() {
        return lugarSeminarioCurso;
    }

    public void setLugarSeminarioCurso(String lugarSeminarioCurso) {
        this.lugarSeminarioCurso = lugarSeminarioCurso;
    }

    public Date getFechaInicioCursoSeminario() {
        return fechaInicioCursoSeminario;
    }

    public void setFechaInicioCursoSeminario(Date fechaInicioCursoSeminario) {
        this.fechaInicioCursoSeminario = fechaInicioCursoSeminario;
    }

    public Date getFechaFinCursoSeminario() {
        return fechaFinCursoSeminario;
    }

    public void setFechaFinCursoSeminario(Date fechaFinCursoSeminario) {
        this.fechaFinCursoSeminario = fechaFinCursoSeminario;
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
        if (!(object instanceof SeminarioCurso)) {
            return false;
        }
        SeminarioCurso other = (SeminarioCurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeminarioCurso[ id=" + id + " ]";
    }
    
}
