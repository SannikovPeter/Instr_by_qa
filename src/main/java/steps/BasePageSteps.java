package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePage;

public class BasePageSteps extends BaseSteps {

    private WebDriver driver;
    private BasePage basePage;

    public BasePageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        basePage = PageFactory.initElements(driver, BasePage.class);
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

    public CatalogPageSteps search(String searchItem) {
        basePage.getFastSearchBar().sendKeys(searchItem + Keys.ENTER);
        return new CatalogPageSteps(driver);
    }

    public CartPageSteps openCartPage() {
        basePage.getFastCartButton().click();
        basePage.getDropDownShowCartButton().click();
        return new CartPageSteps(driver);
    }

    public boolean isCartEmpty() {
        basePage.getFastCartButton().click();
        boolean result = basePage.getTotalProductsLocator().getText().contains("Корзина пуста");
        basePage.getFastCartButton().click();
        return result;
    }

    public void removeAllItemsFromCart() {
        if (!isCartEmpty()) {
            CartPageSteps cartPageSteps = openCartPage();
            int numberOfItems = cartPageSteps.getNumberOfItems();
            for (int i = 0; i < numberOfItems; i++) {
                cartPageSteps.removeItem(0);
            }
        }
    }
}
