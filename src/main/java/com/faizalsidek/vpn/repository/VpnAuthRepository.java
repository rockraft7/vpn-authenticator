package com.faizalsidek.vpn.repository;

import com.faizalsidek.vpn.entity.VpnAuth;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VpnAuthRepository extends Repository<VpnAuth, Integer> {
    List<VpnAuth> findByUser_Username(String username);
}
