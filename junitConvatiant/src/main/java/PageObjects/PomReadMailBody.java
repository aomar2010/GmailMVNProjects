package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PomReadMailBody {
	WebDriver driver;

	public PomReadMailBody(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// find Subject
	@FindBy(how = How.CSS, using = "div.ha h2.hP")
	private WebElement LblSubject;

	// find Body
	@FindBy(how = How.CSS, using = "div.ii.gt div")
	private WebElement LblBody;
	// find File
	@FindBy(how = How.CSS, using = "div.aQA span")
	private WebElement LblFile;

	// return Subject
	public String GetSubject() {
		return LblSubject.getText();
	}

	// return Subject
	public String GetBody() {
		return LblBody.getText();
	}

	// return file name

	public String getFIleName() {
		return LblFile.getText();
	}
}