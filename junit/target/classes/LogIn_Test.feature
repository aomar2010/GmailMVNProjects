Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given User is on http://gmail.com
	When User Navigate to LogIn Page
	And User enters UserName and Password
	Then Email Lists appeared 
