package biz.global77.service;

import java.util.List;

import biz.global77.exception.ResourceNotFoundException;
import biz.global77.model.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student getStudentById(Long id) throws ResourceNotFoundException;
	Student addStudent(Student student);
	Student updateStudentById(Long id, Student student);
	void deleteStudentById(Long id);

}
