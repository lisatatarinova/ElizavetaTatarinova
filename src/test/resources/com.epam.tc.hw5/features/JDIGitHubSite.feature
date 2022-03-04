Feature: Tests for JDI GitHub site in the Homework 5 scope

  Scenario: Different Elements Page items logs test
    Given I open JDI GitHub site 'https://jdi-testing.github.io/jdi-light/index.html'
    And I login as user with username = 'Roman' and password = 'Jdi1234'
    When I open through the header menu 'SERVICE' -> 'DIFFERENT ELEMENTS'
    And Select item 'Water'
    And Select item 'Wind'
    And Select item 'Selen'
    And Select in dropdown 'Yellow'
    Then Log rows are displayed
    And 'Checkbox' name = 'Water' and its status = 'true' are corresponding to selected
    And 'Checkbox' name = 'Wind' and its status = 'true' are corresponding to selected
    And 'Radio button' name = 'metal' and its status = 'Selen' are corresponding to selected
    And 'Dropdown' name = 'Colors' and its status = 'Yellow' are corresponding to selected

  Scenario: User Table Page test
    Given I open JDI GitHub site 'https://jdi-testing.github.io/jdi-light/index.html'
    And I login as user with username = 'Roman' and password = 'Jdi1234'
    When I open through the header menu 'SERVICE' -> 'USER TABLE'
    Then User Table page should be opened
    And '6' 'Dropdowns' should be displayed on Users Table on User Table Page
    And '6' 'Usernames' should be displayed on Users Table on User Table Page
    And '6' 'Description texts under images' should be displayed on Users Table on User Table Page
    And '6' 'Checkboxes' should be displayed on Users Table on User Table Page
    And User table should contain following values
      | Number | User             | Description                      |
      | 1      | Roman            | Wolverine                        |
      | 2      | Sergey Ivan      | Spider Man                       |
      | 3      | Vladzimir        | Punisher                         |
      | 4      | Helen Bennett    | Captain America some description |
      | 5      | Yoshi Tannamuri  | Cyclope some description         |
      | 6      | Giovanni Rovelli | Hulk some description            |
    And DropList should contain values in column Type for user Roman
      | Dropdown Values |
      | Admin           |
      | User            |
      | Manager         |

  Scenario: Log for 'vip' checkbox in the 'User Table' test
    Given I open JDI GitHub site 'https://jdi-testing.github.io/jdi-light/index.html'
    And I login as user with username = 'Roman' and password = 'Jdi1234'
    When I open through the header menu 'SERVICE' -> 'USER TABLE'
    When I select Vip checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section
