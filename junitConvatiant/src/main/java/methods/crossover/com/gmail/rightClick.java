package methods.crossover.com.gmail;

import org.openqa.selenium.interactions.Actions;

import PageObjects.PomGmailHomePage;

public class rightClick extends SharedMethod {
	PomGmailHomePage homepage = new PomGmailHomePage(driver);

	public rightClick EmailRightClick() {

		Actions action = new Actions(driver);
		action.contextClick(row).perform();
	
		return this;
	}

	@Override
	public void DeleteEmail() {

		homepage.getDelete();

	}
	@Override
	public void ArchiveEmail() {

		homepage.getArchive();

	}
	@Override
	public void MakeEmailAsRead() {

		homepage.MakeEmailAsRead();

	}
	@Override
	public void MakeEmailAsUnRead() {

		homepage.MakeEmailAsUnRead();

	}
}
