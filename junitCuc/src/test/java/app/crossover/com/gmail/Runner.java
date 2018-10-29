package app.crossover.com.gmail;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features= {".\\features\\validate_Sent_Email.feature"},glue={"StepDefinition"})						
public class Runner 				
{		

}
