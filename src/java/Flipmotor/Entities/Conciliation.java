/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.Entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "CONCILIATION", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conciliation.findAll", query = "SELECT c FROM Conciliation c"),
    @NamedQuery(name = "Conciliation.findByCode", query = "SELECT c FROM Conciliation c WHERE c.code = :code"),
    @NamedQuery(name = "Conciliation.findByTdate", query = "SELECT c FROM Conciliation c WHERE c.tdate = :tdate"),
    @NamedQuery(name = "Conciliation.findByPrice", query = "SELECT c FROM Conciliation c WHERE c.price = :price"),
    @NamedQuery(name = "Conciliation.findByCreditcard", query = "SELECT c FROM Conciliation c WHERE c.creditcard = :creditcard")})
public class Conciliation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code", nullable = false)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Creditcard", nullable = false)
    private long creditcard;
    @JoinColumn(name = "VehicleID", referencedColumnName = "Code")
    @ManyToOne
    private Vehicleadvert vehicleID;
    @JoinColumn(name = "BusinessID", referencedColumnName = "Code")
    @ManyToOne
    private Businessadvert businessID;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID", nullable = false)
    @ManyToOne(optional = false)
    private Registeredclient clientID;

    public Conciliation() {
    }

    public Conciliation(Integer code) {
        this.code = code;
    }

    public Conciliation(Integer code, Date tdate, int price, long creditcard) {
        this.code = code;
        this.tdate = tdate;
        this.price = price;
        this.creditcard = creditcard;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(long creditcard) {
        this.creditcard = creditcard;
    }

    public Vehicleadvert getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Vehicleadvert vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Businessadvert getBusinessID() {
        return businessID;
    }

    public void setBusinessID(Businessadvert businessID) {
        this.businessID = businessID;
    }

    public Registeredclient getClientID() {
        return clientID;
    }

    public void setClientID(Registeredclient clientID) {
        this.clientID = clientID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conciliation)) {
            return false;
        }
        Conciliation other = (Conciliation) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flipmotor.Entities.Conciliation[ code=" + code + " ]";
    }
    
}
