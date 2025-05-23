package com.example.spring_boot;

import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.crac.management.CRaCMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RestoreLogger implements Resource {
    private static final Logger LOG = LoggerFactory.getLogger(RestoreLogger.class);


    public RestoreLogger() {
        Core.getGlobalContext().register(this);
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) {
        
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) {
        LOG.info("Application restored from CRaC checkpoint. Startup time since restore: {} ms", CRaCMXBean.getCRaCMXBean().getUptimeSinceRestore());
    }
}