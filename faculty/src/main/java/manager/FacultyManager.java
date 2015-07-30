package manager;

import java.util.List;

import dao.model.Course;
import dao.model.Student;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;

public interface FacultyManager {
	public List<Course> getAllCourses() throws ResourceNotFoundException;

	public Course saveCourse(Course course) throws ResourceAlreadyExistException, ResourceNotFoundException;

	public Course getCourseById(String id) throws ResourceNotFoundException;

	public List<Student> getStudentsEnrolledAtcourse(String courseId) throws ResourceNotFoundException;
	public void saveStudentAtCourse(int courseId, Student student);
	public void deleteCourse(Course course) throws ResourceNotFoundException;

	public List<Student> getAllStudents();

}
