package com.fundamentos.springboot.fundamentos.configuration;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithPropertiesImplements;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {

    @Value("${value.nombre}")
    private String nombre;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){

        return new MyBeanWithPropertiesImplements(nombre,apellido);

    }
}
