package com.fundamentosplatzi.springboot.fundamentos.component;

import com.fundamentosplatzi.springboot.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {
    Log LOGGER = LogFactory.getLog(ComponentImplement.class);


    @Override
    public void saludar() {
        LOGGER.info("Captura de Debug desde ComponentImplement");
        System.out.println("Hola mundo desde mi componente...");
        try {
            int valor = 10/0;
        }catch(Exception Ex)
        {
            LOGGER.error("Error capturado "+Ex.getMessage());
        }
    }
}
