package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1));
			System.out.println("firstName: " + rs.getString(2));
			System.out.println("lastName: " + rs.getString(3));
			System.out.println("login: " + rs.getString(4));
			System.out.println("password: " + rs.getString(5));
			System.out.println("dob: " + rs.getDate(6));
		}
		conn.close();
	}

}
