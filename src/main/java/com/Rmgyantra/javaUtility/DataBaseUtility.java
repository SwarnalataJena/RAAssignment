package com.Rmgyantra.javaUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	public Connection con;
	public void connectWithtDB() throws Throwable
	{
		Driver d=new Driver();
		DriverManager.registerDriver(d);

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}

	public void closeConnectionWithDB() throws Throwable
	{
		con.close();
	}

	public ResultSet executeQueryOfDB(String query) throws Throwable
	{
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery(query);
		return result;
	}

}
