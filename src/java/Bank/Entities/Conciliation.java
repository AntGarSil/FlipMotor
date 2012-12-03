/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "conciliation", catalog = "bank", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conciliation.findAll", query = "SELECT c FROM Conciliation c"),
    @NamedQuery(name = "Conciliation.findByCode", query = "SELECT c FROM Conciliation c WHERE c.code = :code"),
    @NamedQuery(name = "Conciliation.findByTdate", query = "SELECT c FROM Conciliation c WHERE c.tdate = :tdate"),
    @NamedQuery(name = "Conciliation.findByBuyerID", query = "SELECT c FROM Conciliation c WHERE c.buyerID = :buyerID"),
    @NamedQuery(name = "Conciliation.findBySellerID", query = "SELECT c FROM Conciliation c WHERE c.sellerID = :sellerID"),
    @NamedQuery(name = "Conciliation.findByPrice", query = "SELECT c FROM Conciliation c WHERE c.price = :price"),
    @NamedQuery(name = "Conciliation.findByVehicleID", query = "SELECT c FROM Conciliation c WHERE c.vehicleID = :vehicleID"),
    @NamedQuery(name = "Conciliation.findByBusinessID", query = "SELECT c FROM Conciliation c WHERE c.businessID = :businessID"),
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
    @Column(name = "BuyerID", nullable = false)
    private int buyerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SellerID", nullable = false)
    private int sellerID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VehicleID", nullable = false)
    private int vehicleID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BusinessID", nullable = false)
    private int businessID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Creditcard", nullable = false)
    private long creditcard;

    public Conciliation() {
    }

    public Conciliation(Integer code) {
        this.code = code;
    }

    public Conciliation(Integer code, Date tdate, int buyerID, int sellerID, int price, int vehicleID, int businessID, long creditcard) {
        this.code = code;
        this.tdate = tdate;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
        this.price = price;
        this.vehicleID = vehicleID;
        this.businessID = businessID;
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

    public int getBuyerID() {
        return buyerID;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getBusinessID() {
        return businessID;
    }

    public void setBusinessID(int businessID) {
        this.businessID = businessID;
    }

    public long getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(long creditcard) {
        this.creditcard = creditcard;
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
        return "Bank.Entities.Conciliation[ code=" + code + " ]";
    }
    
}
