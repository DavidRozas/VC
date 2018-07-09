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
 * @author Davo
 */
@Entity
@Table(name = "dvd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvd.findAll", query = "SELECT d FROM Dvd d")
    , @NamedQuery(name = "Dvd.findByIddvd", query = "SELECT d FROM Dvd d WHERE d.iddvd = :iddvd")
    , @NamedQuery(name = "Dvd.findByEstado", query = "SELECT d FROM Dvd d WHERE d.estado = :estado")
    , @NamedQuery(name = "Dvd.findByUbicacion", query = "SELECT d FROM Dvd d WHERE d.ubicacion = :ubicacion")
    , @NamedQuery(name = "Dvd.findByCondicion", query = "SELECT d FROM Dvd d WHERE d.condicion = :condicion")})
public class Dvd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddvd")
    private Integer iddvd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "condicion")
    private String condicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddvd")
    private List<Detallearriendo> detallearriendoList;
    @JoinColumn(name = "idtitulo", referencedColumnName = "idtitulo")
    @ManyToOne(optional = false)
    private Titulo idtitulo;

    public Dvd() {
    }

    public Dvd(Integer iddvd) {
        this.iddvd = iddvd;
    }

    public Dvd(Integer iddvd, String estado, String ubicacion, String condicion) {
        this.iddvd = iddvd;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.condicion = condicion;
    }

    public Integer getIddvd() {
        return iddvd;
    }

    public void setIddvd(Integer iddvd) {
        this.iddvd = iddvd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    @XmlTransient
    public List<Detallearriendo> getDetallearriendoList() {
        return detallearriendoList;
    }

    public void setDetallearriendoList(List<Detallearriendo> detallearriendoList) {
        this.detallearriendoList = detallearriendoList;
    }

    public Titulo getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(Titulo idtitulo) {
        this.idtitulo = idtitulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddvd != null ? iddvd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dvd)) {
            return false;
        }
        Dvd other = (Dvd) object;
        if ((this.iddvd == null && other.iddvd != null) || (this.iddvd != null && !this.iddvd.equals(other.iddvd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.per.Dvd[ iddvd=" + iddvd + " ]";
    }
    
}
