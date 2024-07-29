@LoginFeature
Feature: Login Feature

Scenario: : User Success To Login
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login
    Then User Navigate To Homepage Menu

#  Scenario Outline: Check User Want To Login With Valid Credential
#    Given User In On Login Page
#    When User Enter Valid <Email> and <Password>
#    And User Click Login
#    Then User Navigate To Homepage Menu
#
#    Examples:
#    | Email | Password |
#    | standard_user | secret_sauce |
#    | problem_user | secret_sauce |

