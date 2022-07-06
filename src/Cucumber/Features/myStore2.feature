
Feature: Buy things
  Scenario: Login buy things and get screenshot
    Given I am at the mystore page, have account and press the sign in
    When I sign in using mail mmaciekk111@gmail.com, password 1234kurs1234
    And Go to clothes page and choose Hummingbird Printed Sweater
    And Check discount calculation, set size to M, set quantity to 5, add to cart
    And Confirm address, choose payment Pay by Check, order with obligation to pay, take screenshot
    Then Check header of confirmation page