Feature: iCapEquity feature file

  @iCapEquity @iCapEquity_AddFund
  Scenario Outline: Add Fund
    Given user opens application
    When user enters userName and password
    And user signs in
    And user clicks on Subscription number '<subscriptionNumber>' link
    And user clicks on Add Funds Button
    And user selects bank account '<bankAccount>'
    And user enters amount '<amount>'
    And user clicks on submit Button
    And user clicks on confirm Button
    And user signs out
    #When user opens dwolla application
    #When user enters userName and password for dwolla
    #And user signs in for dwolla
    
    Examples: 
      | subscriptionNumber | bankAccount                     | amount |
      | S-002500           | bhargavi542 (SANDBOX TEST BANK) |     20 |
