package com.juaracoding.ujianminggu05.steps;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.ujianminggu05.DriverSingleton;
import com.juaracoding.ujianminggu05.pages.ProductListPage;
import com.juaracoding.ujianminggu05.pages.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifikasiProdukTest {
    WebDriver driver;
    SignInPage signInPage;

    ProductListPage produkListPage;

    @Given("Pretest verifikasi, login dengan user valid")
    public void testStep01() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        signInPage = new SignInPage(driver);
        produkListPage = new ProductListPage(driver);
        signInPage.login("standard_user", "secret_sauce");
    }

    @When("Verifikasi semua produk ditampilkan")
    public void testStep02() {
        Assert.assertTrue(produkListPage.hasAProducts());
    }

    @Then("Daftar produk muncul lengkap dengan nama, harga, dan tombol Add to Cart")
    public void testStep03() {
        Assert.assertTrue(produkListPage.checkProperty());
    }
}