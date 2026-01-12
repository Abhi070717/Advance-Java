package in.co.rays.jdbcstmtcreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"delete from Student_Marksheet where id = 5");

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Delete  Duplicates: 0  Warnings: 0" + "\n" + "Record Deleted");

		conn.close();
		stmt.close();
	

}
}
	

