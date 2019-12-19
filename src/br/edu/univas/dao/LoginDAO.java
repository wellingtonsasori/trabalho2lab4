package br.edu.univas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bre.edu.univas.vo.Login;

public class LoginDAO {
	
private Connection connection;
	
	public LoginDAO() throws SQLException{
		connection = ConnectionUtil.getConnection();
	}
	
	public void save(Login login) throws SQLException{
		String sql = "insert into login(username, password) values (‘admin’, ‘admin’), (‘root’, ‘root’);";
			
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,  login.getUsername());
		statement.setString(2, login.getPassword());
		
		statement.executeUpdate();
	}
	
	public List<Login> listAll() throws SQLException{
		List<Login> lista = new ArrayList<>();
		String sql = "select * from login";
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while (result.next()) {
			Login login = new Login();
			login.setUsername(result.getString("username"));
			login.setPassword(result.getString("password"));
			lista.add(login);
		}
		
		
		return lista;
	}


}
