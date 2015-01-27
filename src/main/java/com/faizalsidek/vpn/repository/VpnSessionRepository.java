package com.faizalsidek.vpn.repository;

import com.faizalsidek.vpn.entity.VpnSession;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VpnSessionRepository extends Repository<VpnSession, Integer> {
    List<VpnSession> findByUser_UsernameAndActive(String username, boolean active);

    List<VpnSession> findByActiveAndService_IdAndUser_Username(boolean active, Integer serviceId, String username);

    List<VpnSession> findByActive(boolean active);
}
