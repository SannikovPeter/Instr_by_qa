package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    private static final int BASE_NUMBER_OF_TABLE_ROWS = 8;
    private String correctURL = "https://instr.by/catalog/cart";
    @FindAll(@FindBy(tagName = "tr"))
    private List<WebElement> rowsList;
    @FindBy(css = ".PricebillTotal")
    private WebElement totalBillLocator;
    @FindAll(@FindBy(css = ".vm-cart-item-total"))
    private List<WebElement> itemTotalLocators;
    @FindAll(@FindBy(css = ".quantity-input"))
    private List<WebElement> numberOfPiecesInOneItemLocators;
    @FindAll(@FindBy(css = ".vm2-remove_from_cart"))
    private List<WebElement> removeItemButtons;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getURL() {
        return correctURL;
    }

    public List<WebElement> getRowsList() {
        return rowsList;
    }

    public int getBaseNumberOfTableRows() {
        return BASE_NUMBER_OF_TABLE_ROWS;
    }

    public WebElement getTotalBillLocator() {
        return totalBillLocator.findElement(By.tagName("span"));
    }

    public WebElement getItemTotalLocator(int indexOfItem) {
        return itemTotalLocators.get(indexOfItem + 1).findElement(By.cssSelector(".PricesalesPrice"));
    }

    public WebElement getNumberOfPiecesInOneItemLocator(int indexOfItem) {
        return numberOfPiecesInOneItemLocators.get(indexOfItem);
    }

    public WebElement removeItemFromCartButton(int indexOfItem) {
        return removeItemButtons.get(indexOfItem);
    }
}
