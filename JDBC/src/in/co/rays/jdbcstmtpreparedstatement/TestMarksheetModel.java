package in.co.rays.jdbcstmtpreparedstatement;

import java.text.SimpleDateFormat;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
		testDelete();

	}

// Add Query Adding New Student_Marksheet Details
	public static void testAdd() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);
		bean.setName("Ramesh Sen");
		bean.setRollNo(105);
		bean.setPhysics(78);
		bean.setChemistry(98);
		bean.setMaths(75);

		model.add(bean);
	}

// Update Query Updating Users Details
	public static void testUpdate() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);
		bean.setName("Ramesh Sen");
		bean.setRollNo(105);
		bean.setPhysics(78);
		bean.setChemistry(98);
		bean.setMaths(75);

		model.Update(bean);

	}

// Delete Query Adding New User Details
	public static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		bean.setId(5);

		model.delete(bean);

	}

}
