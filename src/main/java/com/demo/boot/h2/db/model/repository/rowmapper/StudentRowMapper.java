/**
 * 
 */
package com.demo.boot.h2.db.model.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.boot.h2.db.model.Student;

/**
 * @author MGupta
 * 
 * Class to map the data fetched from DB.
 */
public class StudentRowMapper implements RowMapper<Student>{

	@Override
	/**
	 * Mapper method for the fetched data.</br>
	 */
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
        student.setId(rs.getLong("id"));//ID
        student.setName(rs.getString("name"));//name
        student.setPassport(rs.getString("passport"));//passport
        
        return student;//result
	}

}
