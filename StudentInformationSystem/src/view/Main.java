package view;

import java.time.LocalDate;
import java.util.*;
import dao.StudentDao;
import dao.StudentDaoImplInMemory;
import model.Course;
import model.Qualification;
import model.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDao dao=new StudentDaoImplInMemory();
	    Student student1=new Student("John",LocalDate.of(2000,10,12),Qualification.Graduate,"888888888","hdit@gmail.com","mumba");
	    Student student2=new Student("Mike",LocalDate.of(2020,10,12),Qualification.Matric,"8866544528","wbfrh@gmail.com","Thane");
	    Student student3=new Student("Blue",LocalDate.of(2010,10,12),Qualification.Intermidiate,"8111111111","gdgewf@gmail.com","LAKD");
	    Student student4 = new Student("John", LocalDate.of(2000, 10, 12), Qualification.Graduate, "9858585843",
				"john@lti.com", "Mumbai");
		Student student5 = new Student("Mike", LocalDate.of(2001, 9, 15), Qualification.Master, "6785585843",
				"mike@lti.com", "Chennai");
		Student student6 = new Student("Kevin", LocalDate.of(2000, 1, 22), Qualification.Graduate, "7865585843",
				"kevin@lti.com", "Pune");
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		dao.addNewStudent(student4);
		dao.addNewStudent(student5);
		dao.addNewStudent(student6);
	    
		
		Course course1=new Course("Java",8,4000,Qualification.Graduate);
		Course course2=new Course("ROK",5,3000,Qualification.Graduate);
		Course course3=new Course("JHI",2,5000,Qualification.Matric);
		Course course4=new Course("NRa",6,9000,Qualification.Master);
		Course course5=new Course("Java", 6, 4000, Qualification.Graduate);
		Course course6=new Course("Python", 3, 2000, Qualification.Graduate);
		Course course7=new Course("Azure", 8, 8000, Qualification.Master);
		Course course8=new Course(".Net", 5, 5000, Qualification.Matric);
		
		
		
		dao.addNewCourse(course1);
		dao.addNewCourse(course4);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);
		dao.addNewCourse(course5);
		dao.addNewCourse(course6);
		dao.addNewCourse(course7);
		dao.addNewCourse(course8);
		
		List<Course> courses=dao.viewAllCourses();
		Iterator <Course>  iteratorCourses=courses.iterator();
		while(iteratorCourses.hasNext())
		{
			Course  course=iteratorCourses.next();
			System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getDurationInMonths()+" "+
					course.getFee()+" "+course.getEligibility());
			
			
		}
		
		
		
		System.out.println("View All Students");
		
		List<Student> students = dao.viewAllStudents();
		Iterator<Student> iterator=students.iterator();
		
		while(iterator.hasNext())
		{
			Student student=iterator.next();
			System.out.println(student.getRollNo()+" "+student.getName()+ " " + student.getEmail()+" "+student.getPhoneNo()+" "+
					//Student.getCollegename());
					student.getCollegename());
		}
		
		Scanner sc=new Scanner (System.in);
		
		System.out.println("Enter student roll No and course applying for");
		int rollNo=sc.nextInt();
		int courseId=sc.nextInt();
		
		Student stud1=dao.findStudentByRollNo(rollNo);
		Course c1=dao.findCourseById(courseId);
		
		if(stud1!=null) {
			if(c1!=null) {
				dao.registration(stud1, c1);
				System.out.println("Registration successful.");
			}
			else {
				System.out.println("Course not found.");
			}
		}else {
			System.out.println("Student not found.");
		}
		
		System.out.println("View All registrations.");
		
		Map<Student, Course> registrations=dao.viewAllRegistrations();
		
		Set<Map.Entry<Student, Course>> regs=registrations.entrySet();
		
		for(Map.Entry<Student, Course> r:regs) {
			Student s=r.getKey();
			Course c=r.getValue();
			System.out.println(s.getRollNo()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
		}
		
		
		
		
		
		
		
		/*
		System.out.println("Enter Roll No ");
		int rollNo=sc.nextInt();
		Student student =dao.findStudentByRollNo(rollNo);
		if(student!=null)
		{
			System.out.println(student.getRollNo()+" "+student.getName());
		}
		else
			System.out.println("Student not found");
		*/
		/*
		System.out.println("Enter Roll No");
		int rollNo=sc.nextInt();
		Student student =dao.findStudentByRollNo(rollNo);
		
		
		
		
		if(student!=null)
		{ System.out.println("Enter phone number");
		String phoneNo=sc.next();
		student.setPhoneNo(phoneNo);
		dao.updateStudentProfile(student);
		}
		else
			System.out.println("Student not found");
		
	   
		
         System.out.println("View All Students");
		
		List<Student>  students= dao.viewAllStudents();
		Iterator<Student> iterator = students.iterator();
		//Iterator<Student> iterators=students.iterator();
		while(iterator.hasNext())
		{
			Student student = iterator.next();
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getPhoneNo());
		}
		
		
		
		System.out.println("enter stu roll and course");
		int rollNo=sc.nextInt();
		int courseId=sc.nextInt();
		
		

		Student stud1=dao.findStudentByRollNo(rollNo);
		Course c1=dao.findCourseById(courseId);
		
		
		if(stud1!=null)
		{
			if(c1!=null)
				{dao.registration(stud1, c1);
			System.out.println("Registration Suceess");}
			
			else {
				System.out.println("course not found");
			}
			
		}
		else
			System.out.println("Student njot fiund");
		
		
		System.out.println("view all registration");
		
		
		Map<Student,Course>  registrations =dao.viewAllRegistrations();
		Set<Map.Entry<Student,Course>>  regs=registrations.entrySet();
		
		for (Map.Entry<Student, Course>r:regs)
		{
			Student s=r.getKey();
			Course c=r.getValue();
			System.out.println(s.getRollNo()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
		}
			
			
			
			*/
		
		
		
	}

}
