package in.co.rays.jdbcstmtcreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate1 {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"update Student_Marksheet set Name = 'Priya', Physics = 98,  chemistry = 90 , Maths = 98 where id = 4  ");

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Update  Duplicates: 0  Warnings: 0" + "\n" + "Record Updated");

		conn.close();
		stmt.close();
	}

}