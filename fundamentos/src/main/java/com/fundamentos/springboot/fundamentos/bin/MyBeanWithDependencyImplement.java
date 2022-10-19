package com.fundamentos.springboot.fundamentos.bin;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printDependency() {

        System.out.println(myOperation.suma(12));
        System.out.println("Desde la clase de la dependencia y el bean :)");
    }
}
