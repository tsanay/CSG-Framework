@Test
Feature: Update an existing resident

  Scenario: Update resident's information
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
    And user clicks on Edit Profile button
    Then user is taken to "Edit Resident" page
    And user enters the following data
      | Fields      | Value        |
      | First Name  | Ronald       |
      | Last Name   | Wells        |
      | Gender      | Male         |
      | Wearable ID | 0C61CFE95D82 |
    And user clicks on edit resident button
    Then user is taken to "Ronald  Wells" profile

  Scenario: Search a resident and update its information
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
    And user clicks on "Residents" option
    And user clicks on "All" sub-option of "Residents"
    Then user writes the following name "Ron Well" in the search box
    And user clicks on the pencil icon next to "Ron Well" label
    Then user is taken to "Edit Resident" page
    And user enters the following data
      | Fields      | Value        |
      | First Name  | Ronald       |
      | Last Name   | Wells        |
      | Gender      | Male         |
      | Wearable ID | 0C61CFE95D82 |
    And user clicks on edit resident button
    Then user is taken to "Ronald  Wells" profile

