package com.jhonatan.todosimples.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.jhonatan.todosimples.repositories.CreateUser;
import com.jhonatan.todosimples.repositories.UpdateUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "TB_USER")
public class User implements Serializable {

	private static final long serialVersionUID = -8389997931957336034L;

	@Id
	@Column(name = "USER_ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * @NotBlank NÃO PODE SER NULA OU VAZIA
	 * @Size DEFINIR O TAMANHO DO DADO
	 */
	@NotBlank(groups = CreateUser.class)
	@Size(groups = CreateUser.class, min = 2, max = 100)
	@Column(name = "USER_NAME", length = 100, nullable = false, unique = true)
	private String name;

	/**
	 * Access.WRITE_ONLY PARA NÃO RETORNAR A SENHA
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(groups = { CreateUser.class, UpdateUser.class })
	@Size(groups = { CreateUser.class, UpdateUser.class }, min = 8, max = 60)
	@Column(name = "USER_PASSWORD", length = 60, nullable = false)
	private String password;

	// private List<Task> tasks = new ArrayList<>();

}
