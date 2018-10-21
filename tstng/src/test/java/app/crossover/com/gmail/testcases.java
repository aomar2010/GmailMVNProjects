package app.crossover.com.gmail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class testcases extends SharedMethod {

	/*
	 * Test case 1 , create new email 1. Login to Gmail - Sender user 2. create the
	 * Email with attached file 3. logout
	 */
	@Test(priority = 1)
	@Parameters({ "email1", "password1", "email2", "password2" })
	public void ComposeEmail(String username, String password, String receiver, String password2)
			throws IOException, InterruptedException {
		log.info("login with the sender\n");
		// login to sender email then Tab Compose
		LoginMthd(username, password);
		// Type the email
		ComposeMthd(receiver);
		System.out.println("Logout\n");
		// Logout
		// logoutMthd();
	}

	/*
	 * Test case 2 1. login to Gmail -- Receiver user2. search for the Email with
	 * specific title 3. logout
	 */
	@Test(priority = 2)
	@Parameters({ "email2", "password2" })
	public void CheckReceiver(String username, String password) throws IOException, InterruptedException {
		log.info("login with the sender\n");
		// login with receiver
		LoginMthd(username, password);
		log.info("search for the email with specific subject\n ");
		// Open the received email
		SearchEmailmthd();
		log.info("verify the email \n");
		EmailContentmthd();
		
	}

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void beforeMethod(String browser, String url) throws IOException {
		System.out.println("New driver instantiated \n");
		driver = initializeDriver(browser);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Type URL\n");
		driver.navigate().to(url);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		driver = null;
	}

}
