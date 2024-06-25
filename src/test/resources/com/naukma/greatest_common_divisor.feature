Feature: Greatest Common Divisor Finder

  Scenario Outline: Finding the greatest common divisor of two numbers
    Given I have numbers <a> and <b>
    When I find the greatest common divisor
    Then the greatest common divisor should be <gcd>

  Examples:
    | a  | b  | gcd |
    | 12 | 18 | 6   |
    | 5  | 7  | 1   |
    | 6  | 8  | 2   |
    | 21 | 14 | 7   |
    | 4  | 5  | 1   |