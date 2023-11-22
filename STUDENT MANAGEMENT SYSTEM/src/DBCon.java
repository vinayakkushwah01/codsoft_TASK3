import java.sql.*;

import org.omg.CORBA.PUBLIC_MEMBER;
public class DBCon {
	public static Connection getConnection(){
	 	Connection conn = null;
	 	Statement stmt;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","6269");
			   stmt = conn.createStatement();
			
			//stmt.execute("create database study;");
			
		//	stmt.executeUpdate("CREATE TABLE players (UID INT, First_Name VARCHAR(45), Last_Name VARCHAR(45), Age INT);");
			
			
			/*ResultSet rs = stmt.executeQuery("SELECT * FROM players;");
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("No. of columns : " + rsmd.getColumnCount());
            System.out.println("Column 1 Name: " + rsmd.getColumnName(1));
            System.out.println("Column 1 Type : " + rsmd.getColumnTypeName(1));
            System.out.println("Column 2 Name: " + rsmd.getColumnName(2));
            System.out.println("Column 2 Type : " + rsmd.getColumnTypeName(2));
            System.out.println("Column 3 Name: " + rsmd.getColumnName(3));
            System.out.println("Column 3 Type : " + rsmd.getColumnTypeName(3));
            System.out.println("Column 4 Name: " + rsmd.getColumnName(4));
            System.out.println("Column 4 Type : " + rsmd.getColumnTypeName(4));
            System.out.println("Column 5 Name: " + rsmd.getColumnName(5));
            System.out.println("Column 5 Type : " + rsmd.getColumnTypeName(5));*/
			
		}
		catch(Exception e ){
			System.out.print("error \n"+  e.getMessage());
		}
		return conn;
	}
	
	
	

}
