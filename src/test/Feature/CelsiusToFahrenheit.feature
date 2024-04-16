Feature: Validate the tempconvert values
 @Celsius
  Scenario Outline: Convert Celsius To Fahrenheit
    Given user enter the Celsius value "<Celsius>"
    Then user create the conversion request body
    When user hit a post call "<url>"
    And user see the status code as "<Status code>"
    And user see the CelsiusToFahrenheitResult value "<CelsiusToFahrenheitResult>"

    Examples:
      | Celsius | url                                            | Status code | CelsiusToFahrenheitResult |
      | 10      | https://www.w3schools.com/xml/tempconvert.asmx | 200         | 50                        |

