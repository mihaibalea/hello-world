package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.Business;
import model.StudentBO;
import model.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private Business business;
	
	public StudentController() {

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentBO> getCourses(@RequestHeader HttpHeaders httpHeader) throws ResourceNotFoundException {

		
		return business.getAllStudents();
	}
	
	

	
}