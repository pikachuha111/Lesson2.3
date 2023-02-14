Feature: Проблемы простого огурца

  Scenario: Использоваение разные defs файлов
    Given browser is open
    * login page is open
    * user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in
    Then open settings page