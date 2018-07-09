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
@Table(name = "arriendo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arriendo.findAll", query = "SELECT a FROM Arriendo a")
    , @NamedQuery(name = "Arriendo.findByIdarriendo", query = "SELECT a FROM Arriendo a WHERE a.idarriendo = :idarriendo")
    , @NamedQuery(name = "Arriendo.findByFechaarriendo", query = "SELECT a FROM Arriendo a WHERE a.fechaarriendo = :fechaarriendo")
    , @NamedQuery(name = "Arriendo.findByValorarriendo", query = "SELECT a FROM Arriendo a WHERE a.valorarriendo = :valorarriendo")})
public class Arriendo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarriendo")
    private Integer idarriendo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "fechaarriendo")
    private String fechaarriendo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorarriendo")
    private int valorarriendo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarriendo")
    private List<Detallearriendo> detallearriendoList;
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente rut;

    public Arriendo() {
    }

    public Arriendo(Integer idarriendo) {
        this.idarriendo = idarriendo;
    }

    public Arriendo(Integer idarriendo, String fechaarriendo, int valorarriendo) {
        this.idarriendo = idarriendo;
        this.fechaarriendo = fechaarriendo;
        this.valorarriendo = valorarriendo;
    }

    public Integer getIdarriendo() {
        return idarriendo;
    }

    public void setIdarriendo(Integer idarriendo) {
        this.idarriendo = idarriendo;
    }

    public String getFechaarriendo() {
        return fechaarriendo;
    }

    public void setFechaarriendo(String fechaarriendo) {
        this.fechaarriendo = fechaarriendo;
    }

    public int getValorarriendo() {
        return valorarriendo;
    }

    public void setValorarriendo(int valorarriendo) {
        this.valorarriendo = valorarriendo;
    }

    @XmlTransient
    public List<Detallearriendo> getDetallearriendoList() {
        return detallearriendoList;
    }

    public void setDetallearriendoList(List<Detallearriendo> detallearriendoList) {
        this.detallearriendoList = detallearriendoList;
    }

    public Cliente getRut() {
        return rut;
    }

    public void setRut(Cliente rut) {
        this.rut = rut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarriendo != null ? idarriendo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arriendo)) {
            return false;
        }
        Arriendo other = (Arriendo) object;
        if ((this.idarriendo == null && other.idarriendo != null) || (this.idarriendo != null && !this.idarriendo.equals(other.idarriendo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.per.Arriendo[ idarriendo=" + idarriendo + " ]";
    }
    
}
