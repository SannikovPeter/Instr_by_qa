package com.sannikov.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class MainMenu extends AbstractBase {

    public WebElement getButton(MainMenuButtons button) {
        return getDriver().findElement(By.cssSelector(button.title));
    }

    public enum MainMenuButtons {
        MAIN_PAGE("li[data-id ='101']"),
        BLOG("li[data-id ='537']"),
        CATALOG("li[data-id ='519']"),
        RENT("li[data-id ='664']"),
        SERVICE("li[data-id ='564']"),
        ABOUT_US("li[data-id ='518']"),
        CONTACTS("li[data-id ='104']"),
        CONSTRUCTION_AND_REPAIR("li[data-id ='134']"),
        HUNTING_AND_TOURISM("li[data-id ='135']"),
        INSTR_NEWS("li[data-id ='136']");

        private final String title;

        MainMenuButtons(String title) {
            this.title = title;
        }
    }

}
