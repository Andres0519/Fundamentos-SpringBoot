package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bin.MyBean;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bin.MyBeanWithDependencyImplement;
import com.fundamentos.springboot.fundamentos.bin.MyOperationImplement;
import com.fundamentos.springboot.fundamentos.component.ComponentDependancy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependancy componentDependancy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;



	//Contructor de la clase
	public FundamentosApplication(@Qualifier("componentToImplement") ComponentDependancy componentDependancy,
								  MyBean myBean , MyBeanWithDependency myBeanWithDependency){

		this.componentDependancy = componentDependancy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;


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

	}
}
