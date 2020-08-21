package steps;

import core.AppContext;
import core.BrowserManager;
import org.openqa.selenium.WebDriver;
import pageObjects.SearchPage;

public class SearchPageSteps extends BasePageSteps {
    private final SearchPage searchPage;
    private final WebDriver driver;

    public SearchPageSteps() {
        driver = AppContext.getBean(BrowserManager.class).getDriver();
        searchPage = new SearchPage();
    }

    public ItemSteps getItem(int indexOfItem) {
        moveTo(searchPage.getItemsList().get(indexOfItem).getItemLocator());
        return new ItemSteps(searchPage.getItemsList().get(indexOfItem));
    }

    public CatalogPageSteps continueShopping() {
        waitUntilBeClickableAndClick(searchPage.getContinueButton());
        return new CatalogPageSteps();
    }

    public CartPageSteps getCartPage() {
        waitUntilBeClickableAndClick(searchPage.getPopUpShowCartButton());
        return new CartPageSteps();
    }
}
