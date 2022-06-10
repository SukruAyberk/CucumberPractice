Feature: US1005 kullanici istenen satir ve sutun ile degeri yazdirabilmeli

  @guru1
  Scenario: TC05 kullanici istenen satir ve sutundaki degeri yazdirir
    Given kullanici "guruUrl" anasayfasinda
    Then IstenenSatir 1 ve IstenenSutun 1 girdiginde degerini yazdirir