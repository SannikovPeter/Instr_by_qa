package steps;

import pageObjects.Item;

public class ItemSteps extends BaseSteps {
    private final Item item;

    public ItemSteps(Item item) {
        this.item = item;
    }

    public void addItemToCart() {
        try {
            item.getAddToCartButton().click();
        } catch (Exception e) {
            scrollWindow(100);
            waitUntilBeClickableAndClick(item.getAddToCartButton());
        }
    }

    public ItemPageSteps getItemPage() {
        item.getItemLocator().click();
        return new ItemPageSteps();
    }

    public String getItemName() {
        return item.getName().getText();
    }

}
