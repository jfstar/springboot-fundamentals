package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanImplement implements MyBean {
    Log LOGGER = LogFactory.getLog(MyBeanImplement.class);

    @Override
    public void print() {
        LOGGER.info("Esto es información desde MyBeanImplement");
        System.out.println("Hola desde mi emplementación propia del Bean");

    }

    public void print2() {
        LOGGER.info("Esto es información desde MyBeanImplement print2");
        LOGGER.debug("Esto es debug desde MyBeanImplement print2");
    }
}
