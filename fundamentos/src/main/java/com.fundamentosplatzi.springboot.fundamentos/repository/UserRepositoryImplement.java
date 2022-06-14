package com.fundamentosplatzi.springboot.fundamentos.repository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UserRepositoryImplement implements UserRepository{
    Log LOGGER = LogFactory.getLog(UserRepositoryImplement.class);
    @Override
    public void conexion_BD(String msj) {
        System.out.println(String.format("Hola estoy haciendo una conexión desde la capa de respository... Y la llamada es de %s",msj));
        LOGGER.info("Esto es información");
    }
}
