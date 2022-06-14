package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class User implements UserImplement{
    Log LOGGER = LogFactory.getLog(User.class);
    UserRepository userRepository;

    public User(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert() {
        System.out.printf("Estoy insertando desde mi Bean");
        String msj = "mi nuevo Bean";
        LOGGER.error("Esto es un error desde el insert ");
        userRepository.conexion_BD(msj);
    }

    @Override
    public void update() {
        System.out.printf("Estoy actualizando desde mi Bean");
        LOGGER.info("Esto es información desde el update ");
    }

    @Override
    public void delete() {
        System.out.printf("Estoy borrando desde mi Bean");
    }


}
