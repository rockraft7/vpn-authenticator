package com.faizalsidek.vpn.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "VPN_AUTH_LIST")
public class VpnAuth implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_1")
    @Column(name = "AUTH_LIST_ID")
    private Integer id;

    @ManyToOne(targetEntity = VpnService.class)
    @JoinColumn(name = "SERVICE_ID", referencedColumnName = "SERVICE_ID")
    private VpnService service;

    @ManyToOne(targetEntity = VpnUser.class)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private VpnUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VpnService getService() {
        return service;
    }

    public void setService(VpnService service) {
        this.service = service;
    }

    public VpnUser getUser() {
        return user;
    }

    public void setUser(VpnUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VpnAuth{" +
                "id=" + id +
                ", service=" + service +
                ", user=" + user +
                '}';
    }
}
