package dataProvider_extra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArrayCheck {
	@Test(dataProvider = "getData")
	public void loginSauceDemo(String username, String password) {
//		String username="Mohan";
//		String password="mohan@345";
		System.out.println(username);
		System.out.println(password);

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] cred = new Object[6][2];

		cred[0][0] = "Mohan";
		cred[0][1] = "mohan@345";

		cred[1][0] = "Sohan";
		cred[1][1] = "sohan@134";

		cred[2][0] = "Rohan";
		cred[2][1] = "rohan@345";

		cred[3][0] = "John";
		cred[3][1] = "john@899";

		cred[4][0] = "Jack";
		cred[4][1] = "jack@356";

		cred[5][0] = "Nick";
		cred[5][1] = "nick@885";

		return cred;
	}

}
