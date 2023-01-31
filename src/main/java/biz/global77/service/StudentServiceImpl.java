package biz.global77.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.global77.exception.ResourceNotFoundException;
import biz.global77.model.Student;
import biz.global77.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) throws ResourceNotFoundException {
		Optional<Student> student = studentRepo.findById(id);
		if (!student.isPresent()) {
			throw new ResourceNotFoundException("Student not found");
		}
		return student.get();
	}

	@Override
	public Student addStudent(Student student) {
		studentRepo.save(student);
		return student;
	}

	@Override
	public Student updateStudentById(Long id, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub

	}

}
