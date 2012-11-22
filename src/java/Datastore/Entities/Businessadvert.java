/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BUSINESSADVERT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businessadvert.findAll", query = "SELECT b FROM Businessadvert b"),
    @NamedQuery(name = "Businessadvert.findByClientID", query = "SELECT b FROM Businessadvert b WHERE b.businessadvertPK.clientID = :clientID"),
    @NamedQuery(name = "Businessadvert.findByCode", query = "SELECT b FROM Businessadvert b WHERE b.businessadvertPK.code = :code"),
    @NamedQuery(name = "Businessadvert.findByState", query = "SELECT b FROM Businessadvert b WHERE b.state = :state"),
    @NamedQuery(name = "Businessadvert.findByDat", query = "SELECT b FROM Businessadvert b WHERE b.dat = :dat"),
    @NamedQuery(name = "Businessadvert.findByText", query = "SELECT b FROM Businessadvert b WHERE b.text = :text"),
    @NamedQuery(name = "Businessadvert.findByBusiness", query = "SELECT b FROM Businessadvert b WHERE b.business = :business"),
    @NamedQuery(name = "Businessadvert.findBySector", query = "SELECT b FROM Businessadvert b WHERE b.sector = :sector")})
public class Businessadvert implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BusinessadvertPK businessadvertPK;
    @Size(max = 10)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dat")
    @Temporal(TemporalType.DATE)
    private Date dat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Business")
    private String business;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Sector")
    private String sector;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Imag")
    private byte[] imag;
    @JoinColumn(name = "AdminID", referencedColumnName = "AdminID")
    @ManyToOne(optional = false)
    private Administrato adminID;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Registeredclient registeredclient;

    public Businessadvert() {
    }

    public Businessadvert(BusinessadvertPK businessadvertPK) {
        this.businessadvertPK = businessadvertPK;
    }

    public Businessadvert(BusinessadvertPK businessadvertPK, Date dat, String text, String business, String sector, byte[] imag) {
        this.businessadvertPK = businessadvertPK;
        this.dat = dat;
        this.text = text;
        this.business = business;
        this.sector = sector;
        this.imag = imag;
    }

    public Businessadvert(int clientID, int code) {
        this.businessadvertPK = new BusinessadvertPK(clientID, code);
    }

    public BusinessadvertPK getBusinessadvertPK() {
        return businessadvertPK;
    }

    public void setBusinessadvertPK(BusinessadvertPK businessadvertPK) {
        this.businessadvertPK = businessadvertPK;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public byte[] getImag() {
        return imag;
    }

    public void setImag(byte[] imag) {
        this.imag = imag;
    }

    public Administrato getAdminID() {
        return adminID;
    }

    public void setAdminID(Administrato adminID) {
        this.adminID = adminID;
    }

    public Registeredclient getRegisteredclient() {
        return registeredclient;
    }

    public void setRegisteredclient(Registeredclient registeredclient) {
        this.registeredclient = registeredclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessadvertPK != null ? businessadvertPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businessadvert)) {
            return false;
        }
        Businessadvert other = (Businessadvert) object;
        if ((this.businessadvertPK == null && other.businessadvertPK != null) || (this.businessadvertPK != null && !this.businessadvertPK.equals(other.businessadvertPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datastore.Businessadvert[ businessadvertPK=" + businessadvertPK + " ]";
    }
    
}
