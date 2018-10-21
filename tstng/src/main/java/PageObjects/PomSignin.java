
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
	private WebElement Next;

	@FindBy(how = How.XPATH, using = "//*[@id='password']/div[1]/div/div[1]/input")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//*[@id='passwordNext']/content/span")
	private WebElement Nextpassword;

	// get username
	public void getUsername(String name) {
		userName.sendKeys(name);
	}

	// return Next
	public void getNext() {
		Next.click();

	}

	// return password
	public void getpassword(String pass) {

		password.sendKeys(pass);
	}

	// return next button after password
	public void getNextpassword() {

		Nextpassword.click();
	}

}
