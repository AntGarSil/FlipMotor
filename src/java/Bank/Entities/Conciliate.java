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
@Table(name = "CONCILIATE", catalog = "bank", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conciliate.findAll", query = "SELECT c FROM Conciliate c"),
    @NamedQuery(name = "Conciliate.findByCode", query = "SELECT c FROM Conciliate c WHERE c.code = :code"),
    @NamedQuery(name = "Conciliate.findByTdate", query = "SELECT c FROM Conciliate c WHERE c.tdate = :tdate"),
    @NamedQuery(name = "Conciliate.findByClientID", query = "SELECT c FROM Conciliate c WHERE c.clientID = :clientID"),
    @NamedQuery(name = "Conciliate.findByPrice", query = "SELECT c FROM Conciliate c WHERE c.price = :price"),
    @NamedQuery(name = "Conciliate.findByAdvertID", query = "SELECT c FROM Conciliate c WHERE c.advertID = :advertID"),
    @NamedQuery(name = "Conciliate.findByType", query = "SELECT c FROM Conciliate c WHERE c.type = :type"),
    @NamedQuery(name = "Conciliate.findByCreditcard", query = "SELECT c FROM Conciliate c WHERE c.creditcard = :creditcard")})
public class Conciliate implements Serializable {
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
    @Column(name = "ClientID", nullable = false)
    private int clientID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdvertID", nullable = false)
    private int advertID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Type", nullable = false)
    private int type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Creditcard", nullable = false)
    private long creditcard;

    public Conciliate() {
    }

    public Conciliate(Integer code) {
        this.code = code;
    }

    public Conciliate(Integer code, Date tdate, int clientID, int price, int advertID, int type, long creditcard) {
        this.code = code;
        this.tdate = tdate;
        this.clientID = clientID;
        this.price = price;
        this.advertID = advertID;
        this.type = type;
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

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAdvertID() {
        return advertID;
    }

    public void setAdvertID(int advertID) {
        this.advertID = advertID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        if (!(object instanceof Conciliate)) {
            return false;
        }
        Conciliate other = (Conciliate) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bank.Entities.Conciliate[ code=" + code + " ]";
    }
    
}
