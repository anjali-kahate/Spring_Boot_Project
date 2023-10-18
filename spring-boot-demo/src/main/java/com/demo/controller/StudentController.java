package com.demo.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Student;
import com.demo.servise.StudentServise;

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	private StudentServise studentservise;
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createstd=studentservise.createStudent(student);
		System.out.println(student.toString());
		return new ResponseEntity<Student>(createstd, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getUserbyId(@PathVariable("id") long id) {
		Student std=studentservise.getStudentById(id);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllUser() {
		List<Student> ListAllStd=studentservise.getAllStudent();
		return new ResponseEntity<List<Student>>(ListAllStd, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStud(@PathVariable("id") long id, @RequestBody Student student) {
		student.setId(id);
		Student updatestd = studentservise.updateStudent(student);
		return new ResponseEntity<Student>(updatestd, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletestud(@PathVariable("id") long id) {
		studentservise.deleteStudent(id);
		return new ResponseEntity<String>("Student Successfully Deleted!", HttpStatus.OK);
	}
	
	
	
	
	

}
