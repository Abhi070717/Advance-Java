package in.co.rays.jdbccreatestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {
		
		public static void main(String[] args) throws SQLException, ClassNotFoundException {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

			System.out.println("Java is connected with MYSQL Successfully");

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"update St_user set firstName = 'Puja', login = 'pooja@gmail.com', password ='pooja123', dob = '2002-01-15' where id = 7  ");

			System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
					+ "Records: Update  Duplicates: 0  Warnings: 0" + "\n" + "Record Updated");

			conn.close();
			stmt.close();
		
	}

}
