package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BasePage {

    @FindAll(@FindBy(css = ".isotope-item"))
    private List<WebElement> itemsList;
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getItemsList() {
        return itemsList;
    }

}
