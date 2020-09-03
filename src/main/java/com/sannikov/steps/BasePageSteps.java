package com.sannikov.steps;

import com.sannikov.objects.*;
import com.sannikov.core.AppContext;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BasePageSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(BasePageSteps.class);

    private static final String Cart_is_empty = "Корзина пуста";

    private static final ThreadLocal<BasePage> BASE_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private BasePage getBasePage() {
        return BASE_PAGE_THREAD_LOCAL.get();
    }

    public void setBasePage(BasePage basePage) {
        BASE_PAGE_THREAD_LOCAL.set(basePage);
    }

    public void start() {
        setBasePage(AbstractBase.getPage(BasePage.class));
    }

    public boolean isPageCorrect() {
        return getBasePage().getURL().equals(AbstractBase.getDriver().getCurrentUrl());
    }

    public LoginPageSteps goToLoginPage() {
        getBasePage().getInsertButton().click();
        LoginPageSteps loginPageSteps = AppContext.getBean(LoginPageSteps.class);
        loginPageSteps.setLoginPage(AbstractBase.getPage(LoginPage.class));
        return loginPageSteps;
    }

    public MainPageSteps exit() {
        MainPageSteps mainPageSteps = AppContext.getBean(MainPageSteps.class);
        mainPageSteps.setMainPage(AbstractBase.getPage(MainPage.class));
        getBasePage().getExitButton().click();
        return mainPageSteps;
    }

    public RegistrationPageSteps getRegistrationPageSteps() {
        RegistrationPageSteps registrationPageSteps = AppContext.getBean(RegistrationPageSteps.class);
        registrationPageSteps.setRegistrationPage(AbstractBase.getPage(RegistrationPage.class));
        getBasePage().getRegistrationButton().click();
        return registrationPageSteps;
    }

    public MainPageSteps backToMainPage() {
        MainPageSteps mainPageSteps = AppContext.getBean(MainPageSteps.class);
        mainPageSteps.setMainPage(AbstractBase.getPage(MainPage.class));
        getBasePage().getLogoButton().click();
        return mainPageSteps;
    }

    public SearchPageSteps search(String searchItem) {
        SearchPageSteps searchPageSteps = AppContext.getBean(SearchPageSteps.class);
        searchPageSteps.setSearchPage(AbstractBase.getPage(SearchPage.class));
        getBasePage().getFastSearchBar().sendKeys(searchItem + Keys.ENTER);
        return searchPageSteps;
    }

    public CartPageSteps openCartPage() {
        CartPageSteps cartPageSteps = AppContext.getBean(CartPageSteps.class);
        cartPageSteps.setCartPage(AbstractBase.getPage(CartPage.class));
        getBasePage().getFastCartButton().click();
        getBasePage().getDropDownShowCartButton().click();
        return cartPageSteps;
    }

    private boolean isCartEmpty() {
        getBasePage().getFastCartButton().click();
        boolean result = getBasePage().getTotalProductsLocator().getText().contains(Cart_is_empty);
        getBasePage().getFastCartButton().click();
        return result;
    }

    public void removeAllItemsFromCart() {
        if (!isCartEmpty()) {
            CartPageSteps cartPageSteps = openCartPage();
            int numberOfItems = cartPageSteps.getAmountOfItems();
            for (int i = 0; i < numberOfItems; i++) {
                cartPageSteps.removeItem(0);
            }
        }
    }

    public void logOutIfItNecessary() {
        if (isExistsReturnWebElement(getBasePage().getExitButton()) !=null) {
            getBasePage().getExitButton().click();
        } else logger.info("User has been log in");
    }


    public MainMenuSteps getMainMenuSteps() {
        MainMenuSteps mainMenuSteps = AppContext.getBean(MainMenuSteps.class);
        mainMenuSteps.setMainMenu(AbstractBase.getPage(MainMenu.class));
        return mainMenuSteps;
    }

}
