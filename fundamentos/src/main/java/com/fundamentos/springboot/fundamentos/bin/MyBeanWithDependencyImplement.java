package com.fundamentos.springboot.fundamentos.bin;

import com.fundamentos.springboot.fundamentos.FundamentosApplication;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printDependency() {

        LOGGER.info("Hemos ingresado al metodo printDependency");
        int numero = 12;
        LOGGER.debug("El numero enviado como parametro es: " + numero);
        System.out.println(myOperation.suma(numero));
        System.out.println("Desde la clase de la dependencia y el bean :)");

    }
}
