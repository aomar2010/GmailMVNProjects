package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.TestBase;

public class PomGmailHomePage extends TestBase {

	public PomGmailHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// find compose buttons
	@FindBy(how = How.XPATH, using = "//*[@gh='cm']")
	private WebElement compose;

	// find user Menu logout
	@FindBy(how = How.XPATH, using = "//*[@class='gb_9a gbii']")
	private WebElement userMenulogout;

	// find user logout
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Sign out')]")
	private WebElement logout;
	
	// find compose button
	private List<WebElement> listEmails;

	public List<WebElement> getEmails() {
		this.listEmails = driver.findElements(By.xpath("//span[@class='bog']"));
		return this.listEmails;
	}

	// Get Compose
	public void getCompose() {
		this.compose.click();

	}

	// right click Archive
	@FindBy(how = How.XPATH, using = "//*[contains(text(), 'Archive')]")
	private WebElement archive;

	// left part of the page 
	@FindBy(how = How.XPATH, using = "//*[@class='byl']")
	public WebElement lefttab;
	
	// right click delete
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Delete')]")
	private WebElement delete;

	// right click make as unread
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Mark as unread')]")
	private WebElement MakeAsUnread;

	// Mouse Hover delete
	@FindBy(how = How.XPATH, using = "//*[@data-tooltip='Delete']")
	private WebElement mouseHoverDelete;
	// Mouse Hover Archive
	@FindBy(how = How.XPATH, using = "//*[@data-tooltip='Archive']")
	private WebElement mouseHoverArchive;
	// Mouse Hover Make as read
	@FindBy(how = How.XPATH, using = "//*[@data-tooltip='Mark as unread']")
	private WebElement mouseHoverMakeAsRead;
	// Drag to 
	@FindBy(how = How.XPATH, using = "//*[@title='DragDrop']")
	public WebElement dragTo;
	
	
	// Get Archive
	public void getArchive() {
		this.archive.click();

	}

	// Get Delete
	public void getDelete() {
		this.delete.click();

	}

	// Get righ click Make as unread
	public void getMakeAsUnread() {
		this.MakeAsUnread.click();
	}

	// Get Mouse hover Delete
	public void getMouseHoverDelete() {
		this.mouseHoverDelete.click();
	}

	// Get user Menu logout
	public void getUserLogout() {
		this.userMenulogout.click();
	}

	// Get logout
	public void getLogout() {
		this.logout.click();

	}

	// Get Mouse hover Archive
	public void getMouseHoverArchive() {
		this.mouseHoverArchive.click();
	}
	
	
	

}
