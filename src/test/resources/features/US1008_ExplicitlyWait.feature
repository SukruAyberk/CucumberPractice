Feature: US1008 kullanici alerts'e cikinca bassin

  @demoqa1
  Scenario: TC08 alerts
    Given kullanici "demoqaUrl" anasayfasinda
    Then kullanici alertse tiklar
    And On button click, alert will appear after five seconds karsisindaki click me butonuna basar
    And  Allert’in gorunur olmasini bekleyin
    And Allert uzerindeki yazinin "This alert appeared after 5 seconds" oldugunu test edin
    And Ok diyerek alerti kapatin

