package app.crossover.com.gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {
	public static void main(String[] args) {
    // TODO Auto-generated method stub
    // Initialize WebDriver
    WebDriver driver = new FirefoxDriver();

    // Maximize Window
   driver.manage().window().maximize();
  
    // Wait For Page To Load
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

   //Navigate to Google webstites
   driver.get("https://www.gmail.com");
/*CASE- 1. Both User name and Password are entered correctly. 
Check whether Email field exists or not */
    try
        {
          WebElement a1 = driver.findElement(By.xpath("//*[@id='Email']"));
          System.out.println("---------Emaild exists --------------\n-----------------------");
          a1.sendKeys("ENTER CORRECT MAIL ID");
         }
    catch(Throwable e)
         {
         System.out.println("Emaild not found: " + e.getMessage());
         }

    //Check whether Password field exists or not
     try
        {
	 WebElement password = driver.findElement(By.xpath("//*[@id='Passwd']"));
         System.out.println("----------Passwordd exits ------------\n-----------------------");
         password.sendKeys("ENTER CORRECT PASSWORD");
        }
    catch(Throwable e)
        {
	 System.out.println("Passwordd not found: " + e.getMessage());
        }

     //Asserting the Sign In button exists or not and clicking it
    try
       {
	WebElement button = driver.findElement(By.id("signIn"));
	System.out.println("-------Signutton exists----------\n-----------------------");
       //To uncheck the "Check sign in" checkbox
       WebElement check_stay_sign_in = driver.findElement(By.xpath("//*[@id='PersistentCookie']"));
        check_stay_sign_in.click();   
	button.click();
        }
    catch(Throwable e)
        {
	System.out.println("Signutton not found: "+ e.getMessage());
        }
    //Check if login was proper or not
    try
        {
	WebElement GmailText = driver.findElement(By.xpath("//*[@id=':36']"));
        String text = GmailText.getText();
        if(text.equals("Primary"))
       {
	System.out.println("----------Sucessfuln -------\n-----------------------");
       }else
       {
	System.out.println("----------Loginure ----------\n-----------------------");
	}
       }
     catch(Throwable e)
        {
	 System.out.println("Inbox not found: "+e.getMessage());
        }
    //===
    //Asserting and click on the Account link which contain Signout button.
     try
        {
	WebElement person = driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[5]/div[1]/a/span"));
        System.out.println("--------Theunt link containing Signout button exists ---------\n-----------------------");
	person.click();
       }
    catch(Throwable e)
       {
	System.out.println("Linkthe drop-down not found: "+e.getMessage());
        }


    //Asserting and clicking on the Signout button.
    try
       {	
	WebElement signout = driver.findElement(By.xpath("//*[@id='gb_71']"));
        System.out.println("--------Signbutton exists  ---------\n-----------------------");
	signout.click();
        }
    catch(Throwable e)
        {
	System.out.println("Signbutton not found: "+e.getMessage());
        }

    //Check whether Signout was proper or not.
    try
       {	
       WebElement GmailText = driver.findElement(By.xpath("//divss = 'banner']/h1"));
       String text = GmailText.getText();
       if(text.equals("One account. All of Google."))
       {
       System.out.println("----------Signwas successful -------");
       }
     else
       {
        System.out.println("----------Signwasn't successful ----------");
	}
        }

    catch(Throwable e)
        {
	System.out.println("Signlink not found: "+e.getMessage());
        }


    // CASE- 2. Both Email and Password Fields are blank.
    try
        {
	WebElement button = driver.findElement(By.id("signInbutton"));
	button.click();
WebElement GmailText = driver.findElement(By.xpath("//*[@id=':36']"));
String text = GmailText.getText();
if(text.equals("Primary"))
{
   System.out.println("----------Sucessfuln -------");
}
else
{
	System.out.println("----------Loginure ----------");
		}
		
}
catch(Throwable e)
{
		System.out.println("Erroril and Password fields are blank. \n----------------------- ");
System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
  }
/*

// CASE- 3. Email field is filled and Password field is blank
try
{		
		WebElement email = driver.findElement(By.id("Emailemail"));email.sendKeys("abcd123@gmail.com");
 driver.findElement(By.id("signInbutton")).click();


WebElement GmailText = driver.findElement(By.xpath("//*[@id=':36']"));
String text = GmailText.getText();
if(text.equals("Primary"))
{
System.out.println("----------Sucessfuln -------\n-----------------------");
}
else
{
System.out.println("----------Loginure ----------\n-----------------------");
		}
		
 }
catch(Throwable e)
 {
		System.out.println("Errorsword field is blank. \n-----------------------");
System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
 }	

driver.findElement(By.id("Email")).clear();


// CASE- 4. Email field is blank and Password field is filled

try
{		
		 driver.findElement(By.id("Passwdpassword")).sendKeys("ENTER PASSWORD");
driver.findElement(By.id("signInbutton")).click();


 driver.findElement(By.xpath("//*[@id=':36']"));
String text = GmailText.getText();
if(text.equals("Primary"))
{
System.out.println("----------Sucessfuln -------");
}
else
{
System.out.println("----------Loginure ----------");
		}
			
}
catch(Throwable e)
{
    	System.out.println("Erroril field is blank. \n-----------------------");
System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
 }
  
driver.findElement(By.id("Passwd")).clear();

/*
//CASE- 5. Email and Password are entered wrong 	

try
{
		 WebElement email = driver.findElement(By.id("Email email.sendKeys("ENTER INCORRECT MAIL ID");
 WebElement password = driver.findElement(By.id("Passwd password.sendKeys("ENTER INCORRECT PASSWORD");
 WebElement button = driver.findElement(By.id("signIn button.click();
 
 WebElement GmailText = driver.findElement(By.xpath("//*[@id=':36']"));
 String text = GmailText.getText();
 if(text.equals("Primary"))
 {
 System.out.println("----------Sucessfuln -------");
 }
 else
 {
 System.out.println("----------Loginure ----------");
		 }
		 
  }
catch(Throwable e)
{
	
	  System.out.println("Errororrect Email and Password. \n-----------------------");		  
  System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
}
 
driver.findElement(By.id("Email")).clearlearing the Email field
driver.findElement(By.id("Passwd")).clearlearing the Password field
		
	
 // CASE- 6. Email is wrong and Password is correct 	
 try 
 {
	 
		WebElement email = driver.findElement(By.id("Emailemail.sendKeys("ENTER INCORRECT EMAIL ID");
WebElement password = driver.findElement(By.id("Passwdpassword.sendKeys("ENTER CORRECT PASSWORD");
WebElement button = driver.findElement(By.id("signInbutton.click();
WebElement Inbox = driver.findElement(By.xpath("//*[@id=':53']/div/div[1]/span/a"));
if(Inbox != null) 
{
System.out.println("Sucessfuln \n -----------------");
} 
else 
{
System.out.println("Loginure");
		}
  } 
 catch(Throwable e) 
 {
	  
	  System.out.println("Errororrect Email. \n-----------------------");
  System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
  }
 
  driver.findElement(By.id("Email")).clearlearing the Email field
  driver.findElement(By.id("Passwd")).clearlearing the Password field
  
  
//CASE- 7. Email is correct and Password is wrong 	
 try
 {
		 WebElement email = driver.findElement(By.id("Email email.sendKeys("ENTER CORRECT EMAIL ID");
 WebElement password = driver.findElement(By.id("Passwd password.sendKeys("ENTER INCORRECT PASSWORD");
 WebElement button = driver.findElement(By.id("signIn	 button.click();
	 
 
	 WebElement GmailText = driver.findElement(By.xpath("//*[@id=':36']"));
 String text = GmailText.getText();
 if(text.equals("Primary"))
 {
 System.out.println("----------Sucessfuln -------");
 } 
 else
 {
 System.out.println("----------Loginure ----------");
			}
  }
 catch(Throwable e)
 {
	   System.out.println("Errororrect Password. \n-----------------------");			  
   System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
  }

  driver.findElement(By.id("Email")).clearlearing the Email field
  driver.findElement(By.id("Passwd")).clearlearing the Password field
*/
//closing current driver window	
		driver.close();
		
	}

}
