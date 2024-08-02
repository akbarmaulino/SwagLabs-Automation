@LoginFeature
Feature: Login Feature

    Scenario: User Login With Valid Credential
        Given User In On Login Page
        When User Enter Valid Credential
        And User Click Login
        Then User Navigate To Homepage Menu

    Scenario Outline: User Failed Login
        Given User In On Login Page
        When User Enters <username> and <password>
        And User Click Login
        Then User Should Get <outcome>

        Examples:
            | username          | password      | outcome                                                                   |
            | locked_out_user   | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                       |
            | standard_user     | secret        | Epic sadface: Username and password do not match any user in this service |
            | standard_user     | [empty]       | Epic sadface: Password is required                                        |
            | [empty]           | secret_sauce  | Epic sadface: Username is required                                        |
            | [empty]           | [empty]       | Epic sadface: Username is required                                        |










