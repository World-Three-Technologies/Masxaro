/*
 *  Copyright 2012 World Three Technologies, Inc. 
 *  All Rights Reserved.
 * 
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 3 of the License, or
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
 *  Or see <http://www.gnu.org/licenses/>.
 *  
 *  Written by Brian Shimkaveg <bws@masxaro.com>
 */
package com.masxaro.data.user.ejb;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "masxarouser", catalog = "UserDB", schema = "user_schema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Masxarouser.findAll", query = "SELECT m FROM Masxarouser m"),
    @NamedQuery(name = "Masxarouser.findByUserid", query = "SELECT m FROM Masxarouser m WHERE m.userid = :userid"),
    @NamedQuery(name = "Masxarouser.findByFirstname", query = "SELECT m FROM Masxarouser m WHERE m.firstname = :firstname"),
    @NamedQuery(name = "Masxarouser.findByLoginname", query = "SELECT m FROM Masxarouser m WHERE m.loginname = :loginname"),
    @NamedQuery(name = "Masxarouser.findByRecoveryemailaddress", query = "SELECT m FROM Masxarouser m WHERE m.recoveryemailaddress = :recoveryemailaddress"),
    @NamedQuery(name = "Masxarouser.findByAccountcreationdate", query = "SELECT m FROM Masxarouser m WHERE m.accountcreationdate = :accountcreationdate"),
    @NamedQuery(name = "Masxarouser.findByVerification", query = "SELECT m FROM Masxarouser m WHERE m.verification = :verification"),
    @NamedQuery(name = "Masxarouser.findByDeleted", query = "SELECT m FROM Masxarouser m WHERE m.deleted = :deleted"),
    @NamedQuery(name = "Masxarouser.findByProfilemodifieddate", query = "SELECT m FROM Masxarouser m WHERE m.profilemodifieddate = :profilemodifieddate"),
    @NamedQuery(name = "Masxarouser.findByPostalcode", query = "SELECT m FROM Masxarouser m WHERE m.postalcode = :postalcode"),
    @NamedQuery(name = "Masxarouser.findByDateofbirth", query = "SELECT m FROM Masxarouser m WHERE m.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Masxarouser.findByGender", query = "SELECT m FROM Masxarouser m WHERE m.gender = :gender"),
    @NamedQuery(name = "Masxarouser.findByUseralias", query = "SELECT m FROM Masxarouser m WHERE m.useralias = :useralias"),
    @NamedQuery(name = "Masxarouser.findByCodecontributor", query = "SELECT m FROM Masxarouser m WHERE m.codecontributor = :codecontributor")})
public class MasxaroUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid", nullable = false)
    private Long userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "firstname", nullable = false, length = 2147483647)
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "loginname", nullable = false, length = 2147483647)
    private String loginname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "recoveryemailaddress", nullable = false, length = 2147483647)
    private String recoveryemailaddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountcreationdate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date accountcreationdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "verification", nullable = false)
    private boolean verification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted", nullable = false)
    private boolean deleted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "profilemodifieddate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date profilemodifieddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postalcode", nullable = false)
    private int postalcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofbirth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "gender", nullable = false, length = 2147483647)
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "useralias", nullable = false, length = 2147483647)
    private String useralias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codecontributor", nullable = false)
    private boolean codecontributor;
    @ManyToMany(mappedBy = "masxarouserCollection")
    private Collection<DashboardWidget> dashboardwidgetCollection;
    @JoinColumn(name = "privacyoptionid", referencedColumnName = "privacyoptionid", nullable = false)
    @ManyToOne(optional = false)
    private PrivacyLevel privacyoptionid;
    @JoinColumn(name = "languagepreferenceid", referencedColumnName = "languagepreferenceid", nullable = false)
    @ManyToOne(optional = false)
    private LanguagePreference languagepreferenceid;
    @JoinColumn(name = "dashboardbackgroundid", referencedColumnName = "dashboardbackgroundid", nullable = false)
    @ManyToOne(optional = false)
    private DashboardBackgroundPreference dashboardbackgroundid;

    public MasxaroUser() {
    }

    public MasxaroUser(Long userid) {
        this.userid = userid;
    }

    public MasxaroUser(Long userid, String firstname, String loginname, String recoveryemailaddress, Date accountcreationdate, boolean verification, boolean deleted, Date profilemodifieddate, int postalcode, Date dateofbirth, String gender, String useralias, boolean codecontributor) {
        this.userid = userid;
        this.firstname = firstname;
        this.loginname = loginname;
        this.recoveryemailaddress = recoveryemailaddress;
        this.accountcreationdate = accountcreationdate;
        this.verification = verification;
        this.deleted = deleted;
        this.profilemodifieddate = profilemodifieddate;
        this.postalcode = postalcode;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.useralias = useralias;
        this.codecontributor = codecontributor;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getRecoveryemailaddress() {
        return recoveryemailaddress;
    }

    public void setRecoveryemailaddress(String recoveryemailaddress) {
        this.recoveryemailaddress = recoveryemailaddress;
    }

    public Date getAccountcreationdate() {
        return accountcreationdate;
    }

    public void setAccountcreationdate(Date accountcreationdate) {
        this.accountcreationdate = accountcreationdate;
    }

    public boolean getVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Date getProfilemodifieddate() {
        return profilemodifieddate;
    }

    public void setProfilemodifieddate(Date profilemodifieddate) {
        this.profilemodifieddate = profilemodifieddate;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUseralias() {
        return useralias;
    }

    public void setUseralias(String useralias) {
        this.useralias = useralias;
    }

    public boolean getCodecontributor() {
        return codecontributor;
    }

    public void setCodecontributor(boolean codecontributor) {
        this.codecontributor = codecontributor;
    }

    @XmlTransient
    public Collection<DashboardWidget> getDashboardwidgetCollection() {
        return dashboardwidgetCollection;
    }

    public void setDashboardwidgetCollection(Collection<DashboardWidget> dashboardwidgetCollection) {
        this.dashboardwidgetCollection = dashboardwidgetCollection;
    }

    public PrivacyLevel getPrivacyoptionid() {
        return privacyoptionid;
    }

    public void setPrivacyoptionid(PrivacyLevel privacyoptionid) {
        this.privacyoptionid = privacyoptionid;
    }

    public LanguagePreference getLanguagepreferenceid() {
        return languagepreferenceid;
    }

    public void setLanguagepreferenceid(LanguagePreference languagepreferenceid) {
        this.languagepreferenceid = languagepreferenceid;
    }

    public DashboardBackgroundPreference getDashboardbackgroundid() {
        return dashboardbackgroundid;
    }

    public void setDashboardbackgroundid(DashboardBackgroundPreference dashboardbackgroundid) {
        this.dashboardbackgroundid = dashboardbackgroundid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasxaroUser)) {
            return false;
        }
        MasxaroUser other = (MasxaroUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masxaro.user.ejb.Masxarouser[ userid=" + userid + " ]";
    }
    
}
