@Test
Feature: Add a new resident to Skynet

  Scenario: Add resident from resident table
    Given user is on skynet health care page
    When user enters "administrator@skynethealthcare.com" and "$kyN3t"
    And user clicks on login button
    Then user navigated to dashboard
    And user clicks on "Residents" option
    And user clicks on "All" sub-option of "Residents"
    When user clicks on "New Resident" button located above the table
    Then user is taken to "Add New Resident" page
    And user enters the following data
      | Fields      | Value        |
      | First Name  | Ron          |
      | Last Name   | Well         |
      | Gender      | Male         |
      | Wearable ID | 0C61CFE95D82 |
    And user clicks on add resident button
    Then the following modal window should display "New resident has been successfully added!"
    And user clicks on "Ok" modal button
    Then user is taken to "Ron  Well" profile

  Scenario: Add resident from main menu sub-option
    Given user is on skynet health care page
    When user enters "administrator@skynethealthcare.com" and "$kyN3t"
    And user clicks on login button
    Then user navigated to dashboard
    And user clicks on "Residents" option
    And user clicks on "Add" sub-option of "Residents"
    Then user is taken to "Add New Resident" page
    And user enters the following data
      | Fields      | Value        |
      | First Name  | Ron          |
      | Last Name   | Well         |
      | Gender      | Male         |
      | Wearable ID | 0C61CFE95D82 |
    And user clicks on add resident button
    Then the following modal window should display "New resident has been successfully added!"
    And user clicks on "Ok" modal button
    Then user is taken to "Ron  Well" profile

  Scenario: Add resident with duplicate wearable id
    Given user is on skynet health care page
    When user enters "administrator@skynethealthcare.com" and "$kyN3t"
    And user clicks on login button
    Then user navigated to dashboard
    And user clicks on "Residents" option
    And user clicks on "All" sub-option of "Residents"
    When user clicks on "New Resident" button located above the table
    Then user is taken to "Add New Resident" page
    And user enters the following data
      | Fields      | Value        |
      | First Name  | Ron          |
      | Last Name   | Well         |
      | Gender      | Male         |
      | Wearable ID | 0C61CFE95D82 |
    And user clicks on add resident button
    Then the following error toast notification "The wearable id is not valid. Please enter a unique 12 character wearable id." should display

