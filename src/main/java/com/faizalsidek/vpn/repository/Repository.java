package com.faizalsidek.vpn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * VpnUser: faizal
 * Date: 1/27/15
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
@NoRepositoryBean
public interface Repository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
