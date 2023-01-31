package biz.global77.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.global77.model.ResponseModel;
import biz.global77.model.Student;
import biz.global77.service.StudentServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return ResponseEntity.ok().body(students);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> addStudent(@RequestBody Student student) {
		Student newStudent = studentService.addStudent(student);
		System.out.println(newStudent);
		return ResponseEntity.ok().body(new ResponseModel(201, "New student has been added", null, newStudent));
	}

}
