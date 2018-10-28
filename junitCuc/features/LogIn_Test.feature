Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given Open chrome 
	When  Navigate to gmail.com
	And Login with sender email and Password
	Then Compose the Email
	Then Logout 
	And Login RecieverEmail  and Password
	Then Open the Email with Specific title 
	Then Quit the driver
	
