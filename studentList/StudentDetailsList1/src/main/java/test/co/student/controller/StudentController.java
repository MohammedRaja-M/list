package test.co.student.controller;

import java.util.List;


import java.util.Optional;

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

import test.co.student.model.Student;
import test.co.student.service.StudentService;



@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	@Autowired(required = false)
	private StudentService studentservice;

	    @PostMapping
	    public String saveStudent(@RequestBody Student student) {
	        Optional<Student> _student = studentservice.create(student);
	        if(_student.isPresent()){
	            return "The student data has been saved successfully!";
	        }else{
	            return "Oops..! Student data already exist in records";
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
	      Optional<Student> student = studentservice.retrieveOne(id);  
	      if (student.isPresent()) {
	        return new ResponseEntity<>(student.get(), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	    }    

	    @GetMapping
	    public List<Student> getALLStudents() {
	      return studentservice.retrieve();
	    }

	    @PutMapping
	    public String updateStudent(@RequestBody Student student) {
	        Optional<Student> _student = studentservice.update(student);
	        if(_student.isEmpty()){
	            return "The Student data does not exist in records!";
	        }else{
	            return "The Student data has been updated successfully!";
	        }
	    }

	    @DeleteMapping ("/{id}")
	    public String deleteStudentById(@PathVariable int id) {
	      return  studentservice.delete(id);   
	    } 
}
