package in.co.rays.jdbcstmtcreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSearch1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("java is connected with mysql successfully....");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from Student_Marksheet");

		// Header
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("| %-3s | %-14s | %-8s | %-7s | %-9s | %-5s |%n", "ID", "Name", "RollNo", "Physics",
				"Chemistry", "Maths");
		System.out.println("-----------------------------------------------------------------");

		// Data
		while (rs.next()) {
			System.out.printf("| %-3d | %-14s | %-8s | %-7s | %-9s | %-5s |%n", rs.getInt(1), rs.getString(2),
					rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
		}

		// Footer line
		System.out.println("-----------------------------------------------------------------");

		System.out.println("Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Search  Duplicates: 0  Warnings: 0" + "\n" + "Record Displayed");

		conn.close();
		stmt.close();

	}

}