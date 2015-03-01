Feature: As a GitHub user I want to be able to sign in to my GitHub account so that I can manage my GitHub account.
	Scenario: I sign in but I do not have a GitHub account.
		Given a non-existent username
		And a non-existent password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered.
	Scenario: I sign in with an incorrect username and an incorrect password.
		Given a incorrect username
		And a incorrect password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered.
	Scenario: I sign in with an incorrect username and a correct password.
		Given a incorrect username
		And a correct password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered.
	Scenario: I sign in with an correct username and an incorrect password.
		Given a correct username
		And a incorrect password
		When I try to sign with those credentials
		Then I should receive a message stating that an "Incorrect username or password" has been entered.
	Scenario: I sign in with an correct username and an correct password
		Given a correct username
		And a correct password
		When I try to sign with those credentials
		Then I should be redirected to my GitHub account homepage. 
