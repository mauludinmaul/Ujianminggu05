package com.juaracoding.ujianminggu05.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class ProductListPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> inventoryItemName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> inventoryItemPrice;

    @FindBy(xpath = "(//button[@class='btn_primary btn_inventory'][normalize-space()='ADD TO CART'])[1]")
    List<WebElement> buttonAddToCart;

    @FindBy(xpath = "//button[@class='shopping_cart_link']")
    List<WebElement> buttonCart;


    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getTotalNames() {
        return inventoryItemName.size();
    }

    public int getTotalPrices() {
        return inventoryItemPrice.size();
    }

    public int getTotalButtons() {
        return buttonAddToCart.size();
    }

    public boolean hasAProducts() {
        return Arrays.asList(
                getTotalNames(),
                getTotalPrices(),
                getTotalButtons()).contains(6);
    }
    public void ClickAddtoCart() {
        buttonAddToCart.get(0).click();
    }
    public void ClickCart() {
        buttonCart.get(0).click();
    }

    public boolean checkProperty() {
        boolean state = true;
        int size = getTotalButtons();

        for (int i = 0; i < size; i++) {

            WebElement name = inventoryItemName.get(i);
            WebElement price = inventoryItemPrice.get(i);
            WebElement button = buttonAddToCart.get(i);

            if (!name.isDisplayed() || !price.isDisplayed() || !button.isDisplayed()) {
                state = false;
                break;
            }
        }

        return state;
    }
}