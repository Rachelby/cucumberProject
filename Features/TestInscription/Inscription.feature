Feature: Inscription on website
	
Scenario Outline: Inscription Succes
	Given User is on inscription page
	When User tape "<email>" and "<password>" and "<confirmPassword>"
	Then User is redirect to confirm page
		Examples:
		| email 				| password 	| confirmPassword 	|
#		| rachel.by@gmail.com 	| rachel123 | rachel123 		|
#		| test@gmail.com 		| rachel123 | rachel123 		|
		| test1@gmail.com 		| rachel123 | rachel123 		|