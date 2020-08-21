package pageObjects;

import models.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    private static final int BASE_NUMBER_OF_TABLE_ROWS = 8;
    private static final String correctURL = "https://instr.by/catalog/cart";
    private static final By PriceLocator = By.cssSelector(".PricesalesPrice");
    private final Table table;
    @FindBy(tagName = "tbody")
    private WebElement tableLocator;
    @FindBy(css = ".PricebillTotal")
    private WebElement totalBillLocator;
    @FindAll(@FindBy(css = ".vm2-remove_from_cart"))
    private List<WebElement> removeItemButtons;

    public CartPage() {
        table = new Table(tableLocator);
    }

    @Override
    public String getURL() {
        return correctURL;
    }

    public List<WebElement> getRowsList() {
        return table.getRowsList();
    }

    public int getBaseNumberOfTableRows() {
        return BASE_NUMBER_OF_TABLE_ROWS;
    }

    public WebElement getTotalBillLocator() {
        return totalBillLocator.findElement(By.tagName("span"));
    }

    public WebElement getItemTotalLocator(int indexOfItem) {
        WebElement totalCellLocator =
                table.getCell(indexOfItem + 1, table.getNumberOfColumns() - 1);
        return totalCellLocator.findElement(PriceLocator);
    }

    public WebElement removeItemFromCartButton(int indexOfItem) {
        return removeItemButtons.get(indexOfItem);
    }
}
