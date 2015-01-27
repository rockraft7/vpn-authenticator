package com.faizalsidek.vpn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * VpnUser: faizal
 * Date: 10/19/14
 * Time: 3:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class EntitiesFactoryBean implements FactoryBean<String[]>, InitializingBean, ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(EntitiesFactoryBean.class);

    private List<String> packages = new ArrayList<String>();

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public String[] getObject() throws Exception {
        for (String str : packages)
            logger.trace("Scan package: " + str);
        return packages.toArray(new String[0]);
    }

    @Override
    public Class<?> getObjectType() {
        return String[].class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.trace("Initializing scanning of entities packages.");
        Map<String, EntitiesContributor> beans = context.getBeansOfType(EntitiesContributor.class);
        for (EntitiesContributor c : beans.values()) {
            addPackages(c.getPackages());
        }
        context = null;
    }

    public void addPackage(String packageName) {
        if (packageName != null && packageName.trim().length() > 0) {
            if (logger.isTraceEnabled()) {
                logger.trace("Adding package: " + packageName);
            }
            packages.add(packageName);
        }
    }

    public void addPackages(String[] packageNames) {
        if (packageNames != null) {
            for (String p : packageNames) {
                addPackage(p);
            }
        }
    }
}
