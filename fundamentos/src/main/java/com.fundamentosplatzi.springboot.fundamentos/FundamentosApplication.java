package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDepedency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.User;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanWithDepedency myBeanWithDepedency;

	private User MyUser;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency
			,MyBean myBean
	 		,MyBeanWithDepedency myBeanWithDepedency
			,User myUser
			,MyBeanWithProperties myBeanWithProperties
			,UserPojo userPojo
	) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDepedency = myBeanWithDepedency;
		this.MyUser = myUser;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}


	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***********  componentDependency ***********");
		componentDependency.saludar();
		System.out.println("¡¡¡¡¡¡¡¡¡¡¡  myBean ¡¡¡¡¡¡¡¡¡¡¡");
		myBean.print();
		System.out.println("#############  myBeanWithDepedency #############");
		myBeanWithDepedency.printWithDependency();
		System.out.println("++++++++++++  MyUser ++++++++++++");
		MyUser.insert();
		MyUser.update();
		MyUser.delete();
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
