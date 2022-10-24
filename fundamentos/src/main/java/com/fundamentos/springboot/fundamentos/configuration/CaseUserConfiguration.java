package com.fundamentos.springboot.fundamentos.configuration;


import com.fundamentos.springboot.fundamentos.caseuser.GetUser;
import com.fundamentos.springboot.fundamentos.caseuser.GetUserImplement;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUserConfiguration {

    @Bean
    GetUser getUser(UserService userService){

        return new GetUserImplement(userService);

    }
}
