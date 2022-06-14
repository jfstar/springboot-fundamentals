package com.fundamentosplatzi.springboot.fundamentos.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    Log LOGGER = LogFactory.getLog(ComponentTwoImplement.class);
    @Override
    public void saludar() {
        LOGGER.error("Error desde ComponentTwoImplement");
        System.out.println("Hola desde mi segundo componente...");
        LOGGER.debug("Debug desde ComponentTwoImplement");
        try {
            int valor = 10/0;
        }catch(Exception Ex)
        {
            LOGGER.error("Error capturado "+Ex.getMessage());
        }
    }
}
