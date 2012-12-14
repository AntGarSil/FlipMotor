/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Flipmotor.Entities;

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
    @NamedQuery(name = "Statistics.findByStatID", query = "SELECT s FROM Statistics s WHERE s.statID = :statID"),
    @NamedQuery(name = "Statistics.findByAdvertID", query = "SELECT s FROM Statistics s WHERE s.advertID = :advertID"),
    @NamedQuery(name = "Statistics.findByIncome", query = "SELECT s FROM Statistics s WHERE s.income = :income"),
    @NamedQuery(name = "Statistics.findByTyp", query = "SELECT s FROM Statistics s WHERE s.typ = :typ")})
public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatID", nullable = false)
    private Integer statID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AdvertID", nullable = false)
    private int advertID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Income", nullable = false)
    private int income;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Typ", nullable = false)
    private int typ;

    public Statistics() {
    }

    public Statistics(Integer statID) {
        this.statID = statID;
    }

    public Statistics(Integer statID, int advertID, int income, int typ) {
        this.statID = statID;
        this.advertID = advertID;
        this.income = income;
        this.typ = typ;
    }

    public Integer getStatID() {
        return statID;
    }

    public void setStatID(Integer statID) {
        this.statID = statID;
    }

    public int getAdvertID() {
        return advertID;
    }

    public void setAdvertID(int advertID) {
        this.advertID = advertID;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statID != null ? statID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statistics)) {
            return false;
        }
        Statistics other = (Statistics) object;
        if ((this.statID == null && other.statID != null) || (this.statID != null && !this.statID.equals(other.statID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flipmotor.Entities.Statistics[ statID=" + statID + " ]";
    }
    
}
