/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SARA
 */
@Entity
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor"),
    @NamedQuery(name = "Autor.findByNombreAutor", query = "SELECT a FROM Autor a WHERE a.nombreAutor = :nombreAutor"),
    @NamedQuery(name = "Autor.findByApellidoAutor", query = "SELECT a FROM Autor a WHERE a.apellidoAutor = :apellidoAutor"),
    @NamedQuery(name = "Autor.findByFechaNacAutor", query = "SELECT a FROM Autor a WHERE a.fechaNacAutor = :fechaNacAutor"),
    @NamedQuery(name = "Autor.findByFechaDefAutor", query = "SELECT a FROM Autor a WHERE a.fechaDefAutor = :fechaDefAutor")})
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_autor")
    private String idAutor;
    @Size(max = 30)
    @Column(name = "nombre_autor")
    private String nombreAutor;
    @Size(max = 60)
    @Column(name = "apellido_autor")
    private String apellidoAutor;
    @Column(name = "fecha_nac_autor")
    @Temporal(TemporalType.DATE)
    private Date fechaNacAutor;
    @Column(name = "fecha_def_autor")
    @Temporal(TemporalType.DATE)
    private Date fechaDefAutor;
    @OneToMany(mappedBy = "idAutor")
    private List<Libro> libroList;
    @JoinColumn(name = "id_pais_autor", referencedColumnName = "id")
    @ManyToOne
    private Pais idPaisAutor;

    public Autor() {
    }

    public Autor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public Date getFechaNacAutor() {
        return fechaNacAutor;
    }

    public void setFechaNacAutor(Date fechaNacAutor) {
        this.fechaNacAutor = fechaNacAutor;
    }

    public Date getFechaDefAutor() {
        return fechaDefAutor;
    }

    public void setFechaDefAutor(Date fechaDefAutor) {
        this.fechaDefAutor = fechaDefAutor;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    public Pais getIdPaisAutor() {
        return idPaisAutor;
    }

    public void setIdPaisAutor(Pais idPaisAutor) {
        this.idPaisAutor = idPaisAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Autor[ idAutor=" + idAutor + " ]";
    }
    
}
