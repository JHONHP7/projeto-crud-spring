package com.jhonatan.todosimples.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jhonatan.todosimples.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	/**
	 * OPTIONAL SERVE PARA NÃO DAR PROBLEMA DE NULO SE NÃO EXISTIR, ELE COLOCA QUE
	 * ESTÁ VAZIO E NÃO NULO
	 */
	Optional<Task> findById(Long id);

	/**
	 * findByUser_Id COMO SE FOSSE SELECT RETORNANDO A TASK PELO ID DO USER
	 * 
	 * @param id
	 * @return
	 */
	List<Task> findByUser_Id(Long id);

	/**
	 * FAZ UMA QUERY SLQ
	 * 
	 * @param id
	 * @return
	 */
	@Query(value = "SELECT T FROM Task WHERE t.user.id = :id")
	List<Task> findByUserId(@Param("Id") Long id);
}
