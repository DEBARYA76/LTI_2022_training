package dao;

import java.util.*;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;

public interface StudentDao {
	String addNewStudent(Student student);
	void updateStudentProfile(Student student);
	void registration(Student student,Course course);
	Map<Student ,Course > viewAllRegistrations();
 //	viewRegistrationByRollNo(int rollNo);
	
	Course findCourseById(int courseId);
	Student findStudentByRollNo(int rollNo);
	List<Student> viewAllStudents();
	//void addNewStudent(Student student);
	String registrationDb(Registration registration);
	String addNewCourse(Course course);
	List<Course> viewAllCourses();
	
}
