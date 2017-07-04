package com.winston.stone.lottery.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author winston
 *         2017/6/17/017 20:34
 */
@Configuration
public class DataSourceConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.stone.hikari.");
    }

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName(propertyResolver.getProperty("pool-name"));

        hikariConfig.setJdbcUrl(propertyResolver.getProperty("url"));
        hikariConfig.setUsername(propertyResolver.getProperty("username"));
        hikariConfig.setPassword(propertyResolver.getProperty("password"));

        hikariConfig.addDataSourceProperty("cachePrepStmts", propertyResolver.getProperty("cache-prep-stmts"));
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", propertyResolver.getProperty("prep-stmt-cache-size"));
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", propertyResolver.getProperty("prep-stmt-cache-sql-limit"));

        hikariConfig.setMinimumIdle(propertyResolver.getProperty("minimum-idle", Integer.class));
        hikariConfig.setMaximumPoolSize(propertyResolver.getProperty("maximum-pool-size", Integer.class));
        hikariConfig.setIdleTimeout(propertyResolver.getProperty("idle-timeout", Long.class));
        hikariConfig.setConnectionTimeout(propertyResolver.getProperty("connection-timeout", Long.class));
        hikariConfig.setMaxLifetime(propertyResolver.getProperty("max-lifetime", Long.class));

        return new HikariDataSource(hikariConfig);
    }

}
