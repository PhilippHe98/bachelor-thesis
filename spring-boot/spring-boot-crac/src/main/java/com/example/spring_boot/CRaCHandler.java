package com.example.spring_boot;

import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.Arrays;

@Component
public class CRaCHandler implements Resource {
    private final ConfigurableEnvironment env;
    private final ApplicationContext applicationContext;
    private final DataSource dataSource;

    public CRaCHandler(ConfigurableEnvironment env, ApplicationContext applicationContext, DataSource dataSource) {
        Core.getGlobalContext().register(this);
        this.env = env;
        this.applicationContext = applicationContext;
        this.dataSource = dataSource;
    }

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        env.setActiveProfiles("default");
        System.out.println("Current Profiles: " + Arrays.toString(applicationContext.getEnvironment().getActiveProfiles()));

        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();
    }
}
