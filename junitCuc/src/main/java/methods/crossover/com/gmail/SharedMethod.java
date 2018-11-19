package methods.crossover.com.gmail;


import java.io.IOException;
import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageObjects.PomGmailHomePage;
import PageObjects.PomMailbody;
import PageObjects.PomReadMailBody;
import PageObjects.PomSignin;
import resources.TestBase;
import resources.propertiesFile;

abstract public class SharedMethod extends TestBase {

	public static String subject ="qmbvnsbhithxtqaukzbe";// RandomStringUtils.randomAlphabetic(20).toLowerCase();
	public static String body = RandomStringUtils.randomAlphabetic(20).toLowerCase();
	public static String filename = "test.txt";
	public static WebElement row;
	protected propertiesFile config = new propertiesFile();

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
		//
		if (login.getWrongPassword()) {

			log.info("-------- Wrong credential ");

		}

		//
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
		// homepage.GetMenu().click();

	}

	// Search for the email
	@Override
	public void searchEmail() {
		PomGmailHomePage homepage = new PomGmailHomePage(driver);

		System.out.println("Open email with Subject " + subject);
		for (int i = 0; i < homepage.getEmails().size(); i++) {
			if (homepage.getEmails().get(i).getText().contains(subject)) {
				//
				row = homepage.getEmails().get(i);
				System.out.println("Open email with Subject " + subject);

			}

			else {
				log.info("-------- Email is not found ");
				i = homepage.getEmails().size();

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

	@Override
	public void rightMenu() {
		PomGmailHomePage homepage = new PomGmailHomePage(driver);

		Actions action = new Actions(driver);
		action.contextClick(row).perform();
		String reqaction = "archive";
		switch (reqaction) {
		case "archive":
			homepage.getArchive();
			break;
		case "open":
			row.click();
			break;
		case "delete":

			homepage.getDelete();
			break;
		case "MakeAsUnread":
			homepage.getMakeAsUnread();
			break;

		}

	}

	@Override
	public void logMeOut() {
		PomGmailHomePage homepage = new PomGmailHomePage(driver);
       
		homepage.getUserLogout();
		homepage.getLogout();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://gmail.com");
	}

	@Override
	public void mouseHover() {
		Actions action = new Actions(driver);
		action.moveToElement(row).build().perform();
		PomGmailHomePage homepage = new PomGmailHomePage(driver);
		String reqaction = "delete";
		switch (reqaction) {
		case "archive":
			homepage.getArchive();
			break;
		case "open":
			row.click();
			break;
		case "delete":

			homepage.getMouseHoverDelete();
			break;
		case "MakeAsUnread":
			homepage.getMakeAsUnread();
			break;

		}

	}
	@Override
	public void dragDrop() throws InterruptedException {
		PomGmailHomePage homePage=new PomGmailHomePage(driver);
		
		
		Actions action = new Actions(driver);
		action.moveToElement(homePage.lefttab);
		
			Thread.sleep(2000);
	
		//// scroll
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].scrollIntoView();", homePage.dragTo);
		
		 action.dragAndDrop(row,homePage.dragTo).build().perform();
		 // System.out.println("done");
		
		
	} 
}