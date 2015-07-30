package dao;

import java.util.List;

import dao.model.Course;
import dao.model.Student;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;

public interface CoursesDao {
	public List<Course> getAllCourses() throws ResourceNotFoundException;
	public int saveCourse(Course course) throws ResourceAlreadyExistException;
	public Course getCourseById(String id);
	public void saveStudentAtCourse(int courseId, Student student);
	public void modifyCourse(int courseId);
	public void modifyCourseIsDeleted(Course course);
	public void deleteCourse(Course course) throws ResourceNotFoundException;
	public Course getCourseByName(String name);

}
