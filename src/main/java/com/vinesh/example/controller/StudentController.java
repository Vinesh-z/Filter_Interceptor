package com.vinesh.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinesh.example.model.Student;
import com.vinesh.example.repository.StudentRepository;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		System.out.println("Add Student Controller Called");
		return ResponseEntity.ok().body(studentRepository.save(student));
	}

	@GetMapping
	public ResponseEntity<?> getStudentById(@RequestParam String id) {
		System.out.println("Get Student By Id Controller Called");
		return ResponseEntity.ok().body(studentRepository.findById(id));
	}

}
