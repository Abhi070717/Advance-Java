package in.co.rays.jdbcstmtpreparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

//Search Query findbyRollNo in student_Marksheet
	public MarksheetBean findByRollNo(int RollNo) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from Student_Marksheet where RollNo = ?");

		pstmt.setInt(1, RollNo);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

		}

		conn.close();
		pstmt.close();
		return bean;

	}
	//Search Query findbypk in Student_Marksheet (pk = public key)
		public MarksheetBean findByPk(int pk) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from Student_Marksheet where id = ?");

			pstmt.setInt(1, pk);

			ResultSet rs = pstmt.executeQuery();

			MarksheetBean bean = null;

			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRollNo(rs.getInt(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
			}

			conn.close();
			pstmt.close();
			return bean;
		}
		
// Search Query Searching Marksheet Details
		public List search(MarksheetBean bean) throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcproject", "root", "root");

			StringBuffer sql = new StringBuffer("select * from Student_Marksheet where 1=1");

			if (bean != null) {
				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" and Name like '" + bean.getName() + "%'");
				}
//				if (bean.getRollNo() != null && bean.getRollNo().length() > 0) {
//					sql.append(" and RollNo like '" + bean.getRollNo() + "%'");
//				}
			}

			System.out.println("sql Query===> " + sql.toString());
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			List list = new ArrayList();

			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRollNo(rs.getInt(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(5);
				bean.setMaths(rs.getInt(6));
				list.add(bean);
			}

			System.out.println("Query OK, The rows affected (0.02 sec)" + "\n"
					+ "Records: Search  Duplicates: 0  Warnings: 0" + "\n" + "Record Displayed");

			conn.close();
			pstmt.close();
			return list;

		}

}