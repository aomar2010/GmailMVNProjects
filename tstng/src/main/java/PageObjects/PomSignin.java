
/* in this class we create the page object for sign in page   */

package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PomSignin {

	WebDriver driver;

	public PomSignin(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@id='identifierId']")
	private WebElement userName;

	@FindBy(how = How.XPATH, using = "//*[@id='identifierNext']/content/span")
	private WebElement next;

	@FindBy(how = How.XPATH, using = "//*[@id='password']/div[1]/div/div[1]/input")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@id='passwordNext']/content/span")
	private WebElement nextPassword;

	// get username
	public void getUsername(String userName) {
		this.userName.sendKeys(userName);
	}

	// return Next
	public void getNext() {
		this.next.click();

	}

	// return password
	public void getPassword(String password) {

		this.password.sendKeys(password);
	}

	// return next button after password
	public void getNextPassword() {

		this.nextPassword.click();
	}

}
