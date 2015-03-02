Feature: As a GitHub user 
         I want to be able to sign in to my GitHub account 
         So that I can manage my GitHub account
	Scenario: I sign in but I do not have a GitHub account
		When I try to sign in without a username and without a password
		Then I should receive a message stating that an "Incorrect username or password" has been entered
	Scenario: I sign in with an incorrect username and an incorrect password
		Given an incorrect username
		And an incorrect password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered
	Scenario: I sign in with an incorrect username and a correct password
		Given an incorrect username
		And a correct password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered
	Scenario: I sign in with a correct username and an incorrect password
		Given a correct username
		And an incorrect password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered
	Scenario: I sign in with a correct username and a correct password
		Given a correct username
		And a correct password
		When I try to sign with those credentials
		Then I should be signed into my GitHub account
