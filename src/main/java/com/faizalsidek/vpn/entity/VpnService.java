package com.faizalsidek.vpn.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 5:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "VPN_SERVICE")
public class VpnService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN_1")
    @Column(name = "SERVICE_ID")
    private Integer id;

    @Column(name = "SERVICE_URL")
    private String url;

    @Column(name = "SERVICE_PROTOCOL")
    private String protocol;

    @Column(name = "SERVICE_IP")
    private String ip;

    @Column(name = "SERVICE_PORT")
    private Integer port;

    @Column(name = "IS_ACTIVE")
    private boolean active;

    @Column(name = "UP_TIME")
    private Date upTime;

    @Column(name = "DOWN_TIME")
    private Date downTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    @Override
    public String toString() {
        return "VpnService{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", protocol='" + protocol + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
