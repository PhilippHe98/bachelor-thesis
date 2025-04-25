package com.example;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.configuration.ConfigUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class StartupListener {
    public void onStart(@Observes StartupEvent ev) {

        if (ConfigUtils.isProfileActive("cds")) {
            System.out.println("Profile cds is active. Shutting down application.");
            Quarkus.asyncExit();
        }
    }
}