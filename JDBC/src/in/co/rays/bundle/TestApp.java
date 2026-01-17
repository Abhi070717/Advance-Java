  package in.co.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp {
	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

		String Driver = rb.getString("driver");
		String Url = rb.getString("url");
		String Username = rb.getString("username");
		String Password = rb.getString("password");

		System.out.println(Driver + "\n" + Url + "\n" + Username + "\n" + Password);

		rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("hindi"));

		System.out.println(rb.getString("Greeting"));

		rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("Punjabi"));

		System.out.println(rb.getString("Greeting"));

	}

}
