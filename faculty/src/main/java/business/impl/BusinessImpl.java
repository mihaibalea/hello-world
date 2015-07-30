package business.impl;

import java.util.List;

import business.Business;
import dao.model.Course;
import dao.model.Student;
import manager.FacultyManager;
import model.CourseBO;
import model.StudentBO;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;
import util.Translator;

public class BusinessImpl implements Business {

	private Translator translator;
	private FacultyManager facultyManager;

	public BusinessImpl(FacultyManager facultyManager, Translator translator) {
		this.facultyManager = facultyManager;
		this.translator = translator;

	}

	public List<CourseBO> getAllCourses() throws ResourceNotFoundException {
		List<Course> list = facultyManager.getAllCourses();

		return translator.translateCoursesToCoursesBO(list);
	}

	public CourseBO saveCourse(CourseBO courseBo) throws ResourceAlreadyExistException, ResourceNotFoundException {
		return translator.translateCourseToCourseBO(facultyManager.saveCourse(translator.translateCourseBOtoCourse(courseBo)));

	}
	

	public CourseBO getCourseById(String id) throws ResourceNotFoundException {
		CourseBO courseBo = translator.translateCourseToCourseBO(facultyManager.getCourseById(id));
		return courseBo;
	}

	public List<StudentBO> getStudentsEnrolledAtcourse(String courseId) throws ResourceNotFoundException {
		return translator.translateStudentsToStudentsBO(facultyManager.getStudentsEnrolledAtcourse(courseId));
	}

	public void saveStudentAtCourse(int id, StudentBO studentBO){
		facultyManager.saveStudentAtCourse(id, translator.translateStudentBOToStudent(studentBO));
	}
	
	public void deleteCourse(CourseBO courseBO) throws ResourceNotFoundException{
		facultyManager.deleteCourse(translator.translateCourseBOtoCourse(courseBO));
		
	}

	public List<StudentBO> getAllStudents() {
		List<Student>list= facultyManager.getAllStudents();
		return translator.translateStudentsToStudentsBO(list);
	}

}
