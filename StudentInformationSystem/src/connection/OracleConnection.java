package connection;

import java.sql.*;

public class OracleConnection {
     
	
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER="hr";
    private static final String PASS="hr";
    
    public static Connection getConnection() 
    {Connection conn=null;
    	try {
			
			 conn=DriverManager.getConnection(url, USER, PASS);
   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; 
    }
	
	
	public static void main(String[] args) {
		if(getConnection()!=null)
	 {
		 System.out.println("Connected");
	 }
	 
	 else
		 System.out.println("Not Connected");
	}

}
