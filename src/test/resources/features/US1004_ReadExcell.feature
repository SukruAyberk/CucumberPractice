Feature:US1004 kullanici excel bilgilerine ulasir

  Scenario:TC04 kullanici excel bilgilerini kullanir

    Given kullanici excel dosyasini kullanilabilir hale getirir
    Then 1. satirdaki 2. hucreyi yazdirir
    And baskenti "Jakarta" olan ulke ismini yazdirir
    And ulke sayisinin 190 oldugunu test eder
    And fiziki olarak kullanilan satir sayisinin 191 oldugunu test eder

    @writeExcell
  Scenario:TC05 kullanici excel bilgilerini kullanir

    Given kullanici excel dosyasini kullanilabilir hale getirir
    Then kullanici 0 satir 0 celle "ulke nufusu" yazdirir
    And kullanici 2 satir 0 celle "1,5 milyar" yazdirir
    And kullanici 8 satir 0 celle "250 milyon" yazdirir
    And dosyayi kaydeder ve kapatir



