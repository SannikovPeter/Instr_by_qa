package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends Base {

    @FindBy(css = "li[data-id ='101']")
    private WebElement mainButton;
    @FindBy(css = "li[data-id ='537']")
    private WebElement blogButton;
    @FindBy(css = "li[data-id ='519']")
    private WebElement catalogButton;
    @FindBy(css = "li[data-id ='664']")
    private WebElement rentButton;
    @FindBy(css = "li[data-id ='564']")
    private WebElement serviceButton;
    @FindBy(css = "li[data-id ='518']")
    private WebElement aboutUsButton;
    @FindBy(css = "li[data-id ='104']")
    private WebElement contactsButton;
    @FindBy(css = "li[data-id ='134']")
    private WebElement constructionAndRepairButton;
    @FindBy(css = "li[data-id ='135']")
    private WebElement huntingAndTourismButton;
    @FindBy(css = "li[data-id ='136']")
    private WebElement instrNewsButton;

    public WebElement getMainButton() {
        return mainButton;
    }

    public WebElement getBlogButton() {
        return blogButton;
    }

    public WebElement getCatalogButton() {
        return catalogButton;
    }

    public WebElement getRentButton() {
        return rentButton;
    }

    public WebElement getServiceButton() {
        return serviceButton;
    }

    public WebElement getAboutUsButton() {
        return aboutUsButton;
    }

    public WebElement getContactsButton() {
        return contactsButton;
    }

    public WebElement getConstructionAndRepairButton() {
        return constructionAndRepairButton;
    }

    public WebElement getHuntingAndTourismButton() {
        return huntingAndTourismButton;
    }

    public WebElement getInstrNewsButton() {
        return instrNewsButton;
    }
}
