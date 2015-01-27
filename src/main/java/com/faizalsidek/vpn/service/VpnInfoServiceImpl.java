package com.faizalsidek.vpn.service;

import com.faizalsidek.vpn.entity.VpnAuth;
import com.faizalsidek.vpn.entity.VpnService;
import com.faizalsidek.vpn.entity.VpnSession;
import com.faizalsidek.vpn.entity.VpnUser;
import com.faizalsidek.vpn.repository.VpnAuthRepository;
import com.faizalsidek.vpn.repository.VpnServiceRepository;
import com.faizalsidek.vpn.repository.VpnSessionRepository;
import com.faizalsidek.vpn.repository.VpnUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: faizal
 * Date: 1/27/15
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class VpnInfoServiceImpl implements VpnInfoService {
    private static final Logger logger = LoggerFactory.getLogger(VpnInfoService.class);

    @Autowired
    private VpnUserRepository userRepository;

    @Autowired
    private VpnSessionRepository sessionRepository;

    @Autowired
    private VpnServiceRepository serviceRepository;

    @Autowired
    private VpnAuthRepository authRepository;

    @Transactional(readOnly = true)
    public VpnUser searchUser(String username) {
        VpnUser user = userRepository.findByUsername(username);
        if (user == null)
            return new VpnUser();
        return user;
    }

    @Transactional(readOnly = true)
    public List<VpnSession> listActiveSession() {
        List<VpnSession> sessions = sessionRepository.findByActive(true);

        return sessions;
    }

    @Transactional(readOnly = true)
    public List<VpnService> searchService(String serviceUrl, String serviceProtocol) {
        List<VpnService> vpnServices = new ArrayList<VpnService>();

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("url", serviceUrl);
        param.put("protocol", serviceProtocol);
        Specification<VpnService> spec = getSpecificationEquals(param);
        vpnServices.addAll(serviceRepository.findAll(spec));

        return vpnServices;
    }

    @Transactional(readOnly = true)
    public List<VpnService> listServices() {
        List<VpnService> services = new ArrayList<VpnService>();

        services.addAll(serviceRepository.findAll());

        return services;
    }

    @Transactional
    public Integer addUser(VpnUser vpnUser) {
        if (userRepository.findByUsername(vpnUser.getUsername()) != null)
            return 1;

        try {
            userRepository.save(vpnUser);
            return 0;
        } catch (Exception e) {
            logger.error("something happen. " + e.getMessage());
            return 1;
        }
    }

    @Transactional
    public Integer assignAuth(String username, List<VpnService> vpnServices) {
        if (vpnServices.size() == 0)
            return 1;

        VpnUser user = userRepository.findByUsernameAndDisabled(username, false);
        if (user == null)
            return 1;

        for (VpnService vpnService : vpnServices) {
            if (serviceRepository.findById(vpnService.getId()) == null)
                continue;
            VpnAuth auth = new VpnAuth();
            auth.setService(serviceRepository.findById(vpnService.getId()));
            auth.setUser(user);
            authRepository.save(auth);
        }

        return 0;
    }

    public Integer disableUser(String username, List<VpnService> vpnServices, String duration) {
        return 0;
    }

    public Integer enableUser(String username, List<VpnService> vpnServices, String duration) {
        return 0;
    }

    private <T> Specification<T> getSpecificationEquals(final Map<String,Object> specs) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> entity, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Predicate predicate = null;

                for (String field : specs.keySet()) {
                    predicate = (predicate == null) ? cb.equal(entity.get(field), specs.get(field)) :
                            cb.and(predicate, cb.equal(entity.get(field), specs.get(field)));
                }

                return predicate;
            }
        };
    }

    private String getLikePattern(final String searchTerm) {
        StringBuilder pattern = new StringBuilder();
        pattern.append("%");
        pattern.append(searchTerm.toLowerCase());
        pattern.append("%");
        return pattern.toString();
    }
}
