package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.TestBase;

public class PomMailbody extends TestBase {

	

	public PomMailbody(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// To button
	@FindBy(how = How.XPATH, using = "//*[@name='to']")
	private WebElement TxtTO;

	// Subject button
	@FindBy(how = How.XPATH, using = "//*[@name='subjectbox']")
	private WebElement TxtSubject;

	// Subject button
	@FindBy(how = How.XPATH, using ="//div[@class='Am Al editable LW-avf']")
	private WebElement TxtBody;

	// File button
		@FindBy(how = How.XPATH, using ="//div[@class='a1 aaA aMZ']")
		private WebElement BtnFile;
		// File button
				@FindBy(how = How.CSS, using ="tr.btC td:nth-of-type(1) div div:nth-of-type(2)")
				private WebElement BtnSend;

	// Get To text box
	public void GetTo(String to) {
		TxtTO.sendKeys(to);
		;
	}

	// Get Subject text box
	public void GetSubject(String subject) {
		TxtSubject.sendKeys(subject);
	}

	// Get Body text box
	public void GetBody(String body) {
		TxtBody.sendKeys(body);
	}

	// Get Attachment
	public void Getattachment() {
		BtnFile.click();
	}

	// Get Send Button
	public void GetSend() {
		BtnSend.click();

	}

}
