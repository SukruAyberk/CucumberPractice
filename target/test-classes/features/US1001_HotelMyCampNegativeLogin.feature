Feature: US1001 kullanici yanlis verilerle giris yapamaz

  @hmc
  Scenario Outline: TC01 yanlis username ve password ile sisteme girilemez

    Given kullanici "HMCUrl" anasayfasinda
    Then login butonuna basar
    And username "<username>" girer
    And password "<password>" girer
    And login click eder
    Then giris yapilamadigini kontrol eder
    And sayfayi kapatir

    Examples:
      | username | password |
      | Manager  | Manager  |
      #| Manager1 | Manager1 |
      #| Manager2 | Manager2 |
      #| Manager3 | Manager3 |
      #| Manager4 | Manager4 |
