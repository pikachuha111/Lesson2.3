Feature: Параметризированные тесы

  Scenario: Параметризация степов
    Given open browser
    * login page is open
    When user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in
    Then title is "All Projects"
    And project id is 123

  Scenario Outline: Параметризация при помощи таблицы значений
    Given open browser
    * login page is open
    When user "<username>" with password "<password>" logged in
    Then title is "All Projects"
    And project id is <age>
    Examples:
      | username                 | password      | age |
      | atrostyanko@gmail.com    | Qwertyu_1     | 123 |
      | atrostyanko@gmailasdfcom | sdfsafsdfasdf | 111 |
