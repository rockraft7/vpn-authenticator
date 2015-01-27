package com.faizalsidek.vpn.service;

import com.faizalsidek.vpn.entity.VpnAuth;
import com.faizalsidek.vpn.entity.VpnSession;
import com.faizalsidek.vpn.entity.VpnUser;
import com.faizalsidek.vpn.repository.VpnAuthRepository;
import com.faizalsidek.vpn.repository.VpnServiceRepository;
import com.faizalsidek.vpn.repository.VpnSessionRepository;
import com.faizalsidek.vpn.repository.VpnUserRepository;
import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private VpnUserRepository userRepository;

    @Autowired
    private VpnSessionRepository sessionRepository;

    @Autowired
    private VpnServiceRepository serviceRepository;

    @Autowired
    private VpnAuthRepository authRepository;

    @Transactional(readOnly = true)
    public Integer authenticate(String username, String password, String serviceId) {
        username = StringEscapeUtils.escapeHtml3(username);
        password = StringEscapeUtils.escapeHtml3(password);

        VpnUser vpnUser = userRepository.findByUsernameAndDisabled(username, false);
        if (vpnUser == null)
            return 1;
        List<VpnAuth> vpnAuths = authRepository.findByUser_Username(username);

        if (password.equals(vpnUser.getPassword())) {
            for (VpnAuth auth : vpnAuths) {
                if (auth.getId().equals(Integer.valueOf(serviceId)))
                    return 0;
            }
        } else {
            //TODO add login attempt
        }

        return 1;
    }

    @Transactional
    public Integer createSession(String username, String serviceId) {
        VpnUser vpnUser = userRepository.findByUsernameAndDisabled(username, false);
        if (vpnUser == null)
            return 1;

        List<VpnSession> activeSession = sessionRepository.findByUser_UsernameAndActive(username, true);
        if (activeSession.size() > 0) {
            for (VpnSession active : activeSession) {
                //TODO kick user elsewhere
                invalidateSession(username, String.valueOf(active.getService().getId()));
            }
        }

        VpnSession session = new VpnSession();
        session.setService(serviceRepository.findById(Integer.valueOf(serviceId)));
        session.setActive(true);
        session.setSessionStartTime(new Date());
        session.setUser(vpnUser);
        sessionRepository.save(session);
        return 0;
    }

    @Transactional
    public Integer invalidateSession(String username, String serviceId) {
        VpnSession active = sessionRepository.findByActiveAndService_IdAndUser_Username(true, Integer.valueOf(serviceId), username);
        if (active == null)
            return 1;

        active.setActive(false);
        active.setSessionDropTime(new Date());
        sessionRepository.save(active);

        return 0;
    }
}