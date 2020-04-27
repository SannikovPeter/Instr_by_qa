package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MainMenu;

public class MainMenuSteps extends BasePageSteps {

    private MainMenu mainMenu;
    private WebDriver driver;

    public MainMenuSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        mainMenu = PageFactory.initElements(driver, MainMenu.class);
    }

    public MainPageSteps openMainPage() {
        waitUntilBeClickableAndClick(mainMenu.getMainButton());
        return new MainPageSteps(driver);
    }

    public BlogPageSteps openBlogPage() {
        waitUntilBeClickableAndClick(mainMenu.getBlogButton());
        return new BlogPageSteps(driver);
    }

    private void openBlogDropDownMenu() {
        moveTo(mainMenu.getBlogButton());
    }

    public ConstructionAndRepairBlogSteps openBlogConstructionAndRepairPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getConstructionAndRepairButton());
        return new ConstructionAndRepairBlogSteps(driver);
    }

    public HuntingAndTourismSteps openHuntingAndTourismPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getHuntingAndTourismButton());
        return new HuntingAndTourismSteps(driver);
    }

    public InstrNewsPageSteps openInstrNewsPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getInstrNewsButton());
        return new InstrNewsPageSteps(driver);
    }

    public CatalogPageSteps openCatalogPage() {
        waitUntilBeClickableAndClick(mainMenu.getCatalogButton());
        return new CatalogPageSteps(driver);
    }

    public RentPageSteps openRentPage() {
        waitUntilBeClickableAndClick(mainMenu.getRentButton());
        return new RentPageSteps(driver);
    }

    public ServicePageSteps openServicePage() {
        waitUntilBeClickableAndClick(mainMenu.getServiceButton());
        return new ServicePageSteps(driver);
    }

    public AboutUsPageSteps openAboutUsPage() {
        waitUntilBeClickableAndClick(mainMenu.getAboutUsButton());
        return new AboutUsPageSteps(driver);
    }

    public ContactsPageSteps openContactsPage() {
        waitUntilBeClickableAndClick(mainMenu.getContactsButton());
        return new ContactsPageSteps(driver);
    }
}
