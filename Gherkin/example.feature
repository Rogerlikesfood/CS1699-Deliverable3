Feature: Password management
  Scenario: Forgot password
    Given a user with email "cukes@cukes.info" exists
    When I ask for a password reset
    Then an email with a password reset link should be sent