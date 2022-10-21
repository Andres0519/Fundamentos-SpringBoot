package com.fundamentos.springboot.fundamentos.configuration;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithPropertiesImplements;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
@PropertySource("classpath:connection.properties")
public class GeneralConfiguration {

    @Value("A")
    private String nombre;

    @Value("B")
    private String apellido;

    @Value("C")
    private String random;

    @Value("${jdbc.url}")
    private String jdbc;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;



    @Bean
    public MyBeanWithProperties function(){

        return new MyBeanWithPropertiesImplements(nombre,apellido);

    }
    @Bean
    public DataSource dataSource(){

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(jdbc);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();

    }
}
