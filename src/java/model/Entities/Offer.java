/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "OFFER", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByNam", query = "SELECT o FROM Offer o WHERE o.nam = :nam"),
    @NamedQuery(name = "Offer.findByTyp", query = "SELECT o FROM Offer o WHERE o.typ = :typ"),
    @NamedQuery(name = "Offer.findByFee", query = "SELECT o FROM Offer o WHERE o.fee = :fee"),
    @NamedQuery(name = "Offer.findByPublicationDate", query = "SELECT o FROM Offer o WHERE o.publicationDate = :publicationDate"),
    @NamedQuery(name = "Offer.findByMonths", query = "SELECT o FROM Offer o WHERE o.months = :months"),
    @NamedQuery(name = "Offer.findByEndDate", query = "SELECT o FROM Offer o WHERE o.endDate = :endDate"),
    @NamedQuery(name = "Offer.findByActive", query = "SELECT o FROM Offer o WHERE o.active = :active")})
public class Offer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Nam", nullable = false, length = 15)
    private String nam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Typ", nullable = false, length = 10)
    private String typ;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fee", nullable = false)
    private int fee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublicationDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Months", nullable = false)
    private int months;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Active", nullable = false)
    private int active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer")
    private Collection<Vehicleadvert> vehicleadvertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offer")
    private Collection<Businessadvert> businessadvertCollection;

    public Offer() {
    }

    public Offer(String nam) {
        this.nam = nam;
    }

    public Offer(String nam, String typ, int fee, Date publicationDate, int months, Date endDate, int active) {
        this.nam = nam;
        this.typ = typ;
        this.fee = fee;
        this.publicationDate = publicationDate;
        this.months = months;
        this.endDate = endDate;
        this.active = active;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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
        return "Flipmotor.Entities.Offer[ nam=" + nam + " ]";
    }
    
}
