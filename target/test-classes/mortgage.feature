Feature: Mortgage
  In order to get a mortgage
  As a member of the public
  I want to see what is available

  @mytag
  Scenario Outline: How much can First Time Buyer borrow
    Given I have navigated to the mortgage page
    When I select a mortgage reason of "<Mortgage Reason>"
    And I enter "<Location>", "<Number of Applicants>", "<Number of Dependants>","<Annual Income>","<Annual Bonus>" and "<Monthly Debt>"
    And I click on calculate how much I can borrow button
    Then the offer amount should be "<Offer Amount>"
    Examples:
      |Mortgage Reason  |Location |Number of Applicants|Annual Income|Number of Dependants |Annual Bonus  |Monthly Debt |Offer Amount |
      |First time buyers|Scotland |1                   |30000        |2                    |2000          |500          |86,020     |
      |First time buyers|Wales    |1                   |40000        |3                    |0             |200          |179,600      |

  @mytag
  Scenario Outline: Are there any mortgages for first time buyer with these figures
    Given I have navigated to the mortgage page
    When I select a mortgage reason of "<Mortgage Reason>"
    And I click on the Find a Mortgage tab
    And I enter "<Customer Type>", "<Amount of Deposit>","<Property Value>", and "<Repayment Term>" in the find a mortgage tab
    And I click on the calculate find a mortgage button
    Then The number of products is greater than zero
    Examples:
      | Mortgage Reason   | Customer Type    | Amount of Deposit	| Property Value | Repayment Term	|
      | First time buyers | a-first-time-buyer | 25000				| 100000         | 20				|
      | First time buyers | a-first-time-buyer | 50000				| 200000         | 15				|
