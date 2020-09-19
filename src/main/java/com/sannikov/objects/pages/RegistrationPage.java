package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class RegistrationPage extends AbstractBase {
    private final static String correctURL = "https://instr.by/uchetnaya-zapis";
    @FindBy(id = "email_field")
    private WebElement emailField;
    @FindBy(id = "name_field")
    private WebElement nameField;
    @FindBy(id = "username_field")
    private WebElement userNameField;
    @FindBy(id = "password_field")
    private WebElement passwordField;
    @FindBy(id = "password2_field")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//*[@id=\"adminForm\"]/div[1]/button[1]")
    private WebElement registrationButtonLocator;
    @FindBy(css = ".recaptcha-checkbox-border")
    private WebElement captchaBox;

    @Override
    public String getURL() {
        return correctURL;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getRegistrationButtonLocator() {
        return registrationButtonLocator;
    }

    public WebElement getCaptchaBox() {
        return captchaBox;
    }
}
