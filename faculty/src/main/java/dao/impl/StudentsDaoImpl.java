package dao.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.StudentsDao;
import dao.model.Student;
import model.exception.ResourceNotFoundException;
import util.StudentMapper;

public class StudentsDaoImpl implements StudentsDao {
	private JdbcTemplate jdbcTemplate;

	public StudentsDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> getAllstudents() {
		String querry = "select * from students";
		List<Student> students = jdbcTemplate.query(querry, new StudentMapper());
		return students;
	}

	public void saveStudent(Student student) {
		String SQL = "insert into student(id,name,age,address) values (?,?,?,?)";

		jdbcTemplate.update(SQL, student.getId(), student.getName(), student.getAge(), student.getAddress());

	}

	public Student getStudentById(int id) {
		String querry = "select * from students where id=?";
		Student student;
		try {
			student = jdbcTemplate.queryForObject(querry, new Object[] { id }, new StudentMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return student;

	}
	public Student getStudentByName(String name){
		String querry = "select * from students where name=?";
		Student student;
		try {
			student = jdbcTemplate.queryForObject(querry, new Object[] { name }, new StudentMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return student;
	}

	public List<Student> getStudentsEnrolledAtcourse(String courseId) throws ResourceNotFoundException {
		String querry = "select s.id,s.name,s.age,s.address from courses c,students s,studentscourses sc where c.id=sc.courseId and s.id=sc.studentId and c.id=?";
		List<Student> students = jdbcTemplate.query(querry, new Object[] { courseId }, new StudentMapper());
		//if (students.isEmpty())
		//	throw new ResourceNotFoundException("Course with id " + courseId + " not found");
		//else
			return students;

	}

	public void addStudent(Student student) {
		String sql="insert into students(name,age,address) values(?,?,?)";
		jdbcTemplate.update(student.getName(),student.getAge(),student.getAddress());
		
	}

}
