Feature: Login and Logout Actions
	
Scenario Outline: Successful Login 
	Given User is on Login Page
	When User enters "<email>" and "<password>"
	Then User is redirect on home page
	
	Examples:
		| email							| password  |
		| benyoucef.rachel@gmail.com	| rachel123 |
#		| rachel.by						| false   	|


Scenario Outline: Successfull logout 
	Given User is connected with "<email>" and "<password>"
	When click on disconnected button
	Then User is disconnected
	
	Examples:
		| email							| password  |
		| benyoucef.rachel@gmail.com	| rachel123 |
#		| rachel.by						| false   	|
	
