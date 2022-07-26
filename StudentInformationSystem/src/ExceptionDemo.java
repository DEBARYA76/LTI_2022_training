import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import exception.AgeException;
import model.Employee;

public class ExceptionDemo {

	//public static void main(String[] args) throws IOException,SQLException {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try {
			new BufferedReader(new FileReader(new File("c:\\abc.txt")));  // compiler will throw the exception
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection connection=null;
		
		try {
			Statement st=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//throw new RuntimeException();  //unchecked
		
		try {
			// throw is used by developer to explicitly throw an exception
			throw new ClassNotFoundException();    //checked
		}catch (Exception e) {

		}
		
		try {
			int res=10/0;
			Employee employee=null;
			employee.getEmployeeId();
			
			int[]arr=new int[5];
			
			System.out.println(arr[9]);
			new BufferedReader(new FileReader(new File("c:\\abc.txt")));
		}
		catch (ArithmeticException e) {
			//e.printStackTrace();
			//System.out.println(e.getMessage());
			System.out.println("Cannot divide by zero");
		}catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
		}
		//try with resources
		try(BufferedReader br=new BufferedReader(new FileReader("c:\\abc.txt"));
				InputStream is=new FileInputStream("c:\\def.bat")){
			
		}catch (Exception e) {
			
		}
		
		//throw new AgeException("Invalid Age");
	}

}
