Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Title of your scenario
    Given User want to launch the browser
    When User click add the customer
      | fname   | Thualsi           |
      | lname   | Rithun            |
      | email   | thulasi@gmail.com |
      | address | Chennai           |
      | phno    |        9790956304 |
    And User click the add tariff
      | customerID |
    Then User validate the CustID
