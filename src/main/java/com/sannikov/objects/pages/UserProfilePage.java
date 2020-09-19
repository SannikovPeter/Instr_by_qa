package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class UserProfilePage extends AbstractBase {

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
