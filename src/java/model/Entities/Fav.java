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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "FAV", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fav.findAll", query = "SELECT f FROM Fav f"),
    @NamedQuery(name = "Fav.findById", query = "SELECT f FROM Fav f WHERE f.id = :id")})
public class Fav implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "Code", referencedColumnName = "Code", nullable = false)
    @ManyToOne(optional = false)
    private Vehicleadvert code;
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID", nullable = false)
    @ManyToOne(optional = false)
    private Registeredclient clientID;

    public Fav() {
    }

    public Fav(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehicleadvert getCode() {
        return code;
    }

    public void setCode(Vehicleadvert code) {
        this.code = code;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fav)) {
            return false;
        }
        Fav other = (Fav) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flipmotor.Entities.Fav[ id=" + id + " ]";
    }
    
}
