package com.sannikov.steps;

import com.sannikov.core.AppContext;
import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.LoginPage;
import com.sannikov.objects.UserProfilePage;
import org.springframework.stereotype.Component;

@Component
public class LoginPageSteps extends BaseSteps {

    private static final ThreadLocal<LoginPage> LOGIN_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private LoginPage getLoginPage() {
        return LOGIN_PAGE_THREAD_LOCAL.get();
    }

    public void setLoginPage(LoginPage loginPage) {
        LOGIN_PAGE_THREAD_LOCAL.set(loginPage);
    }

    private void login(String name, String password) {
        getLoginPage().getUserNameBar().sendKeys(name);
        getLoginPage().getPasswordBar().sendKeys(password);
        getLoginPage().getSubmitButton().submit();
    }

    public UserProfilePageSteps successLogin(String name, String password) {
        UserProfilePageSteps userProfilePageSteps = AppContext.getBean(UserProfilePageSteps.class);
        userProfilePageSteps.setUserProfilePage(AbstractBase.getPage(UserProfilePage.class));
        login(name, password);
        return userProfilePageSteps;
    }

    public LoginPageSteps unsuccessfulLogin(String name, String password) {
        LoginPageSteps loginPageSteps = AppContext.getBean(LoginPageSteps.class);
        loginPageSteps.setLoginPage(AbstractBase.getPage(LoginPage.class));
        login(name, password);
        return loginPageSteps;
    }

    public boolean isPageCorrect() {
        return getLoginPage().getURL().equals(AbstractBase.getDriver().getCurrentUrl());
    }

    public boolean isAlertPresent() {
        return getLoginPage().getAlertWrongNameOrPassword().isDisplayed();
    }

}
