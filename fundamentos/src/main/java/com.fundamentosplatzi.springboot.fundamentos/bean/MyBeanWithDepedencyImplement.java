package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDepedencyImplement implements  MyBeanWithDepedency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDepedencyImplement.class);
    MyOperation myOperation;

    public MyBeanWithDepedencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Esto es información desde MyBeanWithDepedencyImplement");
        var number = 7;
        LOGGER.debug("El número enviado como parametro a la dependencia operation es: " + number);
        System.out.println(myOperation.suma(number));
        System.out.println("Hola desde printWithDependency, la implementación  de un Bean con dependencia.");
    }
}
