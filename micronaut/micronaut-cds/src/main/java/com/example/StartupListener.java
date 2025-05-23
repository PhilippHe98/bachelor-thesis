package com.example;

import io.micronaut.context.annotation.Value;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

@Singleton
public class StartupListener implements ApplicationEventListener<ServerStartupEvent> {

    @Value("${micronaut.environments:}")
    String environment;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        if (environment.contains("cds")) {
            System.out.println("CDS environment active. Exiting...");
            System.exit(0);
        }
    }
}