package steps;

import org.openqa.selenium.WebDriver;
import pageObjects.MainMenu;

import static pageObjects.MainMenu.MainMenuButtons.*;

public class MainMenuSteps<T extends BasePageSteps> extends BasePageSteps {

    private MainMenu mainMenu;
    private WebDriver driver;

    public MainMenuSteps(WebDriver driver) {
        super(driver);
        this.driver = driver;
        mainMenu = new MainMenu(driver);
    }

    public MainPageSteps openMainPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(MAIN_PAGE));
        return new MainPageSteps(driver);
    }

    public BlogPageSteps openBlogPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(BLOG));
        return new BlogPageSteps(driver);
    }

    private void openBlogDropDownMenu() {
        moveTo(mainMenu.getButton(BLOG));
    }

    public ConstructionAndRepairBlogSteps openBlogConstructionAndRepairPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getButton(CONSTRUCTION_AND_REPAIR));
        return new ConstructionAndRepairBlogSteps(driver);
    }

    public HuntingAndTourismSteps openHuntingAndTourismPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getButton(HUNTING_AND_TOURISM));
        return new HuntingAndTourismSteps(driver);
    }

    public InstrNewsPageSteps openInstrNewsPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getButton(INSTR_NEWS));
        return new InstrNewsPageSteps(driver);
    }

    public CatalogPageSteps openCatalogPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(CATALOG));
        return new CatalogPageSteps(driver);
    }

    public RentPageSteps openRentPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(RENT));
        return new RentPageSteps(driver);
    }

    public ServicePageSteps openServicePage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(SERVICE));
        return new ServicePageSteps(driver);
    }

    public AboutUsPageSteps openAboutUsPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(ABOUT_US));
        return new AboutUsPageSteps(driver);
    }

    public ContactsPageSteps openContactsPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(CONTACTS));
        return new ContactsPageSteps(driver);
    }
}
