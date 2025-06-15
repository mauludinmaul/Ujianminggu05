Feature: Keranjang Belanja

  Scenario: Tambahkan produk ke keranjang
    Given pretest lagi, login dengan user valid
    When Klik tombol Add to Cart pada salah satu produk
    And Klik ikon keranjang
    Then Muncul Halaman cart
