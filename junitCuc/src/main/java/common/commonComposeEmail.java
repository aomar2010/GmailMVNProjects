package common;

import java.io.IOException;

import PageObjects.PomGmailHomePage;
import PageObjects.PomMailbody;

public class commonComposeEmail extends SharedMethod {

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
		

	}

}
