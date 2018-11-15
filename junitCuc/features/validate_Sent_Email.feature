Feature: Test Send and recieve emails feature 
Description: Compose new email with attachmnets and then vaidate the email recieved 


Scenario: Login and compose email with attached file 
	Given Open chrome 
	When  Navigate to gmail.com
	And Login with sender email and Password
	Then Compose the Email
	And Quit the driver

	
Scenario: Login and compose email with attached file 

	
	Given Open chrome for get the emails
	When Navigate to gmail.com to get the emails
	Then Login RecieverEmail and Password
	And Open the Email with Specific title 
	Then Quit the driver After search
	
