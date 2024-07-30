@LoginFeature
Feature: Login Feature

    Scenario: User Login With Valid Credential
        Given User In On Login Page
        When User Enter Valid Credential
        And User Click Login
        Then User Navigate To Homepage Menu

    Scenario: User Login With Lock Account
        Given User In On Login Page
        When User Enter Lock Account
        And User Click Login
        Then User Get Error Message



