package com.fundamentos.springboot.fundamentos.repository;

import com.fundamentos.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("Select x From User x WHERE x.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("Select x From User x WHERE x.nombre like ?1%")
    List<User> findBySort(String nombre, Sort sort);

    List<User> findByNombre(String nombre);

    List<User> findByNombreLike(String nombre);
}


