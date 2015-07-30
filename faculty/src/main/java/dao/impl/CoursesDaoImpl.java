package dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.CoursesDao;
import dao.model.Course;
import dao.model.Student;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;
import util.CourseMapper;

public class CoursesDaoImpl implements CoursesDao {
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOG = LoggerFactory.getLogger(CoursesDaoImpl.class);

	public CoursesDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	public List<Course> getAllCourses() throws ResourceNotFoundException {

		String querry = "select * from courses";
		List<Course> courses = jdbcTemplate.query(querry, new CourseMapper());

		return courses;

	}

	public Course getCourseById(String id) throws EmptyResultDataAccessException {
		String querry = "select * from courses where id=?";
		Course course;
		try {
			course = jdbcTemplate.queryForObject(querry, new Object[] { id }, new CourseMapper());
 
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return course;

	}

	public Course getCourseByName(String name) {
		String querry = "select * from courses where name=?";
		Course course;
		try {
			course = jdbcTemplate.queryForObject(querry, new Object[] { name }, new CourseMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return course;

	}

	public int saveCourse(Course course) throws ResourceAlreadyExistException {
		
		String SQL = "insert into courses(id,name,nrStudents) values (?,?,?)";

		
		
		return jdbcTemplate.update(SQL, course.getId(), course.getName(), course.getNrStudents());
		

	}
	

	public void modifyCourseIsDeleted(Course course) {
		String sql = "update courses set isDeleted=0 where id=?";
		jdbcTemplate.update(sql, course.getId());
	}

	public void saveStudentAtCourse(int courseId, Student student) {
		String sql = "insert into studentscourses values(?,?)";

		jdbcTemplate.update(sql, student.getId(), courseId);
	}

	public void modifyCourse(int courseId) {
		String sql = "update courses set nrStudents=nrStudents+1 where id=?";
		jdbcTemplate.update(sql, courseId);

	}

	public void resetNrStudents(Course course) {
		String sql = "update courses set nrStudents=0 where id=?";
		jdbcTemplate.update(sql, course.getId());

	}

	public void deleteCourse(Course course) throws ResourceNotFoundException {
		String sql = "delete from courses where id=?";

		jdbcTemplate.update(sql, course.getId());
	}

}