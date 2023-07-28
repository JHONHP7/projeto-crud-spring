package com.jhonatan.todosimples.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class User implements Serializable {

	private static final long serialVersionUID = -8389997931957336034L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "USER_NAME")
	private String name;

	@Column(name = "USER_PASSWORD")
	private String password;

}
