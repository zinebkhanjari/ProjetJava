package Dao;
/**
 * @author zineb khanjari & moukrim abdsamad
 * @date 
 */
//import com.mysql.jdbc.Connection;
import java.sql.*;

public class ConnectionDataBase { 
	private static java.sql.Connection conn=null; 
	public static java.sql.Connection connectionBd() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_club","root","");
			System.out.println("connection reussite a la base de donnée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;
	}
	
	

}
