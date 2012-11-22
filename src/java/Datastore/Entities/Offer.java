/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "OFFER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByNam", query = "SELECT o FROM Offer o WHERE o.nam = :nam"),
    @NamedQuery(name = "Offer.findByTyp", query = "SELECT o FROM Offer o WHERE o.typ = :typ"),
    @NamedQuery(name = "Offer.findByFee", query = "SELECT o FROM Offer o WHERE o.fee = :fee"),
    @NamedQuery(name = "Offer.findByPublicationDate", query = "SELECT o FROM Offer o WHERE o.publicationDate = :publicationDate"),
    @NamedQuery(name = "Offer.findByMonths", query = "SELECT o FROM Offer o WHERE o.months = :months"),
    @NamedQuery(name = "Offer.findByNumAds", query = "SELECT o FROM Offer o WHERE o.numAds = :numAds"),
    @NamedQuery(name = "Offer.findByEndDate", query = "SELECT o FROM Offer o WHERE o.endDate = :endDate")})
public class Offer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Nam")
    private String nam;
    @Size(max = 10)
    @Column(name = "Typ")
    private String typ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fee")
    private int fee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublicationDate")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Months")
    private int months;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumAds")
    private int numAds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "AdminID", referencedColumnName = "AdminID")
    @ManyToOne(optional = false)
    private Administrato adminID;

    public Offer() {
    }

    public Offer(String nam) {
        this.nam = nam;
    }

    public Offer(String nam, int fee, Date publicationDate, int months, int numAds, Date endDate) {
        this.nam = nam;
        this.fee = fee;
        this.publicationDate = publicationDate;
        this.months = months;
        this.numAds = numAds;
        this.endDate = endDate;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getNumAds() {
        return numAds;
    }

    public void setNumAds(int numAds) {
        this.numAds = numAds;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Administrato getAdminID() {
        return adminID;
    }

    public void setAdminID(Administrato adminID) {
        this.adminID = adminID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nam != null ? nam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.nam == null && other.nam != null) || (this.nam != null && !this.nam.equals(other.nam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datastore.Offer[ nam=" + nam + " ]";
    }
    
}
