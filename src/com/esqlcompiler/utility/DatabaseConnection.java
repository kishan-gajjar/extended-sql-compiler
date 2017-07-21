package com.esqlcompiler.utility;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @version 1.10 07 April 2017
 * @authors KISHAN GAJJAR
 */
public class DatabaseConnection {
	
	private static Connection db;
	
	/*
	 * Database connection variables
	 */
	private static final String user = "demo";
	private static final String password = "demo";
	private static final String url = "jdbc:postgresql://localhost:5432/DB";
	
	/**
	 * loadDBDrivers loads database driver
	 */
	public static void loadDBDrivers() {
		
		try{	
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver initialization successful...");
		}
		catch(Exception e) {
			System.out.println("Failing driver initialization...");					
			e.printStackTrace();
		}
	}
	
	/**
	 * getDBInstance connect to database
	 */
	public static Connection getDBInstance() {
		
		/* create instance of database if not available */
		if(db == null){
			try{
				loadDBDrivers();
				db = DriverManager.getConnection(url, user, password);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/* return an instance of the Database */																																																																																							
		return db;
	}
}