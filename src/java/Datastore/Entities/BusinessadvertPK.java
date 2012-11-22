/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author root
 */
@Embeddable
public class BusinessadvertPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ClientID")
    private int clientID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code")
    private int code;

    public BusinessadvertPK() {
    }

    public BusinessadvertPK(int clientID, int code) {
        this.clientID = clientID;
        this.code = code;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clientID;
        hash += (int) code;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusinessadvertPK)) {
            return false;
        }
        BusinessadvertPK other = (BusinessadvertPK) object;
        if (this.clientID != other.clientID) {
            return false;
        }
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datastore.BusinessadvertPK[ clientID=" + clientID + ", code=" + code + " ]";
    }
    
}
