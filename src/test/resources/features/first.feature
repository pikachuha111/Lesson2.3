Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простоей тест с Given
    Given browser is open

  Scenario: Простой тест с Given & When
    Given browser is open
    When login page is open

  Scenario: Простой тест с Given & When
    Given browser is open
    When login page is open
    Then username field is display

  Scenario: Использование AND
    Given browser is open
    And login page is open
    Then username field is display
    But error is not displayed