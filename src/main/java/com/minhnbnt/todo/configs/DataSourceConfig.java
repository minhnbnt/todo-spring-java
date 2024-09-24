package com.minhnbnt.todo.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${datasource.driver-class-name}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(url)
                .build();
    }
}
