package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepositoryImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean bean_operation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation bean_sum(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDepedency beanOperationWithDependency(MyOperation myOperation){

        return new MyBeanWithDepedencyImplement(myOperation);
    }

    @Bean
    public UserRepository userRepository(){ return  new UserRepositoryImplement();  }

    @Bean
    public User UserWithDependecy(UserRepository userRepository){
        return new User(userRepository);
    }
}
