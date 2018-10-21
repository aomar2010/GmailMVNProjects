package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.TestBase;

public class PomGmailHomePage extends TestBase  {


	public PomGmailHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// find compose button
	@FindBy(how = How.XPATH, using = "//*[@gh='cm']")
	private WebElement BtnCompose;
	
	// find compose button
	private List<WebElement> ListEmails;

	public List<WebElement> getEmails() {
		ListEmails =driver.findElements(By.xpath("//span[@class='bog']"));
	      return ListEmails;
	    }

	// Get Compose
	public void getCompose() {
		BtnCompose.click();

	}

	

	
	
	// Click Menu to logout
	By menu = By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]");

	// Get Menu
	public WebElement GetMenu() {
		return driver.findElement(menu);
	}

	// Find logout
	By logout = By.cssSelector("#gb_71");

	// Get Logout
	public WebElement getlogout() {
		return driver.findElement(logout);

	}


}
