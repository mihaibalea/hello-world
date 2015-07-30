package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.model.Course;

public class CourseMapper implements RowMapper<Course>{
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course(rs.getString("id"), rs.getString("name"), rs.getInt("nrStudents"),rs.getInt("isDeleted"));

		return course;
	}

}
