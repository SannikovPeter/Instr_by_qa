package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Item extends Base {

    @FindAll(@FindBy(css = ".isotope-item"))
    private List<WebElement> itemsList;
    @FindAll(@FindBy(name = "addtocart"))
    private List<WebElement> addToCartButton;
    private WebDriver driver;
    private int indexOfItem;

    public Item(WebDriver driver, int indexOfItem) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.indexOfItem = indexOfItem;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton.get(indexOfItem);
    }

    public WebElement getItemLocator() {
        return itemsList.get(indexOfItem);
    }
}
