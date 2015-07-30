package manager.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.CoursesDao;
import dao.StudentsDao;
import dao.model.Course;
import dao.model.Student;
import manager.FacultyManager;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;

public class FacultyManagerImpl implements FacultyManager {
	@Autowired
	private CoursesDao coursesDao;
	@Autowired
	private StudentsDao studentsDao;

	public void setCoursesDao(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}

	public void setStudentsDao(StudentsDao studentsDao) {
		this.studentsDao = studentsDao;
	}

	@Transactional
	public List<Course> getAllCourses() throws ResourceNotFoundException {

		List<Course> list = new LinkedList<Course>();

		for (Course c : coursesDao.getAllCourses()) {
			if (c.getIsDeleted() == 0) {
				list.add(c);
			}
		}
		return list;

	}

	@Transactional
	public Course getCourseById(String id) throws ResourceNotFoundException {

		Course course = coursesDao.getCourseById(id);

		if (course == null) {

			throw new ResourceNotFoundException("Could not find course with id " + id);

		}
		return course;
	}

	@Transactional(rollbackFor = Exception.class)
	public Course saveCourse(Course course) throws ResourceAlreadyExistException, ResourceNotFoundException {

		Course courseFromDao = coursesDao.getCourseByName(course.getName());
		if (courseFromDao != null) {
			if (courseFromDao.getIsDeleted() == 0) {
				throw new ResourceAlreadyExistException(
						"The course having the name " + courseFromDao.getName() + " allready exist");
			}
			coursesDao.modifyCourseIsDeleted(courseFromDao);

		}

		UUID id = UUID.randomUUID();
		course.setId(id.toString());
		coursesDao.saveCourse(course);
		return coursesDao.getCourseById(course.getId());
	}

	@Transactional
	public List<Student> getStudentsEnrolledAtcourse(String courseId) throws ResourceNotFoundException {

		return studentsDao.getStudentsEnrolledAtcourse(courseId);

	}

	@Transactional
	public void saveStudentAtCourse(int courseId, Student student) {
		// boolean exist = false;
		// for (Student st : studentsDao.getAllstudents()) {
		//
		// if (st.getId() == student.getId() &&
		// st.getName().equals(student.getName()) && st.getAge() ==
		// student.getAge()
		// && st.getAddress().equals(student.getAddress())) {
		//
		// exist = true;
		// }
		//
		// }
		//
		// if (exist == false) {
		// studentsDao.addStudent(student);
		// }

		if (studentsDao.getStudentByName(student.getName()) == null) {
			studentsDao.addStudent(student);
		}

		coursesDao.saveStudentAtCourse(courseId, student);
		coursesDao.modifyCourse(courseId);
	}

	@Transactional
	public void deleteCourse(Course course) throws ResourceNotFoundException {
		Course cours = getCourseById(course.getId());

		if (cours == null || cours.getIsDeleted() == 1) {
			throw new ResourceNotFoundException("Could not find course with id " + course.getId());
		}

		coursesDao.deleteCourse(course);
	}

	public List<Student> getAllStudents() {
		return studentsDao.getAllstudents();
	}
}
