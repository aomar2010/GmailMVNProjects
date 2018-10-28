Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given Open chrome 
	When  Navigate to gmail.com
	And Login UserName and Password
	Then Compose the Email
	Then Quit the driver
	Then Navigate to gmail.com
	And Login RecieverEmail  and Password
	Then Open the Email with Specific title 
	And Validate the content 
	Then Quit the driver
	
