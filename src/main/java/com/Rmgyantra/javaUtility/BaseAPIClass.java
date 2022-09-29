package com.Rmgyantra.javaUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	public DataBaseUtility dUtil=new DataBaseUtility();

	@BeforeSuite
	public void connWithDB() throws Throwable
	{
		System.out.println("Connect With database ");
		dUtil.connectWithtDB();

	}

	@AfterSuite
	public void closeConnWithDB() throws Throwable
	{
		dUtil.closeConnectionWithDB();
		System.out.println("close the connection with database ");
	}

}
