/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "BUSINESSADVERT", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businessadvert.findAll", query = "SELECT b FROM Businessadvert b"),
    @NamedQuery(name = "Businessadvert.findByCode", query = "SELECT b FROM Businessadvert b WHERE b.code = :code"),
    @NamedQuery(name = "Businessadvert.findByState", query = "SELECT b FROM Businessadvert b WHERE b.state = :state"),
    @NamedQuery(name = "Businessadvert.findByDat", query = "SELECT b FROM Businessadvert b WHERE b.dat = :dat"),
    @NamedQuery(name = "Businessadvert.findByText", query = "SELECT b FROM Businessadvert b WHERE b.text = :text"),
    @NamedQuery(name = "Businessadvert.findByBusiness", query = "SELECT b FROM Businessadvert b WHERE b.business = :business"),
    @NamedQuery(name = "Businessadvert.findBySector", query = "SELECT b FROM Businessadvert b WHERE b.sector = :sector"),
    @NamedQuery(name = "Businessadvert.findByEndDate", query = "SELECT b FROM Businessadvert b WHERE b.endDate = :endDate")})
public class Businessadvert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code", nullable = false)
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "State", nullable = false, length = 10)
    private String state;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Dat", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Text", nullable = false, length = 250)
    private String text;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Business", nullable = false, length = 20)
    private String business;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Sector", nullable = false, length = 20)
    private String sector;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Imag", nullable = false)
    private byte[] imag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(mappedBy = "businessID")
    private Collection<Conciliation> conciliationCollection;
    @JoinColumn(name = "Offer", referencedColumnName = "Nam", nullable = false)
    @ManyToOne(optional = false)
    private Offer offer;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID", nullable = false)
    @ManyToOne(optional = false)
    private Registeredclient clientID;

    public Businessadvert() {
    }

    public Businessadvert(Integer code) {
        this.code = code;
    }

    public Businessadvert(Integer code, String state, Date dat, String text, String business, String sector, byte[] imag, Date endDate) {
        this.code = code;
        this.state = state;
        this.dat = dat;
        this.text = text;
        this.business = business;
        this.sector = sector;
        this.imag = imag;
        this.endDate = endDate;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Collection<Conciliation> getConciliationCollection() {
        return conciliationCollection;
    }

    public void setConciliationCollection(Collection<Conciliation> conciliationCollection) {
        this.conciliationCollection = conciliationCollection;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
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
        if (!(object instanceof Businessadvert)) {
            return false;
        }
        Businessadvert other = (Businessadvert) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flipmotor.Entities.Businessadvert[ code=" + code + " ]";
    }
    
}
