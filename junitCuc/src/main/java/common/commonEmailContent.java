package common;

import static org.junit.Assert.assertEquals;

import PageObjects.PomReadMailBody;

public class commonEmailContent extends SharedMethod {

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
