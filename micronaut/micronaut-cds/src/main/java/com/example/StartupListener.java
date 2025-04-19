package com.example;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import jakarta.inject.Singleton;

// Since micronaut does not have an exit command onRefresh like Spring boot we need an startup listener

@Singleton
@Requires(env = "cds")
public class StartupListener implements ApplicationEventListener<StartupEvent> {

    @Override
    public void onApplicationEvent(StartupEvent event) {
        // Your logic here
        System.out.println("Application context initialized. Performing tasks...");

        // Exit the application
        System.exit(0);
    }
}