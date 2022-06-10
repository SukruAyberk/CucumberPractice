Feature: US1006 kullanici liste alabilmeli

  Scenario: TC06 kullanici liste alabilmeli
    Given kullanici "guruUrl" anasayfasinda
    Then "Company" listesini yazdirir
    And "Company" listesinde "DCB Bank" oldugunu test eder