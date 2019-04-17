/**
 * 
 */
package com.demo.boot.h2.db.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.boot.h2.db.SpringBootH2DbApplicationTests;
import com.demo.boot.h2.db.model.Student;

/**
 * @author MGupta
 *
 */
public class ControllerTest extends SpringBootH2DbApplicationTests {

	@Before
	@Override
	public void setUp() {
		super.setUp();
	}

	//Test method to test - findAll
	@Test
	public void findAllTest() throws Exception {
		String uri = "/findAll";//Reest uri
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		MockHttpServletResponse result = mvcResult.getResponse();
		//Assert to check for status
		int status = result.getStatus();
		assertEquals(200, status);

		//Assert to check length of response
		String data = result.getContentAsString();
		@SuppressWarnings("unchecked")
		List<Student> students = super.mapFromJson(data, List.class);
		assertEquals(2, students.size());
	}

	//Test method to test - create
	@Test
	public void createTest() throws Exception {
		String uri = "/create";//Rest uri
		Student student = new Student(10006L, "From Junit", "Junit");

		String inputJson = super.mapToJson(student);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	//Test method to test - create
	@Test
	public void findByIDTest() throws Exception {
		String uriFindById = "/findByID/10007";//Rest uri
		String uriCreate = "/create";//Rest uri
		//Create
		Student student = new Student(10007L, "From Junit -- 007", "Junit -- 07");

		String inputJson = super.mapToJson(student);
		mvc.perform(MockMvcRequestBuilders.post(uriCreate)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		//Find By ID
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uriFindById)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		MockHttpServletResponse result = mvcResult.getResponse();
		int status = result.getStatus();
		assertEquals(200, status);

		Student data = super.mapFromJson(result.getContentAsString(),
				Student.class); 
		assertEquals("From Junit -- 007", data.getName());
		
		//Delete
		String uriDelete = "/delete/10007";//Rest uri
		mvc
		.perform(MockMvcRequestBuilders.delete(uriDelete))
		.andReturn();

	}

	//Test method to test - update
	@Test
	public void updateTest() throws Exception {
		String uri = "/update";//Rest uri
		Student student = new Student(10006L, "From Junit - Updated", "Junit-updated");

		String inputJson = super.mapToJson(student);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.put(uri)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	//Test method to test - delete
	@Test
	public void deleteByIDTest() throws Exception {
		String uri = "/delete/10006";//Rest uri

		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.delete(uri))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
}
