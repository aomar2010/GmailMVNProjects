package common;

import PageObjects.PomGmailHomePage;

public class commonSearchEmails extends SharedMethod{

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
}
