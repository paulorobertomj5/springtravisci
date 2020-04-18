package br.com.spring.restspringboot.api.db;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceApplication {
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    @Primary
    @Bean(name="springDS")
    public DataSource spring() {

        return this.createPostgreSQLDataSource();
    }

    private DataSource createPostgreSQLDataSource() {

        DataSource dataSource = DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/test?useTimeZone=true&serverTimezone=UTC&useSSL=false")
                .driverClassName(DRIVER_CLASS)
                .username("root")
                .password("admin")
                .build();
        return dataSource;
    }
}
