package com.example;

import io.micronaut.crac.OrderedResource;
import jakarta.inject.Singleton;
import org.crac.Context;
import org.crac.Resource;
import org.crac.management.CRaCMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class RestoreLogger implements OrderedResource {
    private static final Logger LOG = LoggerFactory.getLogger(RestoreLogger.class);

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
    }

    // https://crac.github.io/openjdk-builds/javadoc/api/jdk.management/jdk/crac/management/CRaCMXBean.html for uptime
    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        LOG.info("Application restored from CRaC checkpoint. Startup time since restore: {} ms", CRaCMXBean.getCRaCMXBean().getUptimeSinceRestore());
    }
}
