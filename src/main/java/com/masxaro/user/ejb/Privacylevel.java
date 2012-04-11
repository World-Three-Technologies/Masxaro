/*
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
@Table(name = "privacylevel", catalog = "UserDB", schema = "user_schema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privacylevel.findAll", query = "SELECT p FROM Privacylevel p"),
    @NamedQuery(name = "Privacylevel.findByPrivacyoptionid", query = "SELECT p FROM Privacylevel p WHERE p.privacyoptionid = :privacyoptionid"),
    @NamedQuery(name = "Privacylevel.findByPrivacylevelname", query = "SELECT p FROM Privacylevel p WHERE p.privacylevelname = :privacylevelname"),
    @NamedQuery(name = "Privacylevel.findByPrivacyleveldescription", query = "SELECT p FROM Privacylevel p WHERE p.privacyleveldescription = :privacyleveldescription")})
public class Privacylevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "privacyoptionid", nullable = false)
    private Integer privacyoptionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "privacylevelname", nullable = false, length = 2147483647)
    private String privacylevelname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "privacyleveldescription", nullable = false, length = 2147483647)
    private String privacyleveldescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privacyoptionid")
    private Collection<Masxarouser> masxarouserCollection;

    public Privacylevel() {
    }

    public Privacylevel(Integer privacyoptionid) {
        this.privacyoptionid = privacyoptionid;
    }

    public Privacylevel(Integer privacyoptionid, String privacylevelname, String privacyleveldescription) {
        this.privacyoptionid = privacyoptionid;
        this.privacylevelname = privacylevelname;
        this.privacyleveldescription = privacyleveldescription;
    }

    public Integer getPrivacyoptionid() {
        return privacyoptionid;
    }

    public void setPrivacyoptionid(Integer privacyoptionid) {
        this.privacyoptionid = privacyoptionid;
    }

    public String getPrivacylevelname() {
        return privacylevelname;
    }

    public void setPrivacylevelname(String privacylevelname) {
        this.privacylevelname = privacylevelname;
    }

    public String getPrivacyleveldescription() {
        return privacyleveldescription;
    }

    public void setPrivacyleveldescription(String privacyleveldescription) {
        this.privacyleveldescription = privacyleveldescription;
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
        hash += (privacyoptionid != null ? privacyoptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privacylevel)) {
            return false;
        }
        Privacylevel other = (Privacylevel) object;
        if ((this.privacyoptionid == null && other.privacyoptionid != null) || (this.privacyoptionid != null && !this.privacyoptionid.equals(other.privacyoptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masxaro.user.ejb.Privacylevel[ privacyoptionid=" + privacyoptionid + " ]";
    }
    
}
