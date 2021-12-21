Feature: API Demo Flows related to Preferences

  @apiDemo @apiDemo_preference
  Scenario: Verify the default values in Preferences screen of API Demo application
    Given I launch the app and verify I am on Landing screen
    Then I verify the icons in the landing screen
    When I navigate to "Preference" screen
    Then I should be landed successfully on "Preference" screen
    When I navigate to "Default Values" screen
    Then I should be landed successfully on "Default values" screen
    And I verify the checbox preference is "checked"
    When I tap the checkbox preference
    Then I verify the checbox preference is "unchecked"
    When I tap edit text preference
    Then I verify "Enter favourite Animal" panel is shown
    When I enter a favourite animal
    Then I verify the the favourite animal is entered
    When I tap List preference
    Then I verify "Choose one" panel is shown
    When I select the preferred option in the List preference
    Then I verify the preferred option is selected in the List preference