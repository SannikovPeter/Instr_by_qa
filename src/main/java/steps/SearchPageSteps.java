package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SearchPage;

public class SearchPageSteps extends BasePageSteps {

    private SearchPage searchPage;
    private WebDriver driver;

    public SearchPageSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    public ItemSteps getItem(int indexOfItem) {
        moveTo(searchPage.getItemsList().get(indexOfItem).getItemLocator());
        return new ItemSteps(driver, searchPage.getItemsList().get(indexOfItem));
    }

    public CatalogPageSteps continueShopping() {
        waitUntilBeClickableAndClick(searchPage.getContinueButton());
        return new CatalogPageSteps(driver);
    }

    public CartPageSteps getCartPage() {
        waitUntilBeClickableAndClick(searchPage.getPopUpShowCartButton());
        return new CartPageSteps(driver);
    }
}
