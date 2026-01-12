package in.co.rays.jdbcstmtcreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreateTable {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table st_user(id int primary key, firstName varchar(45), lastName varchar(45), login varchar(45), password varchar(45), dob date)");

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Table  Duplicates: 0  Warnings: 0" + "\n" + "Table Created");

		conn.close();
		stmt.close();
	}

}