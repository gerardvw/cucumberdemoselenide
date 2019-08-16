Feature: search

    Background:
        Given homepage is opened

    @chrome @ie
    Scenario Outline: search for item in searchbox
    When I search for <searchterm>
    And I choose to view the search results for being viewed in a list
    Then I should see an item with description <description> and a price of <price> and availability <availability>
    And it should be possible to add this item to my cart

    Examples:
    | searchterm    | description                 | price   | availability |
    | t-shirts      | Faded Short Sleeve T-shirts | $16.51  | In stock     |
    | printed dress | Printed Dress               | $50.99  | In stock     |



