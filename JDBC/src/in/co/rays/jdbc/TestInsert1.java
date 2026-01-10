package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"INSERT INTO Student_Marksheet VALUES (1, 'Rahul Sharma', 101, 85, 78, 92),(2, 'Anita Verma', 102, 88, 90, 91), (3, 'Karan Singh', 103, 76, 72, 80), (4, 'Priya Mehta', 104, 92, 89, 95), "
				+ "(5, 'Amit Patel', 105, 81, 77, 84).........");
		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Stored  Duplicates: 0  Warnings: 0" + "\n" + "Record Inserted");

		conn.close();
		stmt.close();

	}
}
