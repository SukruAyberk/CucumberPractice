Feature: US1002 kullanici sayfada hesap olusturabilmeli

  @aptest
  Scenario: TC02 kullanici hesap olusturabilmeli
    Given kullanici "apUrl" anasayfasinda
    Then kullanici singine tiklar
    And kullanici create account bolumune email adresi girer
    And kullanici create an account butonuna basar
    And kullanici gerekli bilgileri girer
    And kullanici Register butonuna basar
    Then hesap olustugunu dogrular