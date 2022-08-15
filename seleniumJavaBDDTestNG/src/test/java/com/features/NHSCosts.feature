Feature: UK Test Ticket 

@NHSCosts 
Scenario Outline: Verify UK Test Ticket Using NHS Costs Checker Tool with livingCountry as <livingCountry> and Savings as <Savings>
	Given I am a citizen of the UK 
	When I put my circumstances into the Checker tool with Inputs "<livingCountry>","<doYouLiveWithPartner>","<taxCredits>","<Savings>" 
	Then I should get a result of whether I will get help or not 
	
	Examples: 
		|livingCountry|doYouLiveWithPartner|taxCredits|Savings|
		|England|No|No|No|
		|England|Yes|No|Yes|
		
		
    