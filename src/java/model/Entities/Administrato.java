/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "ADMINISTRATO", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrato.findAll", query = "SELECT a FROM Administrato a"),
    @NamedQuery(name = "Administrato.findByAdminID", query = "SELECT a FROM Administrato a WHERE a.adminID = :adminID"),
    @NamedQuery(name = "Administrato.findByUsername", query = "SELECT a FROM Administrato a WHERE a.username = :username"),
    @NamedQuery(name = "Administrato.findByPasswor", query = "SELECT a FROM Administrato a WHERE a.passwor = :passwor"),
    @NamedQuery(name = "Administrato.findByConfirmed", query = "SELECT a FROM Administrato a WHERE a.confirmed = :confirmed"),
    @NamedQuery(name = "Administrato.findByEmail", query = "SELECT a FROM Administrato a WHERE a.email = :email")})
public class Administrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdminID", nullable = false)
    private Integer adminID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Username", nullable = false, length = 20)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Passwor", nullable = false, length = 8)
    private String passwor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Confirmed", nullable = false)
    private int confirmed;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Email", nullable = false, length = 40)
    private String email;

    public Administrato() {
    }

    public Administrato(Integer adminID) {
        this.adminID = adminID;
    }

    public Administrato(Integer adminID, String username, String passwor, int confirmed, String email) {
        this.adminID = adminID;
        this.username = username;
        this.passwor = passwor;
        this.confirmed = confirmed;
        this.email = email;
    }

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswor() {
        return passwor;
    }

    public void setPasswor(String passwor) {
        this.passwor = passwor;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminID != null ? adminID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrato)) {
            return false;
        }
        Administrato other = (Administrato) object;
        if ((this.adminID == null && other.adminID != null) || (this.adminID != null && !this.adminID.equals(other.adminID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Entities.Administrato[ adminID=" + adminID + " ]";
    }
    
}
