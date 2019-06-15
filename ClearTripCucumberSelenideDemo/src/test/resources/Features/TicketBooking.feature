@Book_Ticket 
Feature: Verify cleartrip page is loading and able to book the tickets. 


@sample 
Scenario Outline: Validate ticketBooking 
	Given I am on the Home Page "https://www.cleartrip.com" of cleartrip Website 
	Then I select RoundTrip radioButton 
	Then I enter <From> and <To> values 
	Then I enter <Departure> and <ReturnDate> 
	Then I select <adults> and <childs> 
	Then I click on Search Flights 
	Then I select <depart> Flight and <retur> flight to book tickets 
	Then I wait For Results to Apper on the Screen 
	Then I read departure Flights <specific> rowData 
	Then I read Return Flights <specific> rowData 
	Then I Book the Tickets 
	Then I read ItenaryDetails 
	Then I close browser
	
	
	Examples: 
		|  From    			|  To   			 |Departure 	|ReturnDate  |adults|childs|specific|depart|retur|
		| "Pune, IN - Lohegaon (PNQ)"     	| "Bangalore, IN - Kempegowda International Airport (BLR)"        |"01/07/2019"  |"12/07/2019"|"2"   |"2"   |2       |2     |2    |
		
    