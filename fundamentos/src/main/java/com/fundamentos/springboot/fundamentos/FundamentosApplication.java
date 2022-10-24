package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bin.*;
import com.fundamentos.springboot.fundamentos.component.ComponentDependancy;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependancy componentDependancy;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;

	private UserService userService;

	//Contructor de la clase
	public FundamentosApplication(@Qualifier("componentToImplement") ComponentDependancy componentDependancy,
								  MyBean myBean , MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,
								  UserRepository userRepository, UserService userService){

		this.componentDependancy = componentDependancy;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;


	}

	//Metodo para iniciar el programa
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);

	}

	//mostar idependencias
	@Override
	public void run(String... args) throws Exception {

		//ejemplosAnteriores();
		guardarUsuarios();
		obtenerInformacionJpql();
		guardarUsuarios();

	}

	private void ejemplosAnteriores(){

		componentDependancy.saluduar();
		myBean.print();
		myBeanWithDependency.printDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getApellido() + " - " + userPojo.getNombre());
		System.out.println(userPojo.getCorreo() + " - " + userPojo.getContraseña());
		System.out.println("Edad: " + userPojo.getEdad());
		LOGGER.error("Esto es un error del aplicativo");


	}

	private void guardarUsuarios(){

		User user1 = new User("Andres","abc@gmail.com", LocalDate.of(2022,10,21));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Carlos", "marisol@domain.com", LocalDate.of(2022, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2022, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2022, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2022, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2022, 4, 10));

		List<User> lista = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9);
		lista.stream().forEach(userRepository::save);
	}

	private void obtenerInformacionJpql(){

		LOGGER.info("El usuario con el correo" + userRepository.findByUserEmail("abc@gmail.com")
				.orElseThrow(()->new RuntimeException("No se encontro el user")) );

		userRepository.findBySort("Car", Sort.by("id").descending()).stream()
				.forEach(user -> LOGGER.info("Usuario con un nuevo metodo " + user));

		userRepository.findByNombre("Karen").stream()
				.forEach(user -> LOGGER.info("Usuario buscado por el nombre en especifico " + user));

		userRepository.findByNombreLike("%Carlos%").stream()
				.forEach(user -> LOGGER.info("Usuario buscado por el nombre que comiencen con C" + user));

	}

	private void guardarErrorTransaccioes(){

		User user1 = new User("Andres","abc@gmail.com", LocalDate.of(2022,10,21));
		User user2 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Carlos", "marisol@domain.com", LocalDate.of(2022, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));

		List<User> tests = Arrays.asList(user1,user2,user3,user4,user5);
		userService.saveTrasanctional(tests);

		userService.obtenerUsuarios().stream()
				.forEach(user -> LOGGER.info("Este es el usuario: " + user));
	}
}
