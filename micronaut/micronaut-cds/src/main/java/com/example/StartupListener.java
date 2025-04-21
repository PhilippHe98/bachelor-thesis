package com.example;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;

// Since micronaut does not have an exit command onRefresh like Spring boot we need a startup listener
// StartupEvent vs ServerStartupEvent?
@Singleton
@Requires(env = "cds")
public class StartupListener implements ApplicationEventListener<ServerStartupEvent> {

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        System.out.println("Application context initialized. Exiting...");
        System.exit(0);
    }
}