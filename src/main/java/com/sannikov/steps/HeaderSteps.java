package com.sannikov.steps;

import com.sannikov.core.AppContext;
import com.sannikov.objects.*;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HeaderSteps extends BaseSteps {

    private static final Logger logger = LoggerFactory.getLogger(HeaderSteps.class);

    private static final String Cart_is_empty = "Корзина пуста";

    private static final ThreadLocal<HeaderPage> HEADER_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private HeaderPage getHeaderPage() {
        return HEADER_PAGE_THREAD_LOCAL.get();
    }

    public void setHeaderPage(HeaderPage headerPage) {
        HEADER_PAGE_THREAD_LOCAL.set(headerPage);
    }

    public boolean isPageCorrect() {
        return getHeaderPage().getURL().equals(AbstractBase.getDriver().getCurrentUrl());
    }

    public LoginPageSteps goToLoginPage() {
        getHeaderPage().getInsertButton().click();
        LoginPageSteps loginPageSteps = AppContext.getBean(LoginPageSteps.class);
        loginPageSteps.setLoginPage(AbstractBase.getPage(LoginPage.class));
        return loginPageSteps;
    }

    public MainPageSteps exit() {
        MainPageSteps mainPageSteps = AppContext.getBean(MainPageSteps.class);
        mainPageSteps.setMainPage(AbstractBase.getPage(MainPage.class));
        getHeaderPage().getExitButton().click();
        return mainPageSteps;
    }

    public RegistrationPageSteps getRegistrationPageSteps() {
        RegistrationPageSteps registrationPageSteps = AppContext.getBean(RegistrationPageSteps.class);
        registrationPageSteps.setRegistrationPage(AbstractBase.getPage(RegistrationPage.class));
        getHeaderPage().getRegistrationButton().click();
        return registrationPageSteps;
    }

    public MainPageSteps backToMainPage() {
        MainPageSteps mainPageSteps = AppContext.getBean(MainPageSteps.class);
        mainPageSteps.setMainPage(AbstractBase.getPage(MainPage.class));
        getHeaderPage().getLogoButton().click();
        return mainPageSteps;
    }

    public SearchPageSteps search(String searchItem) {
        SearchPageSteps searchPageSteps = AppContext.getBean(SearchPageSteps.class);
        searchPageSteps.setSearchPage(AbstractBase.getPage(SearchPage.class));
        getHeaderPage().getFastSearchBar().sendKeys(searchItem + Keys.ENTER);
        return searchPageSteps;
    }

    public CartPageSteps openCartPage() {
        CartPageSteps cartPageSteps = AppContext.getBean(CartPageSteps.class);
        cartPageSteps.setCartPage(AbstractBase.getPage(CartPage.class));
        getHeaderPage().getFastCartButton().click();
        getHeaderPage().getDropDownShowCartButton().click();
        return cartPageSteps;
    }

    private boolean isCartEmpty() {
        getHeaderPage().getFastCartButton().click();
        boolean result = getHeaderPage().getTotalProductsLocator().getText().contains(Cart_is_empty);
        getHeaderPage().getFastCartButton().click();
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
        if (isExistsReturnWebElement(getHeaderPage().getExitButton()) != null) {
            getHeaderPage().getExitButton().click();
        } else logger.info("User has been log in");
    }

    public MainMenuSteps getMainMenuSteps() {
        MainMenuSteps mainMenuSteps = AppContext.getBean(MainMenuSteps.class);
        mainMenuSteps.setMainMenu(AbstractBase.getPage(MainMenu.class));
        return mainMenuSteps;
    }

}
