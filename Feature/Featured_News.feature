Feature: Featured_news
Scenario: Featured_news
Given start the browser
       When BeCognizant page is visible
       And click on user info button
       Then validate user details
       When get the featured news headers
       Then validate image and headers
       And validate the toolTip
       When click on news page
       Then validate the news items
       When BeCognizant page is visible again
       Then close the browser

