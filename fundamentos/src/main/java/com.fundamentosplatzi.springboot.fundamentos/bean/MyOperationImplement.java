package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyOperationImplement implements MyOperation{

    Log LOGGER = LogFactory.getLog(MyOperationImplement.class);
    @Override
    public int suma(int number) {
        LOGGER.error("Esto es un error desde MyOperationImplement");
        return number++;
    }
}
