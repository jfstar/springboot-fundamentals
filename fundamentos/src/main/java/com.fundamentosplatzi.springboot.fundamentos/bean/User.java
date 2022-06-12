package com.fundamentosplatzi.springboot.fundamentos.bean;

import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;

public class User implements UserImplement{

    UserRepository userRepository;

    public User(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert() {
        System.out.printf("Estoy insertando desde mi Bean");
        String msj = "mi nuevo Bean";
        userRepository.conexion_BD(msj);
    }

    @Override
    public void update() {
        System.out.printf("Estoy actualizando desde mi Bean");
    }

    @Override
    public void delete() {
        System.out.printf("Estoy borrando desde mi Bean");
    }


}