Feature: US1003 kullanici gecerli olmayan bir email ile kayit olamaz

  Scenario: TC03 kullanici hesap acamamali
    Given kullanici "apUrl" anasayfasinda
    Then kullanici singine tiklar
    And kullanici create account bolumune gecersiz email adresi girer
    Then kullanici create an account butonuna basar
    And error mesajinin "Invalid email address" oldugunu dogrula