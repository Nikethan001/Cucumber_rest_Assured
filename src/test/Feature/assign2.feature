Feature: Validate the POST call
@Macbook
  Scenario Outline: DO user post request validation
    Given User provide the name "<Name>" and "<Year>" and "<Price>"
    Then User create a conversion request body.
    When User send a post call "<url>"
    And User validate the status code "<status code>"
    And User validate the year "<year>"
    And User validate the price  "<price>"
    And User validate the created date should not null

    Examples:
      | Name                 | Year | Price   | url                                  | status code | year | price   |
      | Apple MacBook Pro 16 | 2019 | 1849.99 | https://api.restful-api.dev//objects | 200         | 2019 | 1849.99 |