package com.vinesh.example.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Student {
	@Id
	private String id;

	@NotBlank(message = "name cannot be empty")
	private String name;
}
