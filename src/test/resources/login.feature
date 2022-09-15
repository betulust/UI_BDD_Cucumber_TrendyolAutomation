Feature: Trendyol Test

  Scenario: Trendyol Sitesine gidilir.
    Given Trendyol sitesine giris yapilir.
    And Urun arama alanina masaustu bilgisayar yazilir Enter basilir.
    And Bir urun secilir.
    And Urun sepete eklenir.
    And Sepete gidilir.
    And Sepetteki urun adinin dogru oldugu kontrol edilir.
    And cop butonuna tiklanir.
    And Acilan popupta Sil butonuna tiklanir.
    And Sepetim tiklanir.
    Then Sepette ilgili urunun bulunmadigi kontrol edilir.
