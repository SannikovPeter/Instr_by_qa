package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindAll(@FindBy(tagName = "tr"))
    private List<WebElement> tableRows;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getTableRows() {
        return tableRows;
    }
}
