Feature: Research Action
	
Scenario Outline: Successful Research
	Given User is on research page
	When User click on recherche avance
	And research with "<arg1>" and "<arg2>"
	And click on button research
	Then Page result is affiche
	
	Examples:
		| arg1 	| arg2 			|
		| Paris | Informatique 	|
