package dao;

import java.util.List;

import dao.model.Student;
import model.exception.ResourceNotFoundException;

public interface StudentsDao {
	public List<Student> getAllstudents();
	public void saveStudent(Student student);
	public Student getStudentById(int id);
	public List<Student> getStudentsEnrolledAtcourse(String courseId) throws ResourceNotFoundException;
	public void addStudent(Student student);
	public Student getStudentByName(String name);
}
