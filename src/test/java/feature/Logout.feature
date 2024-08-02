@LogoutFeature

Feature: Login Feature



  Background: User Success To Login
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login
    Then User Navigate To Homepage Menu

  Scenario: User Logout
    When User Click Button Burger Menu
    And User Click Logout
    Then User Navigate To Login Page



