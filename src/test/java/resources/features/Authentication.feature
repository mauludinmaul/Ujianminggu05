Feature: Authentication feature test

  @PriorityTinggi
  Scenario Outline: Login dengan kredensial yang valid
    Given Buka halaman login untuk pengujian login valid
    When Masukkan username "<username>" dan password "<password>" valid
    And Klik tombol login untuk login valid
    Then Pengguna berhasil masuk ke halaman produk

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Login dengan kredensial yang tidak valid
    Given Buka halaman login untuk pengujian login invalid
    When Masukkan username "<username>" dan password "<password>" tidak valid
    And Klik tombol login untuk login tidak valid
    Then Pengguna akan melihat pesan error

    Examples:
      | username       | password       |
      | username_salah | password_salah |