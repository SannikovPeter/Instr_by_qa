package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {
    private static final By RowsLocator = By.tagName("tr");
    private static final By HeaderLocator = By.tagName("th");
    private static final By DataCellLocator = By.tagName("td");
    private WebElement table;

    private List<WebElement> rowsList;

    public Table(WebElement tableLocator) {
        table = tableLocator;
        rowsList = table.findElements(RowsLocator);
    }

    public List<WebElement> getRowsList() {
        return rowsList;
    }

    public int getNumberOfColumns() {
        return rowsList.get(0).findElements(HeaderLocator).size();
    }

    public WebElement getCell(int NumberOfRow, int NumberOfColumn) {
        return rowsList.get(NumberOfRow).findElements(DataCellLocator).get(NumberOfColumn);
    }
}
