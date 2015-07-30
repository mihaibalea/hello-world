package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import dao.model.Course;
import dao.model.Student;
import model.CourseBO;
import model.StudentBO;

public class Translator {
	public StudentBO translateStudentTostudentBO(Student student) {
		StudentBO studentBO = new StudentBO();

		studentBO.setName(student.getName());
		studentBO.setAge(student.getAge());
		studentBO.setAddress(student.getAddress());

		return studentBO;

	}

	public List<StudentBO> translateStudentsToStudentsBO(List<Student> listOfStudents) {
		List<StudentBO> listOfStudentsBO = new ArrayList<StudentBO>();
		for (Student student : listOfStudents) {
			listOfStudentsBO.add(translateStudentTostudentBO(student));

		}
		return listOfStudentsBO;

	}

	public List<CourseBO> translateCoursesToCoursesBO(List<Course> listOfCourses) {
		if (CollectionUtils.isEmpty(listOfCourses)) {
			return Collections.emptyList();
		}
		List<CourseBO> listOfCourseBO = new ArrayList<CourseBO>();
		for (Course course : listOfCourses) {
			listOfCourseBO.add(translateCourseToCourseBO(course));

		}
		return listOfCourseBO;

	}

	public Course translateCourseBOtoCourse(CourseBO courseBO) {
		Course course = new Course();

		course.setName(courseBO.getName());
		course.setNrStudents(courseBO.getNrStudents());
		course.setIsDeleted(0);

		return course;
	}

	public CourseBO translateCourseToCourseBO(Course course) {
		CourseBO courseBo = new CourseBO();

		courseBo.setName(course.getName());
		courseBo.setNrStudents(course.getNrStudents());
		return courseBo;
	}

	public Student translateStudentBOToStudent(StudentBO studentBO) {
		Student student = new Student();

		student.setName(studentBO.getName());
		student.setAge(studentBO.getAge());
		student.setAddress(studentBO.getAddress());
		return student;
	}

}
