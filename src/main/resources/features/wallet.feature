Feature: Wallet

  Scenario: taking out dollars from my wallet
    Given I have 42 dollar in my wallet
    When I take out 5 dollar
    Then my wallet should have 37 dollar

