package com.faizalsidek.vpn.repository;

import com.faizalsidek.vpn.entity.VpnUser;

/**
 * Created with IntelliJ IDEA.
 * VpnUser: faizal
 * Date: 1/27/15
 * Time: 1:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VpnUserRepository extends Repository<VpnUser, Integer> {
    VpnUser findByUsername(String username);

    VpnUser findByUsernameAndDisabled(String username, boolean disabled);
}
