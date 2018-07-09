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
@Table(name = "detallearriendo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallearriendo.findAll", query = "SELECT d FROM Detallearriendo d")
    , @NamedQuery(name = "Detallearriendo.findByIddetalle", query = "SELECT d FROM Detallearriendo d WHERE d.iddetalle = :iddetalle")
    , @NamedQuery(name = "Detallearriendo.findByDiasprestamo", query = "SELECT d FROM Detallearriendo d WHERE d.diasprestamo = :diasprestamo")
    , @NamedQuery(name = "Detallearriendo.findByFechadevolucion", query = "SELECT d FROM Detallearriendo d WHERE d.fechadevolucion = :fechadevolucion")})
public class Detallearriendo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle")
    private Integer iddetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diasprestamo")
    private int diasprestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "fechadevolucion")
    private String fechadevolucion;
    @JoinColumn(name = "idarriendo", referencedColumnName = "idarriendo")
    @ManyToOne(optional = false)
    private Arriendo idarriendo;
    @JoinColumn(name = "iddvd", referencedColumnName = "iddvd")
    @ManyToOne(optional = false)
    private Dvd iddvd;

    public Detallearriendo() {
    }

    public Detallearriendo(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public Detallearriendo(Integer iddetalle, int diasprestamo, String fechadevolucion) {
        this.iddetalle = iddetalle;
        this.diasprestamo = diasprestamo;
        this.fechadevolucion = fechadevolucion;
    }

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getDiasprestamo() {
        return diasprestamo;
    }

    public void setDiasprestamo(int diasprestamo) {
        this.diasprestamo = diasprestamo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public Arriendo getIdarriendo() {
        return idarriendo;
    }

    public void setIdarriendo(Arriendo idarriendo) {
        this.idarriendo = idarriendo;
    }

    public Dvd getIddvd() {
        return iddvd;
    }

    public void setIddvd(Dvd iddvd) {
        this.iddvd = iddvd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalle != null ? iddetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallearriendo)) {
            return false;
        }
        Detallearriendo other = (Detallearriendo) object;
        if ((this.iddetalle == null && other.iddetalle != null) || (this.iddetalle != null && !this.iddetalle.equals(other.iddetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.per.Detallearriendo[ iddetalle=" + iddetalle + " ]";
    }
    
}
