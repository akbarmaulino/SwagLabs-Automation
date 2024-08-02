@Payment
Feature: User Want To Finish Payment

  Background: User Success To Login and Success To Add Product To Chart
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login
    When User add a product to my cart
    Then The Product Should Appear In My Cart
    And My Chart Give Item Count

  Scenario Outline: User Success To Payment
    Given User Click Checkout
    And User Navigate To Payment Page
    When User Enter <First Name> <Last Name> and <Postal Code>
    And User Click Continue
    And User Navigate To Checkout Overview
    Then User Click Finish
    And User Should Navigate To Complete Checkout Menu


    Examples:
      | First Name | Last Name | Postal Code |
      | Source     | Demo      | 00000       |


  Scenario Outline: User Failed To Payment
    Given User Click Checkout
    And User Navigate To Payment Page
    When User Enter <First Name> <Last Name> and <Postal Code>
    And User Click Continue
    Then User Should Get <outcome> In Payment Page


    Examples:
      | First Name  | Last Name     | Postal Code | outcome                         |
      | [empty]     | secret_sauce  | 00000       | Error: First Name is required   |
      | Source      | [empty]       | 00000       | Error: Last Name is required    |
      | Source      | secret_sauce  | [empty]     | Error: Postal Code is required  |
      | [empty]     | [empty]       | [empty]     | Error: First Name is required   |


