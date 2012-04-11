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
