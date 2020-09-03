package com.sannikov.steps;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.RegistrationPage;
import com.sannikov.objects.UserProfilePage;
import org.springframework.stereotype.Component;
import com.sannikov.core.AppContext;

@Component
public class RegistrationPageSteps extends BasePageSteps {
    private static final ThreadLocal<RegistrationPage> REGISTRATION_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private RegistrationPage getRegistrationPage() {
        return REGISTRATION_PAGE_THREAD_LOCAL.get();
    }

    public void setRegistrationPage(RegistrationPage registrationPage) {
        REGISTRATION_PAGE_THREAD_LOCAL.set(registrationPage);
    }

    public UserProfilePageSteps registration(String name, String password, String email) {
        UserProfilePageSteps userProfilePageSteps = AppContext.getBean(UserProfilePageSteps.class);
        userProfilePageSteps.setUserProfilePage(AbstractBase.getPage(UserProfilePage.class));
        getRegistrationPage().getEmailField().sendKeys(email);
        getRegistrationPage().getNameField().sendKeys(name);
        getRegistrationPage().getUserNameField().sendKeys(name);
        getRegistrationPage().getPasswordField().sendKeys(password);
        getRegistrationPage().getConfirmPasswordField().sendKeys(password);
        getRegistrationPage().getCaptchaBox().submit();
        getRegistrationPage().getRegistrationButtonLocator().submit();
        return userProfilePageSteps;
    }


}
