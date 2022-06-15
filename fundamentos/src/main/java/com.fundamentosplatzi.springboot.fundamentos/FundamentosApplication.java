package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDepedency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.UserBean;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDepedency myBeanWithDepedency;

	private UserBean myUserBean;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency
			, MyBean myBean
	 		, MyBeanWithDepedency myBeanWithDepedency
			, UserBean myUserBean
			, MyBeanWithProperties myBeanWithProperties
			, UserPojo userPojo
		    , UserRepository userRepository
	) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDepedency = myBeanWithDepedency;
		this.myUserBean = myUserBean;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//otrasClases();
		registroBD();
		queryJPQE();
	}

	public void queryJPQE()
	{
		/*LOGGER.info("findByUserEmail User: \t"+
				userRepository.findByUserEmail("jfcs@gmail.com")
				.orElseThrow( () -> new RuntimeException("No se encontró el usuario")));
		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("findAndSort User:\t " + user));


		userRepository.findByName("user")
				.stream()
				.forEach(user -> LOGGER.info("findByName User:\t " + user));

		userRepository.findByNameLike("%user%")
				.stream()
				.forEach(user -> LOGGER.info("findByNameLike User:\t " + user));

		LOGGER.info("findByNameAndEmail Usuario: "+ userRepository.findByNameAndEmail("Maria", "maria@gmail.com")
						.orElseThrow( () -> new RuntimeException("findByNameAndEmail usuario no encontrado")));

		userRepository.findByNameOrEmail("user", "jfcs@gmail.com")
				.stream()
				.forEach(user -> LOGGER.info("findByNameOrEmail User:\t " + user));*/

		userRepository.findBybirthdateBetween(LocalDate.of(2020,01,01), LocalDate.of(2022,12,31))
				.stream()
				.forEach(user -> LOGGER.info("findByBirthDateBetween User: "+user) );

		userRepository.findByEmailContainsOrderByEmailAsc("@gmail")
				.stream()
				.forEach(email -> LOGGER.info("findByEmailContainsOrderByEmailAsc Email:\t " + email));

		userRepository.findByNameLikeOrderByNameAsc("%JFCS%")
				.stream()
				.forEach(user -> LOGGER.info("findByNameLikeOrderByAsc User:\t " + user));

		userRepository.findByNameContainsOrderByIdDesc("user")
				.stream()
				.forEach(user -> LOGGER.info("findByNameContainsOrderByIdDesc User:\t " + user));

		List<String> nombres = Arrays.asList("JFCS", "Juan", "Miguel", "Ana");
		userRepository.findByNameInOrderByNameAsc(nombres)
				.stream()
				.forEach(user -> LOGGER.info("findByNameInOrderByNameAsc User:\t " + user));

		List<String> emails = Arrays.asList("pe@gmail.com", "ana@gmail.com", "miguel@gmail.com");
		userRepository.findByEmailNotInOrderByIdDesc(emails)
			.stream()
			.forEach(user -> LOGGER.info("findByEmailNotInOrderByIdDesc Usuario: " + user));

	}

	public void registroBD()
	{
		User user1 = new User("JFCS", "jfcs@gmail.com", LocalDate.of(2021, 01,15));
		User user2 = new User("Juan", "juan@gmail.com", LocalDate.of(2021, 01,15));
		User user3 = new User("Miguel", "miguel@gmail.com", LocalDate.of(2021, 01,15));
		User user4 = new User("Ana", "ana@gmail.com", LocalDate.of(2021, 01,15));
		User user5 = new User("Maria", "maria@gmail.com", LocalDate.of(2021, 01,15));
		User user6 = new User("user", "pe@gmail.com", LocalDate.of(2021, 01,15));
		User user7 = new User("user1", "pe@gmail.com", LocalDate.of(2021, 01,15));
		User user8 = new User("user2", "pe@gmail.com", LocalDate.of(2021, 01,15));
		User user9 = new User("user3", "ramon@gmail.com", LocalDate.of(2021, 01,15));
		User user10 = new User("user4", "kenia@gmail.com", LocalDate.of(2021, 01,15));

		//userRepository.save(user1);
		//list.forEach(userRepository::save);
		List<User> NuevosUsuarios = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10);
		NuevosUsuarios.stream()
				.forEach(userRepository::save);
		//userRepository.saveAll(NuevosUsuarios);

		System.out.println("Nuevos Usuarios Almacenados");
		NuevosUsuarios.stream().forEach(user -> LOGGER.info("Usuario Almacenado: "+user) );
	}

	public void otrasClases()
	{
		System.out.println("***********  componentDependency ***********");
		componentDependency.saludar();
		System.out.println("¡¡¡¡¡¡¡¡¡¡¡  myBean ¡¡¡¡¡¡¡¡¡¡¡");
		myBean.print();
		System.out.println("#############  myBeanWithDepedency #############");
		myBeanWithDepedency.printWithDependency();
		System.out.println("++++++++++++  MyUser ++++++++++++");
		myUserBean.insert();
		myUserBean.update();
		myUserBean.delete();
		System.out.println(myBeanWithProperties.function());
		System.out.println( String.format("*** UserPojo *** %1$s Email: %2$s %1$s Password: %3$s %1$s Age: %4$s ", "\n", userPojo.getEmail(),userPojo.getPassword(),+userPojo.getAge()));
		LOGGER.error("Esto es un error directamente desde el run");
		LOGGER.info("Esto es información directamente desde el run");
		try {
			//Generación de error
			int value = 10/0;
		}catch (Exception ex)
		{
			LOGGER.error("Error generado desde run.. "+ ex.getMessage());
		}
	}
}
