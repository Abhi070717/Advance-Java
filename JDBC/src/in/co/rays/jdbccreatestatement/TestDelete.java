package in.co.rays.jdbccreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from st_user where id = 9");

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Delete  Duplicates: 0  Warnings: 0" + "\n" + "Record Deleted");

		conn.close();
		stmt.close();

	}

}