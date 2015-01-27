package com.faizalsidek.vpn.repository;

import com.faizalsidek.vpn.entity.VpnService;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VpnServiceRepository extends Repository<VpnService, Integer> {
    VpnService findById(Integer id);
}
