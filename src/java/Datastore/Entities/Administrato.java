/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author root
 */
@Entity
@Table(name = "ADMINISTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrato.findAll", query = "SELECT a FROM Administrato a"),
    @NamedQuery(name = "Administrato.findByAdminID", query = "SELECT a FROM Administrato a WHERE a.adminID = :adminID"),
    @NamedQuery(name = "Administrato.findByUsername", query = "SELECT a FROM Administrato a WHERE a.username = :username"),
    @NamedQuery(name = "Administrato.findByPasswor", query = "SELECT a FROM Administrato a WHERE a.passwor = :passwor")})
public class Administrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdminID")
    private Integer adminID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Passwor")
    private String passwor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminID")
    private Collection<Vehicleadvert> vehicleadvertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminID")
    private Collection<Businessadvert> businessadvertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminID")
    private Collection<Offer> offerCollection;

    public Administrato() {
    }

    public Administrato(Integer adminID) {
        this.adminID = adminID;
    }

    public Administrato(Integer adminID, String username, String passwor) {
        this.adminID = adminID;
        this.username = username;
        this.passwor = passwor;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    @XmlTransient
    public Collection<Vehicleadvert> getVehicleadvertCollection() {
        return vehicleadvertCollection;
    }

    public void setVehicleadvertCollection(Collection<Vehicleadvert> vehicleadvertCollection) {
        this.vehicleadvertCollection = vehicleadvertCollection;
    }

    @XmlTransient
    public Collection<Businessadvert> getBusinessadvertCollection() {
        return businessadvertCollection;
    }

    public void setBusinessadvertCollection(Collection<Businessadvert> businessadvertCollection) {
        this.businessadvertCollection = businessadvertCollection;
    }

    @XmlTransient
    public Collection<Offer> getOfferCollection() {
        return offerCollection;
    }

    public void setOfferCollection(Collection<Offer> offerCollection) {
        this.offerCollection = offerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminID != null ? adminID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrato)) {
            return false;
        }
        Administrato other = (Administrato) object;
        if ((this.adminID == null && other.adminID != null) || (this.adminID != null && !this.adminID.equals(other.adminID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datastore.Administrato[ adminID=" + adminID + " ]";
    }
    
}
