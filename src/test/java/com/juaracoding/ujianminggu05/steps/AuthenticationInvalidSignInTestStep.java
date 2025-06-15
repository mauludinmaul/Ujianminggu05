package com.juaracoding.ujianminggu05.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.juaracoding.ujianminggu05.DriverSingleton;
import com.juaracoding.ujianminggu05.pages.SignInPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthenticationInvalidSignInTestStep {
    WebDriver driver;
    SignInPage signInPage;

    @Given("Buka halaman login untuk pengujian login invalid")
    public void testStep01() {
        driver = DriverSingleton.createOrGetDriver();
        driver.get("https://www.saucedemo.com/v1");
        signInPage = new SignInPage(driver);
    }

    @When("Masukkan username {string} dan password {string} tidak valid")
    public void testStep02(String username, String password) {
        signInPage.setUsername(username);
        signInPage.setPassword(password);
    }

    @And("Klik tombol login untuk login tidak valid")
    public void testStep03() {
        signInPage.onClick();
    }

    @Then("Pengguna akan melihat pesan error")
    public void testStep04() {
        String expected = "Epic sadface: Username and password do not match any user in this service";
        String actual = signInPage.getErrorMessage();

        Assert.assertEquals(actual, expected);
    }
}