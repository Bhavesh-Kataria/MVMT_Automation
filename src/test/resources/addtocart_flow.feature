Feature: User can add a product to the cart

  Scenario: User adds a watch to the cart
    Given user creates an account
    And user logs in
    When user navigates to the homepage
    And user navigates to the "Men's Watches" category
    And user selects a watch with the name "Bourbon Blue" and adds it to cart
    Then the cart should contain the product "Bourbon Blue"
