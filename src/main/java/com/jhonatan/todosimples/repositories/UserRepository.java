package com.jhonatan.todosimples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhonatan.todosimples.models.User;

/**
 * REPOSITORY SERVE PARA PEGAR OS METODOS DO JPA
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}