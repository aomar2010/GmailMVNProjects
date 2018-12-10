package common;


import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import PageObjects.PomGmailHomePage;
import PageObjects.PomMailbody;
import resources.TestBase;
import resources.propertiesFile;

 public class SharedMethod extends TestBase {

	public static String subject ="qmbvnsbhithxtqaukzbe";// RandomStringUtils.randomAlphabetic(20).toLowerCase();
	public static String body = RandomStringUtils.randomAlphabetic(20).toLowerCase();
	public static String filename = "test.txt";
	public static WebElement row;
	public static propertiesFile config = new propertiesFile();
	public static commonGmailLogin login=new commonGmailLogin();
	public static commonSearchEmails search=new commonSearchEmails();
	public static commonComposeEmail compose=new commonComposeEmail();
	public static PomGmailHomePage homepage = new PomGmailHomePage(driver);
	public static commonEmailContent content=new commonEmailContent();
	

/*
 * 
 
	@Override
	public void logMeIn(String username, String password) {

		pomGmailLoginPage login = new pomGmailLoginPage(driver);
		log.info("-------- Type Sender ID");
		login.typeUsername(username);
		log.info("-------- Click Next");
		login.getNext();
		log.info("-------- Type Sender password  ID");
		login.typePassword(password);
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
*/
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
	public void logMeOut() throws InterruptedException {
       
		homepage.getUserLogout();
		homepage.getLogout();
		Thread.sleep(2000);
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
	
}