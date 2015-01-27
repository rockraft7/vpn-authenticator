package com.faizalsidek.vpn.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "VPN_SESSION")
public class VpnSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_1")
    @Column(name = "SESSION_ID")
    private Integer id;

    @ManyToOne(targetEntity = VpnUser.class)
    @JoinColumn(name = "VPN_USER_ID", referencedColumnName = "USER_ID")
    private VpnUser user;

    @ManyToOne(targetEntity = VpnService.class)
    @JoinColumn(name = "VPN_SERVICE_ID", referencedColumnName = "SERVICE_ID")
    private VpnService service;

    @Column(name = "SESSION_START")
    private Date sessionStartTime;

    @Column(name = "SESSION_DROP")
    private Date sessionDropTime;

    @Column(name = "IS_ACTIVE")
    private boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VpnUser getUser() {
        return user;
    }

    public void setUser(VpnUser user) {
        this.user = user;
    }

    public VpnService getService() {
        return service;
    }

    public void setService(VpnService service) {
        this.service = service;
    }

    public Date getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(Date sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public Date getSessionDropTime() {
        return sessionDropTime;
    }

    public void setSessionDropTime(Date sessionDropTime) {
        this.sessionDropTime = sessionDropTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
