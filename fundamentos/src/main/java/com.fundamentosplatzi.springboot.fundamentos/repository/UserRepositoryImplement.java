package com.fundamentosplatzi.springboot.fundamentos.repository;

public class UserRepositoryImplement implements UserRepository{
    @Override
    public void conexion_BD(String msj) {
        System.out.println(String.format("Hola estoy haciendo una conexión desde la capa de respository... Y la llamada es de %s",msj));
    }
}
