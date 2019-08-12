Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Title of your scenario outline
    Given User launch the broser
    When User add the cust details"<fname>","<lname>","<email>","<address>","<phno>"
    And User tarrif details
    Then User validate outcomes

    Examples: 
      | fname   | lname  | email             | address  | phno       |
      | Thulasi | Rithu  | tulsi@gmail.com   | Palagat  | 9790956304 |
      | Parveen | Dinesh | parveen@gmail.com | Ariyalur |  9406553659 |
      | Raveena | Sutha  | ravi@gmail.com    | Chennai  | 9841635269 |
      | Priya   | Lalith | priya@gmail.com   | Chicago  |  9632595563 |