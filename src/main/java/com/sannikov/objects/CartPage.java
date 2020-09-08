package com.sannikov.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartPage extends HeaderPage {

    private static final int BASE_NUMBER_OF_TABLE_ROWS = 8;
    private static final String correctURL = "https://instr.by/catalog/cart";
    private static final By PriceLocator = By.cssSelector(".PricesalesPrice");
    private static final By RowsLocator = By.tagName("tr");
    private static final By HeaderLocator = By.tagName("th");
    private static final By DataCellLocator = By.tagName("td");

    @FindBy(tagName = "tbody")
    private WebElement tableLocator;
    @FindBy(css = ".PricebillTotal")
    private WebElement totalBillLocator;
    @FindAll(@FindBy(css = ".vm2-remove_from_cart"))
    private List<WebElement> removeItemButtons;

    @Override
    public String getURL() {
        return correctURL;
    }

    public List<WebElement> getRowsList() {
        return tableLocator.findElements(RowsLocator);
    }

    public int getBaseNumberOfTableRows() {
        return BASE_NUMBER_OF_TABLE_ROWS;
    }

    private int getNumberOfColumns() {
        return getRowsList().get(0).findElements(HeaderLocator).size();
    }

    private WebElement getCell(int NumberOfRow, int NumberOfColumn) {
        return getRowsList().get(NumberOfRow).findElements(DataCellLocator).get(NumberOfColumn);
    }

    public WebElement getTotalBillLocator() {
        return totalBillLocator.findElement(By.tagName("span"));
    }

    public WebElement getItemTotalLocator(int indexOfItem) {
        WebElement totalCellLocator =
                getCell(indexOfItem + 1, getNumberOfColumns() - 1);
        return totalCellLocator.findElement(PriceLocator);
    }

    public WebElement removeItemFromCartButton(int indexOfItem) {
        return removeItemButtons.get(indexOfItem);
    }
}
