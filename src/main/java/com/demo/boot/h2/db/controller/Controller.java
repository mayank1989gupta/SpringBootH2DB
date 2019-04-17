/**
 * 
 */
package com.demo.boot.h2.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.boot.h2.db.model.Student;
import com.demo.boot.h2.db.model.repository.StudentJdbcRepository;

/**
 * @author MGupta
 *
 */
@RestController
public class Controller {

	@Autowired
    StudentJdbcRepository repository;
	
	/**
	 * Fetch all the records in Student Repo.</br>
	 * 
	 * @return
	 */
	@GetMapping("/findAll")
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	/**
	 * API to create a new record.</br>
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping("/create") 
	public HttpStatus create(@RequestBody Student student) {
		repository.insert(student);
		return HttpStatus.CREATED;
	}
	
	/**
	 * Fetch all the records in Student Repo.</br>
	 * 
	 * @return
	 */
	@GetMapping("/findByID/{studentID}")
	public Student findByID(@PathVariable(value="studentID") Long studentID) {
		return repository.findById(studentID);
	}
	
	/**
	 * API to update an existing record.</br>
	 * 
	 * @param student
	 * @return
	 */
	@PutMapping("/update") 
	public HttpStatus update(@RequestBody Student student) {
		repository.update(student);
		return HttpStatus.OK;
	}
	
	/**
	 * API to delete the record for the given student ID.</br>
	 * 
	 * @param studentID
	 * @return
	 */
	@DeleteMapping("/delete/{studentID}") 
	public HttpStatus delete(@PathVariable(value="studentID") Long studentID) {
		repository.deleteById(studentID);
		return HttpStatus.OK;
	}
}
//End of file
