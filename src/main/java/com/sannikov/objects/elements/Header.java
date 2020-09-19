package com.sannikov.objects.elements;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class Header extends AbstractBase {

    @FindBy(css = ".item-121")
    private WebElement insertButton;
    @FindBy(css = ".create-an-account")
    private WebElement registrationButton;
    @FindBy(css = ".logo-img")
    private WebElement logoButton;
    @FindBy(css = "#mod_virtuemart_search")
    private WebElement fastSearchBar;
    @FindBy(css = "#head-cart-dropdown")
    private WebElement fastCartButton;
    @FindBy(css = ".show_cart")
    private WebElement dropDownShowCartButton;
    @FindBy(css = ".total-container")
    private WebElement fastCartTotalBar;
    @FindBy(css = ".showcart")
    private WebElement popUpShowCartButton;
    @FindBy(css = "#fancybox-close")
    private WebElement closePopUpMenuButton;
    @FindBy(css = ".total_products")
    private WebElement totalProductsLocator;
    @FindBy(css = ".item-697")
    private WebElement exitButton;

    public WebElement getInsertButton() {
        return insertButton;
    }

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    public WebElement getLogoButton() {
        return logoButton;
    }

    public WebElement getFastSearchBar() {
        return fastSearchBar;
    }

    public WebElement getFastCartButton() {
        return fastCartButton;
    }

    public WebElement getDropDownShowCartButton() {
        return dropDownShowCartButton.findElement(By.tagName("a"));
    }

    public WebElement getPopUpShowCartButton() {
        return popUpShowCartButton;
    }

    public WebElement getFastCartTotalBar() {
        return fastCartTotalBar;
    }

    public WebElement getClosePopUpMenuButton() {
        return closePopUpMenuButton;
    }

    public WebElement getTotalProductsLocator() {
        return totalProductsLocator;
    }

    public WebElement getExitButton() {
        return exitButton;
    }

}
