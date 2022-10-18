package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentToImplement implements  ComponentDependancy{
    @Override
    public void saluduar() {
        System.out.println("Hola desde mi otro componente");
    }
}
