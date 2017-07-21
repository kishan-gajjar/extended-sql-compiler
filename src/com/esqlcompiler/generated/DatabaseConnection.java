package stevens.cs562.generated;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @version 1.10 07 April 2017
 * @authors SOWMYA VIJAYAKUMAR, KISHAN GAJJAR
 */
public class DatabaseConnection {
	
	private static Connection db;
	
	/*
	 * Database connection variables
	 */
	private static final String user = "postgres";
	private static final String password = "kamala_v";
	private static final String url = "jdbc:postgresql://localhost:5432/Test";
	
	/*
	 * loadDBDrivers loads database driver
	 */
	public static void loadDBDrivers() {
		
		try{	
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver initialization successful...");
		}
		catch(Exception ex) {
			System.out.println("Failing driver initialization...");					
			ex.printStackTrace();
		}
	}
	
	/*
	 * getDBInstance connect to database
	 */
	public static Connection getDBInstance() {
		
		/* create instance of database if not available */
		if(db == null){
			try{
				loadDBDrivers();
				db = DriverManager.getConnection(url, user, password);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}	
		return db;
	}
}