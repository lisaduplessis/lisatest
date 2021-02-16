# Hotel Booking Form
An automated test script was written in Java 11 to test the creation and deletion of a booking and works as follows:			
* The setUp method loads the ChromeDriver, provides the url of the website and tells the driver to maximise the window			
* The testSaveEntry method adds the following booking and then refreshes the page.
Firstname: JohnHotelBooking
Surname: Smith
Price: 1500
Deposit: True
Check-in: 2021-09-03
Check-out: 2021-09-05		    
* The testDeleteEntry method looks for this newly added entry (by firstname) and then deletes it	


