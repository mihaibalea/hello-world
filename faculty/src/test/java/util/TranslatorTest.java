package util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.model.Course;
import model.CourseBO;

public class TranslatorTest {
	private final static Logger LOGGER=LoggerFactory.getLogger(TranslatorTest.class);
	private Translator translator = new Translator();

	@Test
	public void testTranslateCourseToCourseBO() {

		Course course = new Course("123de1-21s3", "AI", 2, 0);
		CourseBO courseBO = translator.translateCourseToCourseBO(course);

		assertEquals(course.getName(), courseBO.getName());
		assertEquals(course.getNrStudents(), courseBO.getNrStudents());

	}

	@Test
	
	public void testTranslateCoursesToCoursesBO() {
		Course course1=new Course("3123-123","ASC",21,0);
		Course course2=new Course("334-143","MAP",1,0);
		Course course3=new Course("31b3-125","PLF",2,0);
		
		List<Course> list=new LinkedList<Course>();
		list.add(course1);
		list.add(course2);
		list.add(course3);
		
		List<CourseBO> listBO=translator.translateCoursesToCoursesBO(list);
		LOGGER.debug(listBO.get(0).getName());
		
		assertEquals(listBO.get(0).getName(), course1.getName());
		assertEquals(listBO.get(0).getNrStudents(), course1.getNrStudents());
		assertEquals(listBO.get(1).getName(), course2.getName());
		assertEquals(listBO.get(1).getNrStudents(), course2.getNrStudents());
		assertEquals(listBO.get(2).getName(), course3.getName());
		assertEquals(listBO.get(2).getNrStudents(), course3.getNrStudents());
		
		
		//assertEquals(list, listBO);
	}
	@Test
	public void test(){
		List<CourseBO> listBO=translator.translateCoursesToCoursesBO(null);
		assertNotNull(listBO);
		assertEquals(listBO, Collections.emptyList());
	}
	
}
