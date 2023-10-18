package com.demo.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;


@Service
public class StudentServiseImpl implements StudentServise {
	
	@Autowired
	private StudentRepository studentrepo;
	
	public Student createStudent(Student student) {
		
		return studentrepo.save(student);
	}

	public Student getStudentById(long id) {
		
		 Optional<Student> optional=studentrepo.findById(id);
		return optional.get();
	}

	public List<Student> getAllStudent() {
	
		return (List) studentrepo.findAll();
	}

	public Student updateStudent(Student student) {
		
		Student existingStud= studentrepo.findById(student.getId()).get();
		existingStud.setName(student.getName());
		existingStud.setAge(student.getAge());
		existingStud.setCorse(student.getCorse());
		existingStud.setAddress(student.getAddress());
		existingStud.setPhone_no(student.getPhone_no());
		
		Student updatestud= studentrepo.save(existingStud);
	
		return updatestud;
	}

	public void deleteStudent(long id) {
		
		studentrepo.deleteById(id);
	}

}
