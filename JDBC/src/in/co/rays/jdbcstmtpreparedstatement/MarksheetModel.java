package in.co.rays.jdbcstmtpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MarksheetModel {

//Add Query in student_Marksheet
	public void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		PreparedStatement pstmt = conn.prepareStatement("insert into Student_Marksheet values(?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getRollNo());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Added  Duplicates: 0  Warnings: 0" + "\n" + "Data Inserted");

		conn.close();
		pstmt.close();
	}

// Update Query in Student_Marksheet
	public void Update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		System.out.println("Java is connected with MYSQL Successfully");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set Name = ?, RollNo = ?, Physics = ?, Chemistry = ?, Maths = ? where id = ?");

		pstmt.setInt(6, bean.getId());
		pstmt.setString(1, bean.getName());
		pstmt.setInt(2, bean.getRollNo());
		pstmt.setInt(3, bean.getPhysics());
		pstmt.setInt(4, bean.getChemistry());
		pstmt.setInt(5, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Update  Duplicates: 0  Warnings: 0" + "\n" + "Data Updated");

		conn.close();
		pstmt.close();
	}
	
// Delete Query Deleting in Studend_Marksheet
	public void delete(MarksheetBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from Student_Marksheet where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " Query OK, The rows affected (0.02 sec)" + "\n"
				+ "Records: Delete  Duplicates: 0  Warnings: 0" + "\n" + "Data Deleted");

		conn.close();
		pstmt.close();

	}
}