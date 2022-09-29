package com.RMGYantra.assignment;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.Rmgyantra.javaUtility.BaseAPIClass;
import com.Rmgyantra.javaUtility.DataBaseUtility;
import com.Rmgyantra.javaUtility.EndPoint;
import com.Rmgyantra.javaUtility.RandomNum;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import pojoImplement.POJOClass;

public class CreateGetAndValitadeProjectTest extends BaseAPIClass{
	@Test
	public void createGetAndValidateProjectTest() throws Throwable
	{
		RandomNum ran=new RandomNum();
		POJOClass p=new POJOClass("swarna", "sdet"+ran.randomNum(), "completed", 20);

		Response res = given()
				.contentType(ContentType.JSON)
				.body(p)
				.when()
				.post("http://localhost:8084"+EndPoint.addPro);

		String projectId=res.jsonPath().get("projectId");

		Response resp = given()
				.pathParam("proid", projectId)
				.when()
				.get("http://localhost:8084"+EndPoint.getSinPro);

		String projectname = resp.jsonPath().get("projectName");
		System.out.println(projectname);

		ResultSet result = dUtil.executeQueryOfDB("select * from project;");

		while(result.next())
		{
			if(result.getString(4).equals(projectname))
			{
				System.out.println("project is available in DB");

			}
		}

	}

}
