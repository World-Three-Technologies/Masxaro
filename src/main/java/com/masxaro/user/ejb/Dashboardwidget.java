/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masxaro.user.ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bshimkaveg
 */
@Entity
@Table(name = "dashboardwidget", catalog = "UserDB", schema = "user_schema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dashboardwidget.findAll", query = "SELECT d FROM Dashboardwidget d"),
    @NamedQuery(name = "Dashboardwidget.findByDashboardwidgetid", query = "SELECT d FROM Dashboardwidget d WHERE d.dashboardwidgetid = :dashboardwidgetid"),
    @NamedQuery(name = "Dashboardwidget.findByDashboardwidgettitle", query = "SELECT d FROM Dashboardwidget d WHERE d.dashboardwidgettitle = :dashboardwidgettitle"),
    @NamedQuery(name = "Dashboardwidget.findByDashboardwidgetresourcename", query = "SELECT d FROM Dashboardwidget d WHERE d.dashboardwidgetresourcename = :dashboardwidgetresourcename")})
public class Dashboardwidget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dashboardwidgetid", nullable = false)
    private Integer dashboardwidgetid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dashboardwidgettitle", nullable = false, length = 2147483647)
    private String dashboardwidgettitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dashboardwidgetresourcename", nullable = false, length = 2147483647)
    private String dashboardwidgetresourcename;
    @JoinTable(name = "userdashboardwidget", joinColumns = {
        @JoinColumn(name = "dashboardwidgetid", referencedColumnName = "dashboardwidgetid", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)})
    @ManyToMany
    private Collection<Masxarouser> masxarouserCollection;

    public Dashboardwidget() {
    }

    public Dashboardwidget(Integer dashboardwidgetid) {
        this.dashboardwidgetid = dashboardwidgetid;
    }

    public Dashboardwidget(Integer dashboardwidgetid, String dashboardwidgettitle, String dashboardwidgetresourcename) {
        this.dashboardwidgetid = dashboardwidgetid;
        this.dashboardwidgettitle = dashboardwidgettitle;
        this.dashboardwidgetresourcename = dashboardwidgetresourcename;
    }

    public Integer getDashboardwidgetid() {
        return dashboardwidgetid;
    }

    public void setDashboardwidgetid(Integer dashboardwidgetid) {
        this.dashboardwidgetid = dashboardwidgetid;
    }

    public String getDashboardwidgettitle() {
        return dashboardwidgettitle;
    }

    public void setDashboardwidgettitle(String dashboardwidgettitle) {
        this.dashboardwidgettitle = dashboardwidgettitle;
    }

    public String getDashboardwidgetresourcename() {
        return dashboardwidgetresourcename;
    }

    public void setDashboardwidgetresourcename(String dashboardwidgetresourcename) {
        this.dashboardwidgetresourcename = dashboardwidgetresourcename;
    }

    @XmlTransient
    public Collection<Masxarouser> getMasxarouserCollection() {
        return masxarouserCollection;
    }

    public void setMasxarouserCollection(Collection<Masxarouser> masxarouserCollection) {
        this.masxarouserCollection = masxarouserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dashboardwidgetid != null ? dashboardwidgetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dashboardwidget)) {
            return false;
        }
        Dashboardwidget other = (Dashboardwidget) object;
        if ((this.dashboardwidgetid == null && other.dashboardwidgetid != null) || (this.dashboardwidgetid != null && !this.dashboardwidgetid.equals(other.dashboardwidgetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masxaro.user.ejb.Dashboardwidget[ dashboardwidgetid=" + dashboardwidgetid + " ]";
    }
    
}
