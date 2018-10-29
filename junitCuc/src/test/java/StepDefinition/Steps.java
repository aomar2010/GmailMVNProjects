package StepDefinition;

import java.io.IOException;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import methods.crossover.com.gmail.SharedMethod;
import methods.crossover.com.gmail.propertiesFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		


public class Steps extends SharedMethod{				
	propertiesFile config=new propertiesFile(); 	

     
    @Given("^Open chrome$")				
    public void open_the_Chrome_and_launch_the_application() throws Throwable							
    {		
        System.out.println("This Step open the chrome and launch the application.");
        driver = initializeDriver();
    }		

    @When("^Navigate to gmail.com$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {		
       System.out.println("This step user navigate to gmail .");
       driver.navigate().to(config.geturl());
    }		

    @And("^Login with sender email and Password$")					
    public void TypeUsernameAndPassword()  throws IOException, InterruptedException 							
    {    		
        System.out.println("This step User enters UserName and Password.");
        logMeIn(config.getsender(), config.getpasswotd());
       
    }	
    @Then("^Compose the Email$")					
    public void Compuse_EMail() throws Throwable 							
    {    		
        System.out.println("This step the Email List appeared.");
        composeEmail(config.getreciever());
    }	
    
    @Then("^Logout$")					
    public void Logout() throws Throwable 							
    {    		
        System.out.println("This step the Email List appeared.");
        logMeOut();
    }
       
    @Given ("^Login RecieverEmail  and Password$")					
    public void TypeRecieverEmailAndPassword()  throws IOException, InterruptedException 							
    {   	
    	// PropertiesConfig();
        System.out.println("This step User enters UserName and Password.");
        logMeIn(config.getreciever(), config.getpasswotd());
    }	
    
    @Then("^Open the Email with Specific title$")					
    public void Open_Email_ByTitle()  throws IOException, InterruptedException 							
    {    		
        System.out.println("This step User enters UserName and Password.");
        searchEmail();
    }
    @And("^Quit the driver$")					
    public void Quit_the_Driver() throws Throwable 							
    {    		
        System.out.println("This step the Email List appeared.");
        driver.quit();
		driver = null;
    }

}