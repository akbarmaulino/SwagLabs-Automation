Feature: User Want To Add/Remove Product

  Background: User Success To Login
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login

  Scenario: Add Product to Cart

    When User add a product to my cart
    Then The Product Should Appear In My Cart
    And My Chart Give Item Count

  Scenario: Remove Product From Cart
    When User add a product to my cart
    And User Add a second product to my cart
    And  User Remove Product
    Then My Chart Give Item Count