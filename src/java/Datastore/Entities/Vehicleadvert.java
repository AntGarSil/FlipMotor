/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "VEHICLEADVERT")
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
    @NamedQuery(name = "Vehicleadvert.findByOffer", query = "SELECT v FROM Vehicleadvert v WHERE v.offer = :offer")})
public class Vehicleadvert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code")
    private Integer code;
    @Size(max = 10)
    @Column(name = "State")
    private String state;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Vehicle")
    private String vehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ModelV")
    private String modelV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YearV")
    private int yearV;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Km")
    private int km;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PublicationDate")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Offer")
    private String offer;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Imag")
    private byte[] imag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private Collection<Fav> favCollection;
    @JoinColumn(name = "AdminID", referencedColumnName = "AdminID")
    @ManyToOne(optional = false)
    private Administrato adminID;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID")
    @ManyToOne(optional = false)
    private Registeredclient clientID;

    public Vehicleadvert() {
    }

    public Vehicleadvert(Integer code) {
        this.code = code;
    }

    public Vehicleadvert(Integer code, String email, String vehicle, String brand, String modelV, String color, int yearV, int km, Date publicationDate, int price, String offer, byte[] imag) {
        this.code = code;
        this.email = email;
        this.vehicle = vehicle;
        this.brand = brand;
        this.modelV = modelV;
        this.color = color;
        this.yearV = yearV;
        this.km = km;
        this.publicationDate = publicationDate;
        this.price = price;
        this.offer = offer;
        this.imag = imag;
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

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public byte[] getImag() {
        return imag;
    }

    public void setImag(byte[] imag) {
        this.imag = imag;
    }

    @XmlTransient
    public Collection<Fav> getFavCollection() {
        return favCollection;
    }

    public void setFavCollection(Collection<Fav> favCollection) {
        this.favCollection = favCollection;
    }

    public Administrato getAdminID() {
        return adminID;
    }

    public void setAdminID(Administrato adminID) {
        this.adminID = adminID;
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
        return "Datastore.Vehicleadvert[ code=" + code + " ]";
    }
    
}
