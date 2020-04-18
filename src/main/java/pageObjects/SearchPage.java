package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    private static final By catalogSearchInput = By.cssSelector(".inputbox");
    private static final By searchSubmitButton = By.cssSelector(".button");

    @FindBy(css = ".virtuemart_search")
    private WebElement catalogSearch;
    @FindAll(@FindBy(css = ".isotope-item"))
    private List<WebElement> itemsLocatorList;
    private List<Item> itemsList;
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        createItemsList();
    }

    private void createItemsList() {
        itemsList = new ArrayList<Item>();
        for (WebElement itemLocator : itemsLocatorList) {
            itemsList.add(new Item(itemLocator));
        }
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public WebElement getCatalogSearchInput() {
        return catalogSearch.findElement(catalogSearchInput);
    }

    public WebElement getCatalogSearchSubmit() {
        return catalogSearch.findElement(searchSubmitButton);
    }
}
