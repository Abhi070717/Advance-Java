package in.co.rays.jdbccreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSearch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("java is connected with mysql successfully....");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select Id from st_user");
		
		while (rs.next()) {
			System.out.printf("| %-3d |%n", rs.getInt(1));
		}
		
		System.out.println("Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Search  Duplicates: 0  Warnings: 0" + "\n" + "Record Displayed");

		conn.close();
		stmt.close();
	}
}