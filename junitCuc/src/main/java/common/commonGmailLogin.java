package common;

import PageObjects.pomGmailLoginPage;

/*
 * this class is for  login into Gmail which received the forget password email  
 * Author Ahmed Omar
 * Aomar2010@gmail.com
 */

public class commonGmailLogin extends SharedMethod {

	public commonGmailLogin() {
	}

	@Override
	public void gmailLogin(String username, String password) {

		pomGmailLoginPage login = new pomGmailLoginPage(driver);
		log.info("-------- gmailLogin Type gmail ID");
		login.typeUsername(username);
		log.info("-------- gmailLogin Click Next");
		login.clickNext();
		log.info("--------gmailLogin Type Sender password  ID");
		login.typePassword(password);
		log.info("--------gmailLogin Click Next");
		login.clickNextPassword();
		//
		if (login.getWrongPassword()) {

			log.info("-------- Wrong credential ");

		}
	}
}
