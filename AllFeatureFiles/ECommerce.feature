Feature: Validate Mobile Purchase Flow on Amazon

  @iPhone
  Scenario: Verify user can search, add iPhone 17 Pro to cart and reach secure checkout page
    Given user is on Amazon home page
    When search "Apple iPhone 17 Pro 512 GB" mobile in search bar
    And select if contains "Silver" in text
    And capture the price and check the "iPhone 17 Pro" text is contains in the description or not
    And add mobile to cart
    And click on Proceed to Buy button
    And enter mobile number as username to login amazon page and click on continue button
    And Enter password as user amazon login password
    Then user should be navigated to secure checkout page and user captures "Secure checkout" text and verifies useThisPaymentMethod button is displayed and if the selected item is not available from the selected seller, the flow of testing is finished and verify "This Item is currently unavailable" text

  @Samsung
  Scenario: Verify user can search, add Galaxy S25 Edge 5G AI Smartphone to cart and reach secure checkout page
    Given user is on Amazon home page for Samsung
    When search "Galaxy S25 Edge 5G AI Smartphone" mobile in search bar for Samsung
    And select if contains "Galaxy S25 Edge 5G AI Smartphone (Titanium Silver," in text for Samsung
    And capture the price and check the "Galaxy S25 Edge 5G AI Smartphone" text is contains in the description or not for Samsung
    And add samsung mobile to cart
    And click on Proceed to Buy samsung
    And enter mobile number as username to login amazon page and click on continue button for samsung
    And Enter password as user amazon login password to login
    Then user should be navigated to secure checkout page and user captures "Secure checkout" text and verifies useThisPaymentMethod button is displayed and if the selected item is not available from the selected seller, the flow of testing is finished of samsung and verify "This Item is currently unavailable" text
