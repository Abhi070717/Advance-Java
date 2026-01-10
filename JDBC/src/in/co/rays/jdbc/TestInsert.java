package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java Stablised the Connection to MYSQL Database Successfully");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into st_user values(1, 'Abhi', 'Bhawsar', 'abhi@gmail.com', 'abhi@123', '2002-07-17'),(2, 'Raj', 'Singh', 'raj@gmail.com', 'raj@111', '2004-02-10),(3, 'Shivam', 'Yadav', 'shiv@gmail.com', 'shiv121', '2003-06-12'),"
				+ "(4, 'Aman', 'Verma', 'aman@gmail.com', 'aman123', '2002-11-25'),(5, 'Neha', 'Sharma', 'neha@gmail.com', 'neha456', '2004-03-18'),(6, 'Rohit', 'Singh', 'rohit@gmail.com', 'rohit789', '2001-08-09'),"
				+ "(7, 'Pooja', 'Patel', 'pooja@gmail.com', 'pooja321', '2003-01-30'),(8, 'Karan', 'Mehta', 'karan@gmail.com', 'karan654', '2002-07-14').......");
		
		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Stored  Duplicates: 0  Warnings: 0" + "\n" + "Record Inserted");
		System.out.println();
	}

}
