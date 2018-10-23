package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.TestBase;

public  class PomGmailHomePage extends TestBase  {


	public PomGmailHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// find compose button
	@FindBy(how = How.XPATH, using = "//*[@gh='cm']")
	private WebElement compose;
	
	// find compose button
	private List<WebElement> listEmails;

	public List<WebElement> getEmails() {
		this.listEmails =driver.findElements(By.xpath("//span[@class='bog']"));
	      return this.listEmails;
	    }

	// Get Compose
	public void getCompose() {
		this.compose.click();

	}
	
	// right click Archive 
	@FindBy(how = How.XPATH, using = "//*[@class='J-N-JX aDE aDD']")
	private WebElement archive;
	
	// Get Compose
	public void getArchive() {
		this.archive.click();

	}



	

	
	
	


	


}
