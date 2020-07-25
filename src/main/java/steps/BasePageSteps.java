package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.BasePage;

public class BasePageSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(BasePageSteps.class);

    private static final String Cart_is_empty = "Корзина пуста";
    private BasePage basePage;
    private WebDriver driver;

    public BasePageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = new BasePage(driver);
    }

    public boolean isPageCorrect() {
        return basePage.getURL().equals(driver.getCurrentUrl());
    }

    public LoginPageSteps openLoginPage() {
        basePage.getInsertButton().click();
        return new LoginPageSteps(driver);
    }

    public MainPageSteps exit() {
        basePage.getExitButton().click();
        return new MainPageSteps(driver);
    }

    public RegistrationPageSteps getRegistrationPageSteps() {
        basePage.getRegistrationButton().click();
        return new RegistrationPageSteps(driver);
    }

    public MainPageSteps backToMainPage() {
        basePage.getLogoButton().click();
        return new MainPageSteps(driver);
    }

    public SearchPageSteps search(String searchItem) {
        basePage.getFastSearchBar().sendKeys(searchItem + Keys.ENTER);
        return new SearchPageSteps(driver);
    }

    public CartPageSteps openCartPage() {
        basePage.getFastCartButton().click();
        basePage.getDropDownShowCartButton().click();
        return new CartPageSteps(driver);
    }

    private boolean isCartEmpty() {
        basePage.getFastCartButton().click();
        boolean result = basePage.getTotalProductsLocator().getText().contains(Cart_is_empty);
        basePage.getFastCartButton().click();
        return result;
    }

    public void removeAllItemsFromCart() {
        if (!isCartEmpty()) {
            CartPageSteps cartPageSteps = openCartPage();
            int numberOfItems = cartPageSteps.getAmountOfItems();
            for (int i = 0; i < numberOfItems; i++) {
                cartPageSteps.removeItem(0);
            }
        }
    }

    public void checkLogIn() {
        try {
            if (basePage.getExitButton().isDisplayed()) {
                exit();
            }
        } catch (NoSuchElementException e) {
            logger.info("User has been log in");
        }
    }

    public MainMenuSteps getMainMenuSteps() {
        return new MainMenuSteps(driver);
    }

}
