/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "VEHICLEADVERT", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicleadvert.findAll", query = "SELECT v FROM Vehicleadvert v"),
    @NamedQuery(name = "Vehicleadvert.findByCode", query = "SELECT v FROM Vehicleadvert v WHERE v.code = :code"),
    @NamedQuery(name = "Vehicleadvert.findByState", query = "SELECT v FROM Vehicleadvert v WHERE v.state = :state"),
    @NamedQuery(name = "Vehicleadvert.findByEmail", query = "SELECT v FROM Vehicleadvert v WHERE v.email = :email"),
    @NamedQuery(name = "Vehicleadvert.findByVehicle", query = "SELECT v FROM Vehicleadvert v WHERE v.vehicle = :vehicle"),
    @NamedQuery(name = "Vehicleadvert.findByBrand", query = "SELECT v FROM Vehicleadvert v WHERE v.brand = :brand"),
    @NamedQuery(name = "Vehicleadvert.findByModelV", query = "SELECT v FROM Vehicleadvert v WHERE v.modelV = :modelV"),
    @NamedQuery(name = "Vehicleadvert.findByColor", query = "SELECT v FROM Vehicleadvert v WHERE v.color = :color"),
    @NamedQuery(name = "Vehicleadvert.findByYearV", query = "SELECT v FROM Vehicleadvert v WHERE v.yearV = :yearV"),
    @NamedQuery(name = "Vehicleadvert.findByKm", query = "SELECT v FROM Vehicleadvert v WHERE v.km = :km"),
    @NamedQuery(name = "Vehicleadvert.findByPublicationDate", query = "SELECT v FROM Vehicleadvert v WHERE v.publicationDate = :publicationDate"),
    @NamedQuery(name = "Vehicleadvert.findByPrice", query = "SELECT v FROM Vehicleadvert v WHERE v.price = :price"),
    @NamedQuery(name = "Vehicleadvert.findByRegion", query = "SELECT v FROM Vehicleadvert v WHERE v.region = :region"),
    @NamedQuery(name = "Vehicleadvert.findByText", query = "SELECT v FROM Vehicleadvert v WHERE v.text = :text"),
    @NamedQuery(name = "Vehicleadvert.findByEndDate", query = "SELECT v FROM Vehicleadvert v WHERE v.endDate = :endDate")})
public class Vehicleadvert implements Serializable {
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
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Email", nullable = false, length = 40)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Vehicle", nullable = false, length = 10)
    private String vehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Brand", nullable = false, length = 15)
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ModelV", nullable = false, length = 15)
    private String modelV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Color", nullable = false, length = 12)
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YearV", nullable = false)
    private int yearV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Km", nullable = false)
    private int km;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublicationDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Imag", nullable = false)
    private byte[] imag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Region", nullable = false, length = 20)
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Text", nullable = false, length = 250)
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @OneToMany(mappedBy = "vehicleID")
    private Collection<Conciliation> conciliationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private Collection<Fav> favCollection;
    @JoinColumn(name = "Offer", referencedColumnName = "Nam", nullable = false)
    @ManyToOne(optional = false)
    private Offer offer;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID", nullable = false)
    @ManyToOne(optional = false)
    private Registeredclient clientID;

    public Vehicleadvert() {
    }

    public Vehicleadvert(Integer code) {
        this.code = code;
    }

    public Vehicleadvert(Integer code, String state, String email, String vehicle, String brand, String modelV, String color, int yearV, int km, Date publicationDate, int price, byte[] imag, String region, String text, Date endDate) {
        this.code = code;
        this.state = state;
        this.email = email;
        this.vehicle = vehicle;
        this.brand = brand;
        this.modelV = modelV;
        this.color = color;
        this.yearV = yearV;
        this.km = km;
        this.publicationDate = publicationDate;
        this.price = price;
        this.imag = imag;
        this.region = region;
        this.text = text;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelV() {
        return modelV;
    }

    public void setModelV(String modelV) {
        this.modelV = modelV;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearV() {
        return yearV;
    }

    public void setYearV(int yearV) {
        this.yearV = yearV;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getImag() {
        return imag;
    }

    public void setImag(byte[] imag) {
        this.imag = imag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    @XmlTransient
    public Collection<Fav> getFavCollection() {
        return favCollection;
    }

    public void setFavCollection(Collection<Fav> favCollection) {
        this.favCollection = favCollection;
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
        if (!(object instanceof Vehicleadvert)) {
            return false;
        }
        Vehicleadvert other = (Vehicleadvert) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flipmotor.Entities.Vehicleadvert[ code=" + code + " ]";
    }
    
}
