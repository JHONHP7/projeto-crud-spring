package com.jhonatan.todosimples.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_TASK")
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Task implements Serializable {

	private static final long serialVersionUID = 6119093903627164945L;

	@Id
	@Column(name = "TASK_ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRIPTION", length = 255, nullable = false)
	@NotBlank
	@Size(min = 1, max = 255)
	private String description;

	/**
	 * VARIAS TAREFAS SÃO DE UM USUARIO
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, updatable = false)
	private User user;
}
