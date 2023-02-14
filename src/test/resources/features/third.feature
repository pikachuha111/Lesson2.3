Feature: Use a background

  Rule: правило 1

    Background:
      Given browser is open
      * login page is open

    Scenario: Использоваение чего-то 1
      Given  user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

    Scenario: Использоваение чего-то 2
      Given  user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

  Rule: правило 2

    Background:
      Given browser is open
      * login page is open

    Scenario: Использоваение чего-то 1
      Given  user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in

    Scenario: Использоваение чего-то 2
      Given  user "atrostyanko@gmail.com" with password "Qwertyu_1" logged in