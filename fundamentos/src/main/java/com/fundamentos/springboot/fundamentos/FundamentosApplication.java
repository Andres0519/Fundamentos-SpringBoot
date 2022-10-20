package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bin.*;
import com.fundamentos.springboot.fundamentos.component.ComponentDependancy;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependancy componentDependancy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	//Contructor de la clase
	public FundamentosApplication(@Qualifier("componentToImplement") ComponentDependancy componentDependancy,
								  MyBean myBean , MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){

		this.componentDependancy = componentDependancy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;


	}

	//Metodo para iniciar el programa
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);

	}

	//mostar idependencias
	@Override
	public void run(String... args) throws Exception {

		componentDependancy.saluduar();
		myBean.print();
		myBeanWithDependency.printDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getApellido() + " - " + userPojo.getNombre());
		System.out.println(userPojo.getCorreo() + " - " + userPojo.getContraseña());
		System.out.println("Edad: " + userPojo.getEdad());
		LOGGER.error("Esto es un error del aplicativo");


	}
}
