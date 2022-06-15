package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserBeanRepository;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserBeanRepositoryImplement;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
    public UserBeanRepository UserBeanRepository(){ return  new UserBeanRepositoryImplement();  }

    @Bean
    public UserBean UserWithDependecy(UserBeanRepository userBeanRepository){
        return new UserBean(userBeanRepository);
    }


}
