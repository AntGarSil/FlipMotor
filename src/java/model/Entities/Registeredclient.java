/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "REGISTEREDCLIENT", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registeredclient.findAll", query = "SELECT r FROM Registeredclient r"),
    @NamedQuery(name = "Registeredclient.findByClientID", query = "SELECT r FROM Registeredclient r WHERE r.clientID = :clientID"),
    @NamedQuery(name = "Registeredclient.findByNif", query = "SELECT r FROM Registeredclient r WHERE r.nif = :nif"),
    @NamedQuery(name = "Registeredclient.findByPhone", query = "SELECT r FROM Registeredclient r WHERE r.phone = :phone"),
    @NamedQuery(name = "Registeredclient.findByEmail", query = "SELECT r FROM Registeredclient r WHERE r.email = :email"),
    @NamedQuery(name = "Registeredclient.findByNam", query = "SELECT r FROM Registeredclient r WHERE r.nam = :nam"),
    @NamedQuery(name = "Registeredclient.findBySurname", query = "SELECT r FROM Registeredclient r WHERE r.surname = :surname"),
    @NamedQuery(name = "Registeredclient.findByPasswor", query = "SELECT r FROM Registeredclient r WHERE r.passwor = :passwor"),
    @NamedQuery(name = "Registeredclient.findByNationality", query = "SELECT r FROM Registeredclient r WHERE r.nationality = :nationality"),
    @NamedQuery(name = "Registeredclient.findByPc", query = "SELECT r FROM Registeredclient r WHERE r.pc = :pc"),
    @NamedQuery(name = "Registeredclient.findByCity", query = "SELECT r FROM Registeredclient r WHERE r.city = :city"),
    @NamedQuery(name = "Registeredclient.findByProvince", query = "SELECT r FROM Registeredclient r WHERE r.province = :province"),
    @NamedQuery(name = "Registeredclient.findByStreet", query = "SELECT r FROM Registeredclient r WHERE r.street = :street"),
    @NamedQuery(name = "Registeredclient.findByNumbe", query = "SELECT r FROM Registeredclient r WHERE r.numbe = :numbe"),
    @NamedQuery(name = "Registeredclient.findByFlat", query = "SELECT r FROM Registeredclient r WHERE r.flat = :flat"),
    @NamedQuery(name = "Registeredclient.findByLeter", query = "SELECT r FROM Registeredclient r WHERE r.leter = :leter"),
    @NamedQuery(name = "Registeredclient.findByConfirmed", query = "SELECT r FROM Registeredclient r WHERE r.confirmed = :confirmed")})
public class Registeredclient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClientID", nullable = false)
    private Integer clientID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "NIF", nullable = false, length = 9)
    private String nif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Phone", nullable = false)
    private int phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nam", nullable = false, length = 20)
    private String nam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Surname", nullable = false, length = 20)
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Passwor", nullable = false, length = 8)
    private String passwor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Nationality", nullable = false, length = 12)
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PC", nullable = false)
    private int pc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "City", nullable = false, length = 25)
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Province", nullable = false, length = 20)
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Street", nullable = false, length = 20)
    private String street;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numbe", nullable = false)
    private int numbe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Flat", nullable = false)
    private int flat;
    @Column(name = "Leter")
    private Character leter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Confirmed", nullable = false)
    private int confirmed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<Conciliation> conciliationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<Fav> favCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<Vehicleadvert> vehicleadvertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<Businessadvert> businessadvertCollection;

    public Registeredclient() {
    }

    public Registeredclient(Integer clientID) {
        this.clientID = clientID;
    }

    public Registeredclient(Integer clientID, String nif, int phone, String email, String nam, String surname, String passwor, String nationality, int pc, String city, String province, String street, int numbe, int flat, int confirmed) {
        this.clientID = clientID;
        this.nif = nif;
        this.phone = phone;
        this.email = email;
        this.nam = nam;
        this.surname = surname;
        this.passwor = passwor;
        this.nationality = nationality;
        this.pc = pc;
        this.city = city;
        this.province = province;
        this.street = street;
        this.numbe = numbe;
        this.flat = flat;
        this.confirmed = confirmed;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumbe() {
        return numbe;
    }

    public void setNumbe(int numbe) {
        this.numbe = numbe;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public Character getLeter() {
        return leter;
    }

    public void setLeter(Character leter) {
        this.leter = leter;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
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
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registeredclient)) {
            return false;
        }
        Registeredclient other = (Registeredclient) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flipmotor.Entities.Registeredclient[ clientID=" + clientID + " ]";
    }
    
}
