package com.sannikov.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class UserProfilePage extends HeaderPage {

    private final static String url = "https://instr.by/create-an-account/profile";

    @FindBy(id = "users-profile-com.core")
    private WebElement profileCore;

    @Override
    public String getURL() {
        return url;
    }

    public WebElement getProfileCore() {
        return profileCore;
    }

}
