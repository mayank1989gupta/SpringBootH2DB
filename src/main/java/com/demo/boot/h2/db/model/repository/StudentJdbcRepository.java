/**
 * 
 */
package com.demo.boot.h2.db.model.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.boot.h2.db.model.Student;
import com.demo.boot.h2.db.model.repository.rowmapper.StudentRowMapper;

/**
 * @author MGupta
 *
 * Spring Boot Auto Configuration sees H2 in the classpath. </br>
 * It know that we want to connect to an in-memory database. </br>
 * Auto configures a datasource &, JdbcTemplate connecting to the datasource. </br>
 */

@Repository
public class StudentJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate; 

	/**
	 * Method to find the Object{Student} by the given ID.</br>
	 * 
	 * @param id
	 * @return
	 */
	public Student findById(long id) {
		return jdbcTemplate.queryForObject("select * from student where id = ?", new Object[] {id}, 
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	/**
	 * Method to find all the records.</br>
	 * 
	 * @return
	 */
	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}

	/**
	 * Method to delete a specific record.</br>
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from student where id = ?", id);
	}
	
	/**
	 * Method to create a new record.</br>
	 * 
	 * @param student
	 * @return
	 */
	public int insert(Student student) {
		return jdbcTemplate.update("insert into student (id, name, passport) values(?,  ?, ?)",
				student.getId(), 
				student.getName(), 
				student.getPassport());
	}
	
	/**
	 * Method update the given record.</br>
	 * 
	 * @param student
	 * @return
	 */
	public int update(Student student) {
		return jdbcTemplate.update("update student set name = ?, passport = ? where id = ?",
				student.getName(), 
				student.getPassport(), 
				student.getId());
	}
}
//End of File