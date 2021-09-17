Feature: User Registeration
	I want to check that the user can register in our e-commerce website.
	
	
	Scenario Outline: User Registeration 
	Given the user in the homepage 
	When I click on register link
	And I entered the "<firstname>", "<lastname>", "<email>", "<password>"
	Then The registeration page displayed successfully

	Examples:
	| firstname | lastname | email | password |
	| Islam | hassan | aa@gmail.com | 123456789 |
	| hossam | hesham | gg@gmail.com | 123456889 |


