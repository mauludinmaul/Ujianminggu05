Feature: Keranjang Belanja

  Scenario: Tambahkan produk ke keranjang
    Given Pretest verifikasi, login dengan user valid
    When Verifikasi semua produk ditampilkan
    And Klik tombol Add to Cart pada salah satu produk
    And Klik ikon keranjang
    Then Muncul Halaman cart
