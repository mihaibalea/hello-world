package business;

import java.util.List;

import model.CourseBO;
import model.StudentBO;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;

public interface Business {

	public List<CourseBO> getAllCourses() throws ResourceNotFoundException;
	public CourseBO getCourseById(String id) throws ResourceNotFoundException;
	// public void addCourse(Course c);

	public CourseBO saveCourse(CourseBO course) throws ResourceAlreadyExistException, ResourceNotFoundException;
	public List<StudentBO> getStudentsEnrolledAtcourse(String courseId) throws ResourceNotFoundException;
	public void saveStudentAtCourse(int id, StudentBO student);
	public void deleteCourse(CourseBO courseBO) throws ResourceNotFoundException;
	public List<StudentBO> getAllStudents();
}
