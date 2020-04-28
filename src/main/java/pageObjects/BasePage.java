package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends Base {

    private String correctURL;

    @FindBy(css = ".item-121")
    private WebElement insertButton;
    @FindBy(css = ".create-an-account")
    private WebElement registrationButton;
    @FindBy(css = ".logo-img")
    private WebElement logoButton;
    @FindBy(id = "mod_virtuemart_search")
    private WebElement fastSearchBar;
    @FindBy(id = "head-cart-dropdown")
    private WebElement fastCartButton;
    @FindBy(css = ".show_cart")
    private WebElement dropDownShowCartButton;
    @FindBy(css = ".continue_link")
    private WebElement continueButton;
    @FindBy(css = ".total-container")
    private WebElement fastCartTotalBar;
    @FindBy(css = ".showcart")
    private WebElement popUpShowCartButton;
    @FindBy(id = "fancybox-close")
    private WebElement closePopUpMenuButton;
    @FindBy(css = ".total_products")
    private WebElement totalProductsLocator;
    @FindBy(css = ".item-697")
    private WebElement exitButton;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getURL() {
        return correctURL;
    }

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

    public WebElement getContinueButton() {
        return continueButton;
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
