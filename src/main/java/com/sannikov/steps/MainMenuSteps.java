package com.sannikov.steps;

import com.sannikov.core.AppContext;
import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.elements.MainMenu;
import com.sannikov.objects.pages.*;
import org.springframework.stereotype.Component;

import static com.sannikov.objects.elements.MainMenu.MainMenuButtons.*;

@Component
public class MainMenuSteps extends BaseSteps {

    private static final ThreadLocal<MainMenu> MAIN_MENU_THREAD_LOCAL = new ThreadLocal<>();

    private MainMenu getMainMenu() {
        return MAIN_MENU_THREAD_LOCAL.get();
    }

    public void setMainMenu(MainMenu mainMenu) {
        MAIN_MENU_THREAD_LOCAL.set(mainMenu);
    }

    public MainPageSteps openMainPage() {
        MainPageSteps mainPageSteps = AppContext.getBean(MainPageSteps.class);
        mainPageSteps.setMainPage(AbstractBase.getPage(MainPage.class));
        saveClick(getMainMenu().getButton(MAIN_PAGE));
        return mainPageSteps;
    }

    public BlogPageSteps openBlogPage() {
        BlogPageSteps blogPageSteps = AppContext.getBean(BlogPageSteps.class);
        blogPageSteps.setBlogPage(AbstractBase.getPage(BlogPage.class));
        saveClick(getMainMenu().getButton(BLOG));
        return blogPageSteps;
    }

    private void openBlogDropDownMenu() {
        moveTo(getMainMenu().getButton(BLOG));
    }

    public ConstructionAndRepairBlogSteps openBlogConstructionAndRepairPage() {
        ConstructionAndRepairBlogSteps constructionAndRepairBlogSteps = AppContext.getBean(ConstructionAndRepairBlogSteps.class);
        constructionAndRepairBlogSteps.setConstructionAndRepairBlogPage(AbstractBase.getPage(ConstructionAndRepairBlogPage.class));
        openBlogDropDownMenu();
        saveClick(getMainMenu().getButton(CONSTRUCTION_AND_REPAIR));
        return constructionAndRepairBlogSteps;
    }

    public HuntingAndTourismSteps openHuntingAndTourismPage() {
        HuntingAndTourismSteps huntingAndTourismSteps = AppContext.getBean(HuntingAndTourismSteps.class);
        huntingAndTourismSteps.setHuntingAndTourismPage(AbstractBase.getPage(HuntingAndTourismPage.class));
        openBlogDropDownMenu();
        saveClick(getMainMenu().getButton(HUNTING_AND_TOURISM));
        return huntingAndTourismSteps;
    }

    public InstrNewsPageSteps openInstrNewsPage() {
        InstrNewsPageSteps instrNewsPageSteps = AppContext.getBean(InstrNewsPageSteps.class);
        instrNewsPageSteps.setInstrNewsPage(AbstractBase.getPage(InstrNewsPage.class));
        openBlogDropDownMenu();
        saveClick(getMainMenu().getButton(INSTR_NEWS));
        return instrNewsPageSteps;
    }

    public CatalogPageSteps openCatalogPage() {
        CatalogPageSteps catalogPageSteps = AppContext.getBean(CatalogPageSteps.class);
        catalogPageSteps.setCatalogPage(AbstractBase.getPage(CatalogPage.class));
        saveClick(getMainMenu().getButton(CATALOG));
        return catalogPageSteps;
    }

    public RentPageSteps openRentPage() {
        RentPageSteps rentPageSteps = AppContext.getBean(RentPageSteps.class);
        rentPageSteps.setRentPage(AbstractBase.getPage(RentPage.class));
        saveClick(getMainMenu().getButton(RENT));
        return rentPageSteps;
    }

    public ServicePageSteps openServicePage() {
        ServicePageSteps servicePageSteps = AppContext.getBean(ServicePageSteps.class);
        servicePageSteps.setServicePage(AbstractBase.getPage(ServicePage.class));
        saveClick(getMainMenu().getButton(SERVICE));
        return servicePageSteps;
    }

    public AboutUsPageSteps openAboutUsPage() {
        AboutUsPageSteps aboutUsPageSteps = AppContext.getBean(AboutUsPageSteps.class);
        aboutUsPageSteps.setAboutUsPage(AboutUsPage.getPage(AboutUsPage.class));
        saveClick(getMainMenu().getButton(ABOUT_US));
        return aboutUsPageSteps;
    }

    public ContactsPageSteps openContactsPage() {
        ContactsPageSteps contactsPageSteps = AppContext.getBean(ContactsPageSteps.class);
        contactsPageSteps.setContactsPage(AbstractBase.getPage(ContactsPage.class));
        saveClick(getMainMenu().getButton(CONTACTS));
        return contactsPageSteps;
    }
}
