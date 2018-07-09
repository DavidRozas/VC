/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.per;

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
 * @author Davo
 */
@Entity
@Table(name = "sansion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sansion.findAll", query = "SELECT s FROM Sansion s")
    , @NamedQuery(name = "Sansion.findByIdsansion", query = "SELECT s FROM Sansion s WHERE s.idsansion = :idsansion")
    , @NamedQuery(name = "Sansion.findByTiposansion", query = "SELECT s FROM Sansion s WHERE s.tiposansion = :tiposansion")
    , @NamedQuery(name = "Sansion.findByDiassancion", query = "SELECT s FROM Sansion s WHERE s.diassancion = :diassancion")})
public class Sansion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsansion")
    private Integer idsansion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tiposansion")
    private String tiposansion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diassancion")
    private int diassancion;
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente rut;

    public Sansion() {
    }

    public Sansion(Integer idsansion) {
        this.idsansion = idsansion;
    }

    public Sansion(Integer idsansion, String tiposansion, int diassancion) {
        this.idsansion = idsansion;
        this.tiposansion = tiposansion;
        this.diassancion = diassancion;
    }

    public Integer getIdsansion() {
        return idsansion;
    }

    public void setIdsansion(Integer idsansion) {
        this.idsansion = idsansion;
    }

    public String getTiposansion() {
        return tiposansion;
    }

    public void setTiposansion(String tiposansion) {
        this.tiposansion = tiposansion;
    }

    public int getDiassancion() {
        return diassancion;
    }

    public void setDiassancion(int diassancion) {
        this.diassancion = diassancion;
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
        hash += (idsansion != null ? idsansion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sansion)) {
            return false;
        }
        Sansion other = (Sansion) object;
        if ((this.idsansion == null && other.idsansion != null) || (this.idsansion != null && !this.idsansion.equals(other.idsansion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.per.Sansion[ idsansion=" + idsansion + " ]";
    }
    
}
