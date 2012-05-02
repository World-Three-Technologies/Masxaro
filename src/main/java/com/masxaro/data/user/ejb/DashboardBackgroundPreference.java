/**
 *  Copyright 2012 World Three Technologies, Inc. 
 *  All Rights Reserved.
 * 
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *  Written by Brian Shimkaveg <bws@masxaro.com>
 */

package com.masxaro.data.user.ejb;

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
@Table(name = "dashboardbackgroundpreference", catalog = "UserDB", schema = "user_schema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dashboardbackgroundpreference.findAll", query = "SELECT d FROM Dashboardbackgroundpreference d"),
    @NamedQuery(name = "Dashboardbackgroundpreference.findByDashboardbackgroundid", query = "SELECT d FROM Dashboardbackgroundpreference d WHERE d.dashboardbackgroundid = :dashboardbackgroundid"),
    @NamedQuery(name = "Dashboardbackgroundpreference.findByDashboardbackgroundtitle", query = "SELECT d FROM Dashboardbackgroundpreference d WHERE d.dashboardbackgroundtitle = :dashboardbackgroundtitle"),
    @NamedQuery(name = "Dashboardbackgroundpreference.findByDashboardbackgroundresourcename", query = "SELECT d FROM Dashboardbackgroundpreference d WHERE d.dashboardbackgroundresourcename = :dashboardbackgroundresourcename")})
public class DashboardBackgroundPreference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dashboardbackgroundid", nullable = false)
    private Integer dashboardbackgroundid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dashboardbackgroundtitle", nullable = false, length = 2147483647)
    private String dashboardbackgroundtitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dashboardbackgroundresourcename", nullable = false, length = 2147483647)
    private String dashboardbackgroundresourcename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dashboardbackgroundid")
    private Collection<MasxaroUser> MasxaroUserCollection;

    public DashboardBackgroundPreference() {
    }

    public DashboardBackgroundPreference(Integer dashboardbackgroundid) {
        this.dashboardbackgroundid = dashboardbackgroundid;
    }

    public DashboardBackgroundPreference(Integer dashboardbackgroundid, String dashboardbackgroundtitle, String dashboardbackgroundresourcename) {
        this.dashboardbackgroundid = dashboardbackgroundid;
        this.dashboardbackgroundtitle = dashboardbackgroundtitle;
        this.dashboardbackgroundresourcename = dashboardbackgroundresourcename;
    }

    public Integer getDashboardbackgroundid() {
        return dashboardbackgroundid;
    }

    public void setDashboardbackgroundid(Integer dashboardbackgroundid) {
        this.dashboardbackgroundid = dashboardbackgroundid;
    }

    public String getDashboardbackgroundtitle() {
        return dashboardbackgroundtitle;
    }

    public void setDashboardbackgroundtitle(String dashboardbackgroundtitle) {
        this.dashboardbackgroundtitle = dashboardbackgroundtitle;
    }

    public String getDashboardbackgroundresourcename() {
        return dashboardbackgroundresourcename;
    }

    public void setDashboardbackgroundresourcename(String dashboardbackgroundresourcename) {
        this.dashboardbackgroundresourcename = dashboardbackgroundresourcename;
    }

    @XmlTransient
    public Collection<MasxaroUser> getMasxaroUserCollection() {
        return getMasxaroUserCollection();
    }

    public void setMasxaroUserCollection(Collection<MasxaroUser> MasxaroUserCollection) {
        this.MasxaroUserCollection = MasxaroUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dashboardbackgroundid != null ? dashboardbackgroundid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DashboardBackgroundPreference)) {
            return false;
        }
        DashboardBackgroundPreference other = (DashboardBackgroundPreference) object;
        if ((this.dashboardbackgroundid == null && other.dashboardbackgroundid != null) || (this.dashboardbackgroundid != null && !this.dashboardbackgroundid.equals(other.dashboardbackgroundid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masxaro.user.ejb.DashboardBackgroundPreference[ dashboardbackgroundid=" + dashboardbackgroundid + " ]";
    }
    
}
