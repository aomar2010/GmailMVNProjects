package app.crossover.com.gmail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cucumber.api.java.en.Given;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class testcases extends SharedMethod {

	/*
	 * Test case 1 , create new email 1. Login to Gmail - Sender user 2. create the
	 * Email with attached file 3. logout
	 */
	@Test
	
	public void FirstComposeEmail(  )
			throws IOException, InterruptedException {
		
		log.info("login with the sender\n");
		// login to sender email then Tab Compose
		LoginMthd(getsender(), getpasswotd());
		// Type the email
		ComposeMthd(getreciever());
		System.out.println("Logout\n");
		// Logout
		// logoutMthd();
	}

	/*
	 * Test case 2 1. login to Gmail -- Receiver user2. search for the Email with
	 * specific title 3. logout
	 */
	@Test
	public void SecondCheckReceiver() throws IOException, InterruptedException {
		log.info("login with the sender\n");
		// login with receiver
		LoginMthd(getreciever(), getpasswotd());
		log.info("search for the email with specific subject\n ");
		// Open the received email
		SearchEmailmthd();
		log.info("verify the email \n");
		EmailContentmthd();
		
	}

	@Before
	public void beforeMethod() throws IOException {
		System.out.println("New driver instantiated \n");
		driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getimplicitlyWait()), TimeUnit.SECONDS);
		System.out.println("Type URL\n");
		driver.navigate().to(geturl());

	}

	@After
	public void afterMethod() {
		driver.quit();
		driver = null;
	}

}
