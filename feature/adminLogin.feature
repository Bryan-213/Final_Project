Feature: Admin Login

  Scenario: Valid admin login
    Given the admin is on the HRMS login page
    When the admin enters valid username and password
    And clicks the login button
    Then the admin should be successfully logged in

  Scenario: Invalid admin login
    Given the admin is on the HRMS login page
    When the admin enters invalid username and password
    And clicks the login button
    Then an error message should be displayed

  Scenario: Invalid login with correct username and wrong password
    Given the admin is on the HRMS login page
    When the admin enters correct username and wrong password
    And clicks the login button
    Then an error message should be displayed
