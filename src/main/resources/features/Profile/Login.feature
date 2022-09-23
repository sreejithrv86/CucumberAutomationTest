Feature: Login 

@TEST-0001
Scenario: User sign in successfully
Given user navigates to the website javatpoint.com
And there user logs in through Login Window by using Username as "SREEJITH" and Password as "PASSWORD"
Then login must be successful

@TEST-0002
Scenario: User unable to sign in
Given user navigates to the website javatpoint.com
And there user logs in through Login Window by using Username as "SREEJITH" and Password as "PASSWORD"
Then login must be successful