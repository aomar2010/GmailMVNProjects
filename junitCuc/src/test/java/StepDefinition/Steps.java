package StepDefinition;

import java.io.IOException;

import common.SharedMethod;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public  class Steps extends SharedMethod {
	
	@Given("^Open chrome$")
	public void open_the_Chrome_and_launch_the_application() throws Throwable {
		System.out.println("This Step open the chrome and launch the application.");
		driver = initializeDriver();
	}

	@When("^Navigate to gmail.com$")
	public void enter_the_Username_and_Password() throws Throwable {
		System.out.println("This step user navigate to gmail .");
		driver.navigate().to(config.geturl());
	}

	@And("^Login with sender email and Password$")
	public void TypeUsernameAndPassword() throws IOException, InterruptedException {
		System.out.println("This step User enters UserName and Password.");
		login.gmailLogin(config.getsender(), config.getpasswotd());

	}

	@Then("^Compose the Email$")
	public void Compuse_EMail() throws Throwable {
		System.out.println("This step the Email List appeared.");
		compose.composeEmail(config.getreciever());
	}

	@And("^Quit the driver$")
	public void Quit_the_Driver() throws Throwable {
		System.out.println("This step the Email List appeared.");
		driver.quit();
		driver = null;
	}

	@Given("^Open chrome for get the emails$")
	public void open_the_Chrome_and_launch_To_Get_the_Emails() throws Throwable {
		System.out.println("This Step open the chrome and launch the application.");
		driver = initializeDriver();
	}

	@When("^Navigate to gmail.com to get the emails$")
	public void enter_the_Username_and_Password__To_Get_the_Emails() throws Throwable {
		System.out.println("This step user navigate to gmail .");
		driver.navigate().to(config.geturl());
	}
	@Given("^Login RecieverEmail and Password$")
	public void TypeRecieverEmailAndPassword() throws IOException, InterruptedException {
		// PropertiesConfig();
		login.gmailLogin(config.getreciever(), config.getpasswotd());
	}

	@Then("^Open the Email with Specific title$")
	public void Open_Email_ByTitle() throws IOException, InterruptedException {
		System.out.println("This step User enters UserName and Password.");
		search.searchEmail();
	}
	@And("^Quit the driver After search$")
	public void Quit_the_Driver_After_Search() throws Throwable {
		System.out.println("This step the Email List appeared.");
		driver.quit();
		driver = null;
	}

}