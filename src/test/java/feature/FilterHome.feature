Feature: User Want To Filter Product

  Background: User Success To Login
    Given User In On Login Page
    When User Enter Valid Credential
    And User Click Login

  Scenario: Filter By Name(Z to A)
    When User click filter
    And User Choose Filter Name(Z to A)
    Then The Product Should sort By Name Z to A


  Scenario: Filter By Name(A to Z)
    When User click filter
    And User Choose Filter Name(A to Z)
    Then The Product Should sort By Name A to Z

  Scenario: Filter By Price(Low to High)
    When User click filter
    And User Choose Filter Price(Low to High)
    Then The Product Should sort By Price(Low to High)


  Scenario: Filter By Price(High to Low)
    When User click filter
    And User Choose Filter Price(High to Low)
    Then The Product Should sort By Price(High to Low)
