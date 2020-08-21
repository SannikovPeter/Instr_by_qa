package steps;

import pageObjects.MainMenu;

import static pageObjects.MainMenu.MainMenuButtons.*;

public class MainMenuSteps extends BasePageSteps {
    private final MainMenu mainMenu;

    public MainMenuSteps() {
        mainMenu = new MainMenu();
    }

    public MainPageSteps openMainPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(MAIN_PAGE));
        return new MainPageSteps();
    }

    public BlogPageSteps openBlogPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(BLOG));
        return new BlogPageSteps();
    }

    private void openBlogDropDownMenu() {
        moveTo(mainMenu.getButton(BLOG));
    }

    public ConstructionAndRepairBlogSteps openBlogConstructionAndRepairPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getButton(CONSTRUCTION_AND_REPAIR));
        return new ConstructionAndRepairBlogSteps();
    }

    public HuntingAndTourismSteps openHuntingAndTourismPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getButton(HUNTING_AND_TOURISM));
        return new HuntingAndTourismSteps();
    }

    public InstrNewsPageSteps openInstrNewsPage() {
        openBlogDropDownMenu();
        waitUntilBeClickableAndClick(mainMenu.getButton(INSTR_NEWS));
        return new InstrNewsPageSteps();
    }

    public CatalogPageSteps openCatalogPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(CATALOG));
        return new CatalogPageSteps();
    }

    public RentPageSteps openRentPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(RENT));
        return new RentPageSteps();
    }

    public ServicePageSteps openServicePage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(SERVICE));
        return new ServicePageSteps();
    }

    public AboutUsPageSteps openAboutUsPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(ABOUT_US));
        return new AboutUsPageSteps();
    }

    public ContactsPageSteps openContactsPage() {
        waitUntilBeClickableAndClick(mainMenu.getButton(CONTACTS));
        return new ContactsPageSteps();
    }
}
