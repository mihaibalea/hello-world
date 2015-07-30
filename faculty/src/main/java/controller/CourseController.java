package controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import business.Business;
import model.CourseBO;
import model.StudentBO;
import model.exception.InvalidIdException;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;
import util.LogMessages;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private Business business;

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

	public CourseController() {
	}

	// @Autowired
	// public CourseController( Business business) {
	// this.business=business;
	//
	// }

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CourseBO> getCourses(@RequestHeader HttpHeaders httpHeader) throws ResourceNotFoundException {

		LOGGER.info("getCourses(): Retrieving courses httpMethod=RequestedMethod.GET value='/' by {} {}",
				httpHeader.get("user-agent"), httpHeader.get("host"));
		return business.getAllCourses();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseBO getCourseId(@RequestHeader HttpHeaders httpHeader, @PathVariable("id") String id)
			throws ResourceNotFoundException {
		LOGGER.info(LogMessages.getCourseId(httpHeader));
		return business.getCourseById(id);

	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CourseBO postCourse(@RequestBody CourseBO courseBo)
			throws ResourceAlreadyExistException, InvalidIdException, ResourceNotFoundException {
		
		return 	business.saveCourse(courseBo);
			
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentBO saveStudentAtCourse(@PathVariable int id, @RequestBody StudentBO studentBo)
			throws InvalidIdException {
		if (id < 0) {
			throw new InvalidIdException("The id " + id + " is invalid");
		}

		business.saveStudentAtCourse(id, studentBo);

		return studentBo;

	}

	@RequestMapping(value = "/{id}/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentBO> getStudentsEnrolledAtCourse(@RequestHeader HttpHeaders httpHeader, @PathVariable String id)
			throws ResourceNotFoundException {

		LOGGER.info(LogMessages.getStudentsEnroledAt(httpHeader));

		return business.getStudentsEnrolledAtcourse(id);

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CourseBO putCourse(@RequestBody CourseBO courseBO) {
		return courseBO;

	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseBO deleteCourse(@RequestBody CourseBO courseBO) throws ResourceNotFoundException {
		business.deleteCourse(courseBO);

		return courseBO;

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundException(ResourceNotFoundException exception) {
		LOGGER.info(exception.getMessage());
		return exception.getMessage();

	}

	@ExceptionHandler(ResourceAlreadyExistException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleResourceAlreadyExistException(ResourceAlreadyExistException exception) {

		LOGGER.error(exception.getMessage());
		return "ERROR";
	}

	@ExceptionHandler(InvalidIdException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInvalidIdException(InvalidIdException exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception exception) {
		LOGGER.error("Errors in the application:", exception);
		return "INTERNAL_SERVER_ERROR";

	}

}