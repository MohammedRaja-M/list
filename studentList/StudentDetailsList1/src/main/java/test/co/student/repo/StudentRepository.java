package test.co.student.repo;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import test.co.student.model.Student;


@Qualifier("Student")
@Repository
public interface StudentRepository extends JpaRepository<Student , Integer>{
	
}
