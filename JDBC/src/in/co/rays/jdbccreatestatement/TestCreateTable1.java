package in.co.rays.jdbccreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateTable1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"create table Student_Marksheet(Id int primary key, Name varchar(45), RollNo int, Physics int,  Chemistry int , Maths int)");

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Table  Duplicates: 0  Warnings: 0" + "\n" + "Table Created");

		conn.close();
		stmt.close();
	}

}
