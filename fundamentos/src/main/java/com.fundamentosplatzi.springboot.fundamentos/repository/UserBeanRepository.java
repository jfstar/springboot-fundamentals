package com.fundamentosplatzi.springboot.fundamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBeanRepository {
    void conexion_BD(String msj);
}
