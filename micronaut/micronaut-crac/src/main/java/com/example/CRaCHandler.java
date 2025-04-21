package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.micronaut.crac.OrderedResource;
import jakarta.inject.Singleton;
import org.crac.Context;
import org.crac.Resource;
import org.flywaydb.core.Flyway;

@Singleton
public class CRaCHandler implements OrderedResource {

    @Override
    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
        System.out.println("HALLO VOR DEM CHECKPOINT");
    }

    @Override
    public void afterRestore(Context<? extends Resource> context) throws Exception {
        System.out.println("HALLO NACH DEM CHECKPOINT");

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:postgresql://postgres:5432/postgres");
        hikariConfig.setUsername("postgres");
        hikariConfig.setPassword("postgres");

        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://postgres:5432/postgres","postgres","postgres")
                .load();
        flyway.migrate();
    }
}