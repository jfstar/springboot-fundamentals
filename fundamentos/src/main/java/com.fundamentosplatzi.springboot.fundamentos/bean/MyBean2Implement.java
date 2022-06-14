package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBean2Implement implements MyBean {
    Log LOGGER = LogFactory.getLog(MyBean2Implement.class);
    @Override
    public void print() {
        LOGGER.info("información desde MyBean2Implement");
        System.out.println("Hola desde mi emplementación propia del Bean 2 propia fuego María...");
    }
}
