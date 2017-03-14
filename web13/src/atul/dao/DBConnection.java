package atul.dao;

import java.sql.DriverManager;
	import java.sql.SQLException;

	import com.mysql.jdbc.Connection;

	public class DBConnection {


	public static Connection getConnection() throws SQLException,ClassNotFoundException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con=null;
	    con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/TechChallenge","root","password");

	    System.out.println("Connected to Database ");
	     return con;

	}
	}




