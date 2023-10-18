package com.demo.servise;

import java.util.List;

import com.demo.entity.Student;


public interface StudentServise {

	Student createStudent(Student student);
	
	Student getStudentById(long id);
	
	List<Student> getAllStudent();
	
	Student updateStudent(Student student);
	
	void deleteStudent(long id);
}
