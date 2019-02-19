/**
 * 
 */
package com.demo.boot.h2.db;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.boot.h2.db.model.Student;
import com.demo.boot.h2.db.model.repository.StudentJdbcRepository;

/**
 * @author MGupta
 *
 */
@SpringBootApplication
public class SpringBootH2DBApplication implements CommandLineRunner {

	private static final Logger LOGGER = Logger.getLogger(SpringBootH2DBApplication.class.getName());
	private static final String SEPARATOR = "***********************************************************************";
	
	@Autowired
    StudentJdbcRepository repository;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DBApplication.class, args);
	}

	//Overriding run() from CommandLineRunner.
	@Override
	public void run(String ...args) throws Exception {
        //Logging for specific ID
		LOGGER.log(Level.INFO, () -> "Student id 10001 -> " + repository.findById(10001L));
        
		//Logging all
		LOGGER.log(Level.INFO, SEPARATOR);
		LOGGER.log(Level.INFO, () -> "H2 DB Data -> " + repository.findAll());
		
		LOGGER.log(Level.INFO, SEPARATOR);
		LOGGER.log(Level.INFO, () -> "Insert -> " + repository.insert(new Student(10003L, "John", "A1234657")));
		
		LOGGER.log(Level.INFO, SEPARATOR);
		LOGGER.log(Level.INFO, () -> "Update 10001 -> " + repository.update(new Student(10001L, "Test-Updated", "Test-Updated")));
		
		LOGGER.log(Level.INFO, SEPARATOR);
		LOGGER.log(Level.INFO, () -> "Deleting record with ID -> " + 10002L);
		repository.deleteById(10002L);
		
		LOGGER.log(Level.INFO, SEPARATOR);
		LOGGER.log(Level.INFO, () -> "Records in DB -> " + repository.findAll());
    }
}
//End of File