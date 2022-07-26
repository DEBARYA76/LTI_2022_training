package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import controller.StudentController;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentAppView {


	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);



		StudentController controller =new StudentController();

		while(true)

		{ 
			System.out.println("1.Student \n      2.Admin \n       3.EXIT \n");
			int userType=sc.nextInt();

			if(userType==1)
			{String choice="y";
			do {
				System.out.println("1.Sign Up \n  2.Update Phone Number \n   3.View all courses \n   4.Register for a course \n  5.Sign out\n");
				int option=sc.nextInt();


				Qualification qualification = null;
				switch(option)
				{
				case 1:
					System.out.println("Enter name   ,dob(dd/mm/YYYY), phone number,  email,     address");

					String name=sc.next();
					String dateOfBirth=sc.next();
					DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dob =LocalDate.parse(dateOfBirth,formatter);  	
					String phoneNumber=sc.next();
					String email=sc.next();
					String address=sc.next();
					System.out.println("1. Master 2.Graduate 3.Intermediate 4.Matric \n");
					int q=sc.nextInt();
					if(q==1)
						qualification=Qualification.Master;
					if(q==2)
						qualification=Qualification.Graduate;
					if(q==3)
						qualification=Qualification.Intermidiate;
					if(q==4)
						qualification=Qualification.Matric;

					Student student=new Student(name,dob,qualification,phoneNumber,email,address);
					String message=controller.addNewStudent(student);
					System.out.println(message);
					break;


				case 4:
					System.out.println("Enter roll no and course you want to register");
					int rollNo=sc.nextInt();
					int courseId=sc.nextInt();
					String regDateString=sc.next();
					DateTimeFormatter formatter2=DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate regDate=LocalDate.parse(regDateString,formatter2);

					Registration registration=new Registration(regDate,courseId,rollNo);
					message=controller.registrationDb(registration);
					System.out.println(message);
					break;

				}
				System.out.println("continue?(y/n)");
				choice=sc.next();

			}while(choice.equalsIgnoreCase("y"));
			}
			else if(userType==2)
			{System.out.println("1. View all user  \n  2.find student \n 3.add new course ");
			int option=sc.nextInt();
			
			
			switch(option)
			{
			case 1:
				List<Student> students =controller.viewAllStudents();
				Iterator<Student> iterator =students.iterator();
				while(iterator.hasNext())
				{
					Student st=iterator.next();
					System.out.println(st.getRollNo()+" "+st.getName()+" "+st.getQualification());
				}

				break;  
			case  2:
				System.out.println("Enter rollno");
				int rollNo=sc.nextInt();
				Student st =controller.findStudentByRollNo(rollNo);
				if(st!=null)
				{
					System.out.println(st.getRollNo()+" "+st.getName()+" "+st.getQualification());
				}else 
					System.out.println("ROLL NOT FOUND ");
				break;
			case 3:
				System.out.println("Enter course name ,duration and fees");
				String courseName=sc.next();
				int duration=sc.nextInt();
				double fees=sc.nextDouble();

				System.out.println("1. Master    2.Graduate       3.Intermediate        4.Matric \n");
				int q=sc.nextInt();
				Qualification eligibility=null;
				if(q==1)
					eligibility=Qualification.Master;
				if(q==2)
					eligibility=Qualification.Graduate;
				if(q==3)
					eligibility=Qualification.Intermidiate;
				if(q==4)
					eligibility=Qualification.Matric;
				
				Course course=new Course(courseName,duration,fees,eligibility);
				String message=controller.addNewCourse(course);
				System.out.println(message);
				break;
			}
			}else
				//System.out.println("Invalid Choice");
				System.exit(0);
		}
	}
}

