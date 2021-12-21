Feature: API Demo Flows related to Animation

  @apiDemo @apiDemo_defaultlayoutanimations @1
  Scenario: Verify the default layout animations screen of API Demo application
    Given I launch the app and verify I am on Landing screen
    Then I verify the icons in the landing screen
    When I navigate to "Animation" screen
    Then I should be landed successfully on "Animation" screen
    When I navigate to "Default Layout Animations" screen
    Then I should be landed successfully on "Default Layout Animations" screen
    When I tap add button "4" times
    Then I should see "4" buttons displayed