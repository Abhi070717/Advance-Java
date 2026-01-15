package in.co.rays.jdbcstmtpreparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testDelete();
//		testfindbylogin
//		testfindbypk
		testAuthenticate();
//		testSearch();

	}

// Add Query Adding New User Details
	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(9);
		bean.setFirstName("Ramesh");
		bean.setLastName("Sen");
		bean.setLogin("ram@gmail.com");
		bean.setPassword("ramesh132");
		bean.setDob(sdf.parse("2003-04-09"));

		model.add(bean);
	}

// Update Query Updating Users Details
	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);
		bean.setFirstName("Sneha");
		bean.setLastName("Sahu");
		bean.setLogin("sneha@gmail.com");
		bean.setPassword("ssahu123");
		bean.setDob(sdf.parse("2002-10-07"));

		model.update(bean);

	}

// Delete Query Delete User Details
	public static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(9);

		model.delete(bean);

	}
	
//Search Query using findbylogin in User Details
	public static void testfindByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("aman@gmail.com");

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}
	
//Search Query using findbypk in User Details
	public static void testfindByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(7);

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}
	
//Search Query using Authenticate in User Details
	public static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("aman@gmail.com", "aman123");

		if (bean == null) {
			System.out.println("invalid login and password");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}


//Search query search user details
	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Ramesh");
		// bean.setLastName("Sen");

		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

			model.search(bean);
		}

	}

//Search1 query search user details
	public static void testSearch1() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Abhi");

//			bean.setId(3);
//			bean.setFirstName("Sneha");
//			bean.setLastName("Sahu");
//			bean.setLogin("sneha@gmail.com");
//			bean.setPassword("ssahu123");
//			bean.setDob(sdf.parse("2002-10-07"));

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLogin());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());

		model.Search1(bean);

	}

}
