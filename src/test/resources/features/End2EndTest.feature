Feature: End2EndTest

  Scenario: successful purchase

    Given user has logged in
    * add item to cart "add-to-cart-sauce-labs-onesie"
    * navigate to cart page
    * press Checkout button
    * fill required fields "Nikita" "Solovev" "220070"
    * press continue button
    * press finish button
    When press backToHome button
    Then product page is open
