Feature: Test Send and recieve emails feature 
Description: Compose new email with attachmnets and then vaidate the email recieved 


Scenario: Login and compose email with attached file 
	Given Open chrome 
	When  Navigate to gmail.com
	And Login with sender email and Password
	Then Compose the Email
	Then Logout 
	
Scenario: Login and compose email with attached file 
	
	Given Login RecieverEmail  and Password
	Then Open the Email with Specific title 
	And Quit the driver
	
