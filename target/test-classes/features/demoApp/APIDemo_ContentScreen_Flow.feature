Feature: API Demo Flows related to Content

  @apiDemo @apiDemo_layoutreference @2
  Scenario: Verify the layout reference screen of API Demo application
    Given I launch the app and verify I am on Landing screen
    Then I verify the icons in the landing screen
    When I navigate to "Content" screen
    Then I should be landed successfully on "Content" screen
    When I navigate to "Resources" screen
    Then I should be landed successfully on "Resources" screen
    When I navigate to "Layout Reference" screen
    Then I should be landed successfully on "Layout Reference" screen

  @apiDemo @apiDemo_readassets
  Scenario: Verify the Read asset screen of API Demo application
    Given I launch the app and verify I am on Landing screen
    Then I verify the icons in the landing screen
    When I navigate to "Content" screen
    Then I should be landed successfully on "Content" screen
    When I navigate to "Assets" screen
    Then I should be landed successfully on "Assets" screen
    When I navigate to "Read Asset" screen
    Then I should be landed successfully on "Read Asset" screen