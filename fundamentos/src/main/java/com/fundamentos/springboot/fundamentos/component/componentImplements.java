package com.fundamentos.springboot.fundamentos.component;
import org.springframework.stereotype.Component;

@Component
public class componentImplements  implements ComponentDependancy{

    @Override
    public void saluduar() {

        System.out.println("Hola mundo");
    }
}
