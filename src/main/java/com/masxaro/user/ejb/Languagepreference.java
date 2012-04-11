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
@Table(name = "languagepreference", catalog = "UserDB", schema = "user_schema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languagepreference.findAll", query = "SELECT l FROM Languagepreference l"),
    @NamedQuery(name = "Languagepreference.findByLanguagepreferenceid", query = "SELECT l FROM Languagepreference l WHERE l.languagepreferenceid = :languagepreferenceid"),
    @NamedQuery(name = "Languagepreference.findByValue", query = "SELECT l FROM Languagepreference l WHERE l.value = :value")})
public class Languagepreference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "languagepreferenceid", nullable = false)
    private Integer languagepreferenceid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "value", nullable = false, length = 2147483647)
    private String value;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languagepreferenceid")
    private Collection<Masxarouser> masxarouserCollection;

    public Languagepreference() {
    }

    public Languagepreference(Integer languagepreferenceid) {
        this.languagepreferenceid = languagepreferenceid;
    }

    public Languagepreference(Integer languagepreferenceid, String value) {
        this.languagepreferenceid = languagepreferenceid;
        this.value = value;
    }

    public Integer getLanguagepreferenceid() {
        return languagepreferenceid;
    }

    public void setLanguagepreferenceid(Integer languagepreferenceid) {
        this.languagepreferenceid = languagepreferenceid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        hash += (languagepreferenceid != null ? languagepreferenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languagepreference)) {
            return false;
        }
        Languagepreference other = (Languagepreference) object;
        if ((this.languagepreferenceid == null && other.languagepreferenceid != null) || (this.languagepreferenceid != null && !this.languagepreferenceid.equals(other.languagepreferenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masxaro.user.ejb.Languagepreference[ languagepreferenceid=" + languagepreferenceid + " ]";
    }
    
}
