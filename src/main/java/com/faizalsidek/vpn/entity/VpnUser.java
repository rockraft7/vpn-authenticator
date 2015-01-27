package com.faizalsidek.vpn.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * VpnUser: faizal
 * Date: 1/26/15
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "VPN_USER")
public class VpnUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_1")
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_DISABLED")
    private boolean disabled;

    @Column(name = "DISABLED_UNTIL")
    private Date disabledUntil;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Date getDisabledUntil() {
        return disabledUntil;
    }

    public void setDisabledUntil(Date disabledUntil) {
        this.disabledUntil = disabledUntil;
    }

    @Override
    public String toString() {
        return "VpnUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", disabled=" + disabled +
                ", disabledUntil=" + disabledUntil +
                '}';
    }
}
