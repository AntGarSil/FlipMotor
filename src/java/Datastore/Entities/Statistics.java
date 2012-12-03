/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datastore.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "STATISTICS", catalog = "flipmotor", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statistics.findAll", query = "SELECT s FROM Statistics s"),
    @NamedQuery(name = "Statistics.findByAdvertID", query = "SELECT s FROM Statistics s WHERE s.advertID = :advertID"),
    @NamedQuery(name = "Statistics.findByIncome", query = "SELECT s FROM Statistics s WHERE s.income = :income")})
public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdvertID", nullable = false)
    private Integer advertID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Income", nullable = false)
    private int income;

    public Statistics() {
    }

    public Statistics(Integer advertID) {
        this.advertID = advertID;
    }

    public Statistics(Integer advertID, int income) {
        this.advertID = advertID;
        this.income = income;
    }

    public Integer getAdvertID() {
        return advertID;
    }

    public void setAdvertID(Integer advertID) {
        this.advertID = advertID;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advertID != null ? advertID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statistics)) {
            return false;
        }
        Statistics other = (Statistics) object;
        if ((this.advertID == null && other.advertID != null) || (this.advertID != null && !this.advertID.equals(other.advertID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Datastore.Entities.Statistics[ advertID=" + advertID + " ]";
    }
    
}
