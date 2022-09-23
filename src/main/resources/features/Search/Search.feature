Feature: Search 

@TEST-0003
Scenario: user is able to search
Given user navigates to the website javatpoint.com
And there user logs in through Login Window by using Username as "SREEJITH" and Password as "PASSWORD"
Then login must be successful

@TEST-0004
Scenario: user is not able to search
Given user navigates to the website javatpoint.com
And there user logs in through Login Window by using Username as "SREEJITH" and Password as "PASSWORD"
Then login must be successful