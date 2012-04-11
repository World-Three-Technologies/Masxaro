/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masxaro.user.ejb;

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
public class Masxarouser implements Serializable {
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
    private Collection<Dashboardwidget> dashboardwidgetCollection;
    @JoinColumn(name = "privacyoptionid", referencedColumnName = "privacyoptionid", nullable = false)
    @ManyToOne(optional = false)
    private Privacylevel privacyoptionid;
    @JoinColumn(name = "languagepreferenceid", referencedColumnName = "languagepreferenceid", nullable = false)
    @ManyToOne(optional = false)
    private Languagepreference languagepreferenceid;
    @JoinColumn(name = "dashboardbackgroundid", referencedColumnName = "dashboardbackgroundid", nullable = false)
    @ManyToOne(optional = false)
    private Dashboardbackgroundpreference dashboardbackgroundid;

    public Masxarouser() {
    }

    public Masxarouser(Long userid) {
        this.userid = userid;
    }

    public Masxarouser(Long userid, String firstname, String loginname, String recoveryemailaddress, Date accountcreationdate, boolean verification, boolean deleted, Date profilemodifieddate, int postalcode, Date dateofbirth, String gender, String useralias, boolean codecontributor) {
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
    public Collection<Dashboardwidget> getDashboardwidgetCollection() {
        return dashboardwidgetCollection;
    }

    public void setDashboardwidgetCollection(Collection<Dashboardwidget> dashboardwidgetCollection) {
        this.dashboardwidgetCollection = dashboardwidgetCollection;
    }

    public Privacylevel getPrivacyoptionid() {
        return privacyoptionid;
    }

    public void setPrivacyoptionid(Privacylevel privacyoptionid) {
        this.privacyoptionid = privacyoptionid;
    }

    public Languagepreference getLanguagepreferenceid() {
        return languagepreferenceid;
    }

    public void setLanguagepreferenceid(Languagepreference languagepreferenceid) {
        this.languagepreferenceid = languagepreferenceid;
    }

    public Dashboardbackgroundpreference getDashboardbackgroundid() {
        return dashboardbackgroundid;
    }

    public void setDashboardbackgroundid(Dashboardbackgroundpreference dashboardbackgroundid) {
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
        if (!(object instanceof Masxarouser)) {
            return false;
        }
        Masxarouser other = (Masxarouser) object;
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
