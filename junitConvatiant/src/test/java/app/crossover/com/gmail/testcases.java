package app.crossover.com.gmail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import methods.crossover.com.gmail.SharedMethod;
import resources.propertiesFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class testcases extends SharedMethod {
	propertiesFile config = new propertiesFile();

	/*
	 * Test case 1 , create new email 1. Login to Gmail - Sender user 2. create the
	 * Email with attached file 3. logout
	 */
//	@Ignore("Im Not Ready")
	@Test

	public void FirstComposeEmail() throws IOException, InterruptedException {

		log.info("login with the sender\n");
		// login to sender email then Tab Compose
		logMeIn(config.getsender(), config.getpasswotd()).composeEmail(config.getreciever()).logMeOut();
		System.out.println("Logout\n");

	}

	/*
	 * Test case 2 1. login to Gmail -- Receiver user2. search for the Email with
	 * specific title 3. logout
	 */
	@Ignore("Im Not Ready")

	@Test 
	public void SecondCheckReceiver() throws IOException, InterruptedException {
		log.info("login with the sender\n");
		// login with receiver
		logMeIn(config.getreciever(), config.getpasswotd());
		logMeOut();
		// Open the received email
		// searchEmail();
		log.info("verify the email \n");
		// emailContent();

	}

	@Before
	public void beforeMethod() throws IOException {
		System.out.println("New driver instantiated \n");
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getimplicitlyWait()), TimeUnit.SECONDS);
		System.out.println("Type URL\n");
		driver.navigate().to(config.geturl());

	}

	// @After
	public void afterMethod() {
		driver.quit();
		driver = null;
	}

}
