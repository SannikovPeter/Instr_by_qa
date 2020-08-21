package steps;

import pageObjects.ItemPage;

public class ItemPageSteps extends BasePageSteps {
    private final ItemPage itemPage;

    public ItemPageSteps() {
        itemPage = new ItemPage();
    }

    public SearchPageSteps addToCart() {
        itemPage.getAddToCartButton().click();
        waitUntilBeClickableAndClick(itemPage.getContinueButton());
        return new SearchPageSteps();
    }

}
