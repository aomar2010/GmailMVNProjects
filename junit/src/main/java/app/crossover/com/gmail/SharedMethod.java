package app.crossover.com.gmail;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import PageObjects.PomGmailHomePage;
import PageObjects.PomMailbody;
import PageObjects.PomReadMailBody;
import PageObjects.PomSignin;
import resources.TestBase;


abstract public class SharedMethod extends TestBase {


	public static String subject = RandomStringUtils.randomAlphabetic(20).toLowerCase();
	public static String body = RandomStringUtils.randomAlphabetic(20).toLowerCase();
	public static String filename = "test.txt";
	
	@Override
	public void logMeIn(String username, String password) {
		PomSignin login = new PomSignin(driver);
		log.info("-------- Type Sender ID");
		login.getUsername(username);
		log.info("-------- Click Next");
		login.getNext();
		log.info("-------- Type Sender password  ID");
		login.getPassword(password);
		log.info("-------- Click Next");
		login.getNextPassword();
         try {
			getScreenshot("file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void composeEmail(String emailto) {
		PomGmailHomePage homepage = new PomGmailHomePage(driver);
		homepage.getCompose();
		PomMailbody mail = new PomMailbody(driver);
		log.info("-------- Type Sender ID");
		// Type To
		mail.GetTo(emailto);
		log.info("-------- Type Subject");
		// Type Subject
		mail.GetSubject(subject);
		log.info("-------- Type Body");
		// Type Body
		mail.GetBody(body);
		log.info("-------- Attache the file ");
		// Attach the file
		mail.Getattachment();
		try {
			Runtime.getRuntime().exec(".\\drivers\\gmail.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
		Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("-------- Click Send ");
		// Click Send
		mail.GetSend();
		// wait till the email is sent
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Click Menu
		//homepage.GetMenu().click();

	}

	@Override
	public void logMeOut() {
		PomGmailHomePage homepage = new PomGmailHomePage(driver);
		// Click Logout
		homepage.getlogout().click();
		// Delete All cookies
		driver.manage().deleteAllCookies();
		// refresh after clearing cookies
		driver.navigate().refresh();
	}

	// Search for the email
	@Override
	public void searchEmail() {
		PomGmailHomePage homepage = new PomGmailHomePage(driver);
		
		System.out.println("Open email with Subject " + subject);
		for (int i = 0; i < homepage.getEmails().size(); i++) {
			if (homepage.getEmails().get(i).getText().contains(subject)) {
				homepage.getEmails().get(i).click();
				log.info("-------- Open the email with subject "+subject );
				break;
			}
				
			 else {
				 log.info("-------- Email is not found ");

			}
		}

	}

	// check the email content
	@Override
	public void emailContent() {
		PomReadMailBody mail = new PomReadMailBody(driver);
		// Assert Subject
		assertEquals(mail.GetSubject(), subject);
		System.out.println("Subject is correct \n");
		// Assert Body
		assertEquals(mail.GetBody(), body);
		System.out.println("Body is correct \n");
		// assert file name
		assertEquals(mail.getFIleName(), filename);
		 log.info("-------- File name is correct  ");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}