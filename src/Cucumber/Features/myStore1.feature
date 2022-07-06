Feature: Add new address

  Scenario Outline: Login and add new address
    Given I am at the mystore page and have created user account
    When I sign in using mail: mmaciekk111@gmail.com and password: 1234kurs1234
    And Add new address by click at the Addresses tile and then link to createNewAddress
    And Fill new address form alias: <alias>
    And Fill first name: <First name>
    And Fill last name: <Last name>
    And Fill address: <Address>
    And Fill city: <City>
    And Fill zip code: <zip code>
    And Fill phone number: <phone number>
    And Save the new address
    Then Find proper tile with new address by alias, and compare data of <alias>, <First name>, <Last name>, <Address>, <City>, <zip code>, <country>, <phone number>


    Examples:
      | alias    | First name | Last name | Address | City   | zip code | country        | phone number |
      | test1234 | Smok       | Wawelski  | Wawel   | Krakow | 31-001   | United Kingdom | 512345687    |