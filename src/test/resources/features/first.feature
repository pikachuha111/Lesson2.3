Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простоей тест с Given
    Given open browser

  Scenario: Простой тест с Given & When
    Given open browser
    When login page is open

  Scenario: Простой тест с Given & When
    Given open browser
    When login page is open
    Then username field is display

  Scenario: Использование AND
    Given open browser
    And login page is open
    Then username field is display
    But error is not displayed