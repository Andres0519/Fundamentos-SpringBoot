package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bin.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean beanOperation(){

        return new MyBeanImplement2();

    }

    @Bean
    public MyOperation operation(){

        return new MyOperationImplement();

    }

    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

}
