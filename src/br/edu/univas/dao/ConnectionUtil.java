package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "abc123";
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost/trabalho2";
		
		Properties properties = new Properties();
		properties.setProperty("user", USERNAME);
		properties.setProperty("password", PASSWORD);
		
		return DriverManager.getConnection(url, properties);
	}

}
