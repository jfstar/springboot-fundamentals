package com.fundamentosplatzi.springboot.fundamentos.repository;


import com.fundamentosplatzi.springboot.fundamentos.dto.UserDTO;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1% ")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);

    List<User> findByNameLike(String name);

    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);

    List<User> findBybirthdateBetween(LocalDate begin, LocalDate end);

    List<User> findByEmailContainsOrderByEmailAsc(String email);

    List<User> findByNameLikeOrderByNameAsc(String name);

    List<User> findByNameContainsOrderByIdDesc(String name);


    List<User> findByNameInOrderByNameAsc(List<String> name);

    List<User> findByEmailNotInOrderByIdDesc(List<String> email);

    @Query("SELECT new com.fundamentosplatzi.springboot.fundamentos.dto.UserDTO(u.id, u.name, u.birthdate) "
            +" FROM  User u "
            +" WHERE u.birthdate=:parametroFecha"
            +" AND   u.email=:parametroEmail")
    Optional<UserDTO> getAllByBirthDateAndEmail(@Param("parametroFecha") LocalDate BirthDate,
                                                @Param("parametroEmail") String email);
}
