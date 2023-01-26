package test.co.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.co.student.model.Student;
import test.co.student.repo.StudentRepository;



@Service
public class StudentService {
	@Autowired(required = false)
	 private StudentRepository studentrepository;

	    public Optional<Student> create(Student student){
	        if (studentrepository.existsById(student.getId())){
	            return Optional.empty();
	        }else{
	            return Optional.of(studentrepository.save(student));
	        }
	    }

	    public List<Student> retrieve(){
	        return studentrepository.findAll();
	    }

	    public Optional<Student> retrieveOne(int studentid){
	        return studentrepository.findById(studentid);
	    }
	    
	    public Optional<Student> update(Student student){
	        if (studentrepository.existsById(student.getId())){
	            return Optional.of(studentrepository.save(student));
	        }else{
	            return Optional.empty();
	        }
	    }   

	    public String delete(int studentid){
	        if (studentrepository.existsById(studentid)){
	        	studentrepository.deleteById(studentid);
	            return studentid + " deleted successfully!";
	        }else{
	            return "The StudentData data does not exist in records!";
	        }
	        
	    }
}
