package com.fundamentosplatzi.springboot.fundamentos.dto;


import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String name;
    private LocalDate birthdate;

    public UserDTO(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
