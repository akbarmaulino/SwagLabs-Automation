Feature: Testing SauceDemo Website Functionality

  Background: User Success To Login
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login

  Scenario: Add Product to Cart

    When I add a product to my cart
    Then The Product Should Appear In My Cart
    And My Chart Give Item Count