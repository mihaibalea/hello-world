package util;

import org.springframework.http.HttpHeaders;

public class LogMessages {

	

	public static String getCourses(HttpHeaders httpHeader) {
		return "Retrieving courses from controller.CourseController.getCourses method=RequestedMethod.GET value='/' by {}" + httpHeader.get("user-agent") + " " + httpHeader.get("host");
	}

	public static String getCourseId(HttpHeaders httpHeader) {
		return "Retrieving course from controller.CourseController.getCourseId method=RequestedMethod.GET value='/{id}' by "
				+ httpHeader.get("user-agent") + " " + httpHeader.get("host");
	}

	public static String getStudentsEnroledAt(HttpHeaders httpHeader) {
		return "Retrieving students from controller.CourseController.getStudentEnrolledAtCourse method=RequestedMethod.GET value='/{id}/students' by "+httpHeader.get("user-agent") +" "+httpHeader.get("host");
	}
}
