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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bshimkaveg
 */
@Embeddable
public class MasxaroUserPK implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "userid", nullable = false)
    private long userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serverid", nullable = false)
    private long serverid;

    public MasxaroUserPK() {
    }

    public MasxaroUserPK(long userid, long serverid) {
        this.userid = userid;
        this.serverid = serverid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getServerid() {
        return serverid;
    }

    public void setServerid(long serverid) {
        this.serverid = serverid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) serverid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasxaroUserPK)) {
            return false;
        }
        MasxaroUserPK other = (MasxaroUserPK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.serverid != other.serverid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.masxaro.user.ejb.MasxarouserPK[ userid=" + userid + ", serverid=" + serverid + " ]";
    }
    
}
