Feature: Smoke

  @mercadolibre
  Scenario: Exercise
    Given Enter the website
    Then Select Mexico as a country
    Then Search for the term playstation 5
    Then Filter by condition Nuevos
    Then Filter by location Cdmx
    Then Order by mayor a menor precio
    Then Obtain the name and the price of the first 5 products
    Then Print these products in the console