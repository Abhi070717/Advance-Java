package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Student_Marksheet");

		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1));
			System.out.println("Name: " + rs.getString(2));
			System.out.println("RollNo: " + rs.getInt(3));
			System.out.println("Physics: " + rs.getInt(4));
			System.out.println("Chemistry: " + rs.getInt(5));
			System.out.println("Maths: " + rs.getInt(6));
			System.out.println("------Next Student Detail------");
		}
		conn.close();
		stmt.close();

	}
}
