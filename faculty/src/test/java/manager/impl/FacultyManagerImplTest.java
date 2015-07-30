package manager.impl;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.impl.CoursesDaoImpl;
import dao.impl.StudentsDaoImpl;
import dao.model.Course;
import manager.FacultyManager;
import model.exception.ResourceAlreadyExistException;
import model.exception.ResourceNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class FacultyManagerImplTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(FacultyManagerImplTest.class);

	@Mock
	private CoursesDaoImpl coursesDao;

	@Mock
	private StudentsDaoImpl studentsDao;

	@InjectMocks
	FacultyManager facultyManager = new FacultyManagerImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCourseById_succesTest() throws ResourceNotFoundException {
		Course course = new Course("234-sdfw", "PLF", 3, 0);
		when(coursesDao.getCourseById("id")).thenReturn(course);

		assertEquals(course, facultyManager.getCourseById("id"));
		verify(coursesDao).getCourseById("id");
	}

	@Test(expected = ResourceNotFoundException.class)
	public void getCourseById_exceptionTest() throws ResourceNotFoundException {
		when(coursesDao.getCourseById("id2")).thenReturn(null);
		facultyManager.getCourseById("id2");

	}

	@Test
	public void getAllCoursesTest() throws ResourceNotFoundException {
		Course course = new Course("234-sdfw", "PLF", 3, 0);
		Course course2 = new Course("23sdf4-s345dfw", "MAP", 3, 1);

		List<Course> list = new LinkedList<Course>();

		list.add(course);
		list.add(course2);

		when(coursesDao.getAllCourses()).thenReturn(list);

		List<Course> result = facultyManager.getAllCourses();
		assertEquals(result.get(0), course);
		LOGGER.debug(result.toString());
	}

	@Test(expected = ResourceAlreadyExistException.class)
	public void saveCourse_exceptionTest() throws ResourceAlreadyExistException, ResourceNotFoundException {
		Course course = new Course("24-sfw", "PF", 3, 0);
		// doThrow(new
		// ResourceAlreadyExistException()).when(coursesDao).saveCourse(course);
		when(coursesDao.getCourseByName(course.getName())).thenReturn(course);
		try {
			facultyManager.saveCourse(course).getName();
		} finally {
			verify(coursesDao).getCourseByName(course.getName());
			verifyNoMoreInteractions(coursesDao);
		}

	}

	@Test
	public void saveCourse_succesIsDeletedTest() throws ResourceAlreadyExistException, ResourceNotFoundException {
		Course course = new Course("24-sfw", "PF", 3, 1);

		when(coursesDao.getCourseByName(course.getName())).thenReturn(course);
		doNothing().when(coursesDao).modifyCourseIsDeleted(course);
		when(coursesDao.getCourseById(anyString())).thenReturn(course);
		assertEquals(course.getName(), facultyManager.saveCourse(course).getName());
		LOGGER.debug("After assertEquals");
		verify(coursesDao).getCourseByName(course.getName());
		verify(coursesDao).modifyCourseIsDeleted(course);
		verify(coursesDao).getCourseById(anyString());
	}

	@Test
	public void saveCourse_succesTest() throws ResourceAlreadyExistException, ResourceNotFoundException {
		Course course = new Course("24-sfw", "PF", 3, 0);
		when(coursesDao.getCourseByName(course.getName())).thenReturn(null);
		// LOGGER.debug(coursesDao.getCourseByName(course.getName()).getName());
		when(coursesDao.saveCourse(course)).thenReturn(1);
		when(coursesDao.getCourseById(anyString())).thenReturn(course);
		assertEquals(course.getName(), facultyManager.saveCourse(course).getName());
		verify(coursesDao).getCourseByName(course.getName());
		verify(coursesDao).saveCourse(course);
		verify(coursesDao).getCourseById(anyString());
	}
}
