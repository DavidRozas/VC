/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.per;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Davo
 */
@Entity
@Table(name = "titulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Titulo.findAll", query = "SELECT t FROM Titulo t")
    , @NamedQuery(name = "Titulo.findByIdtitulo", query = "SELECT t FROM Titulo t WHERE t.idtitulo = :idtitulo")
    , @NamedQuery(name = "Titulo.findByNombretitulo", query = "SELECT t FROM Titulo t WHERE t.nombretitulo = :nombretitulo")
    , @NamedQuery(name = "Titulo.findByTema", query = "SELECT t FROM Titulo t WHERE t.tema = :tema")
    , @NamedQuery(name = "Titulo.findByIdioma", query = "SELECT t FROM Titulo t WHERE t.idioma = :idioma")
    , @NamedQuery(name = "Titulo.findByEstadotitulo", query = "SELECT t FROM Titulo t WHERE t.estadotitulo = :estadotitulo")})
public class Titulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtitulo")
    private Integer idtitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombretitulo")
    private String nombretitulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tema")
    private String tema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "idioma")
    private String idioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estadotitulo")
    private String estadotitulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtitulo")
    private List<Dvd> dvdList;

    public Titulo() {
    }

    public Titulo(Integer idtitulo) {
        this.idtitulo = idtitulo;
    }

    public Titulo(Integer idtitulo, String nombretitulo, String tema, String idioma, String estadotitulo) {
        this.idtitulo = idtitulo;
        this.nombretitulo = nombretitulo;
        this.tema = tema;
        this.idioma = idioma;
        this.estadotitulo = estadotitulo;
    }

    public Integer getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(Integer idtitulo) {
        this.idtitulo = idtitulo;
    }

    public String getNombretitulo() {
        return nombretitulo;
    }

    public void setNombretitulo(String nombretitulo) {
        this.nombretitulo = nombretitulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEstadotitulo() {
        return estadotitulo;
    }

    public void setEstadotitulo(String estadotitulo) {
        this.estadotitulo = estadotitulo;
    }

    @XmlTransient
    public List<Dvd> getDvdList() {
        return dvdList;
    }

    public void setDvdList(List<Dvd> dvdList) {
        this.dvdList = dvdList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtitulo != null ? idtitulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulo)) {
            return false;
        }
        Titulo other = (Titulo) object;
        if ((this.idtitulo == null && other.idtitulo != null) || (this.idtitulo != null && !this.idtitulo.equals(other.idtitulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.per.Titulo[ idtitulo=" + idtitulo + " ]";
    }
    
}
