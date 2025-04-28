package com.example;

import io.agroal.api.AgroalDataSource;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.crac.Context;
import org.crac.Resource;
import org.crac.Core;
import org.flywaydb.core.Flyway;

@ApplicationScoped
public class DatabaseConnectionManager implements Resource {
    @Inject
    Flyway flyway;

    public void eagerInit(@Observes StartupEvent event) {
    }

    public DatabaseConnectionManager() {
        // Register this resource with CRaC
        Core.getGlobalContext().register(this);
    }


    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("HELLO FROM BEFORE THE CHECKPOINT");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        System.out.println("HELLO FROM AFTER THE CHECKPOINT");
        flyway.migrate();
        System.out.println(flyway.info().current().getVersion().toString());
    }
}