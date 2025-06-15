package com.juaracoding.ujianminggu05.steps;

import com.juaracoding.ujianminggu05.DriverSingleton;
import com.juaracoding.ujianminggu05.pages.CartPage;
import com.juaracoding.ujianminggu05.pages.ProductListPage;
import com.juaracoding.ujianminggu05.pages.SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddtoCartTest {

    WebDriver driver;
    SignInPage signInPage;
    CartPage cartPage;
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

    @And("Klik tombol Add to Cart pada salah satu produk")
    public void testStep03() {
        produkListPage.ClickAddtoCart();
    }

    @And("Klik ikon keranjang")
    public void testStep04(){
        produkListPage.ClickCart();
    }

    @Then("Muncul Halaman cart")
    public void testStep05() {
        String expected = "https://www.saucedemo.com/v1/cart.html";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected);
    }
}
