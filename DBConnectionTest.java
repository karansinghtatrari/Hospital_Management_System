package HospitalManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/hospital?useSSL=false&allowPublicKeyRetrieval=true";
		String user="root";  //mysql username
		String password="Khushi@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(url,user,password);
			System.out.println("Connected to Mysql database successfully!");
			conn.close();
		}catch(ClassNotFoundException e) {
			System.out.println("Mysql JDBC Driver not found!");
		}
		catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

}
