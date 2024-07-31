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
    And User Should Receive <Expected Message> or Navigate To <Expected Page URL>


    Examples:
      | First Name | Last Name | Postal Code | Expected Message               | Expected Page URL                                |
      | Source     | Demo      | 00000       | Success                        | https://www.saucedemo.com/checkout-step-two.html |
      | Source     |           | 00000       | Error: Last Name is required   |                                                |
      | Source     | Demo      |             | Error: Postal Code is required |                                                |
      |            | Demo      | 00000       | Error: First Name is required  |                                                |

