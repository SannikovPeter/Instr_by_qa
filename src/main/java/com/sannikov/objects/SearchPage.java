package com.sannikov.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchPage extends BasePage {

    @FindAll(@FindBy(css = ".isotope-item"))
    private List<WebElement> itemsLocatorList;

    public List<Item> getItemsList() {
        List<Item> result = new ArrayList<>();
        for (WebElement itemLocator : itemsLocatorList) {
            result.add(new Item(itemLocator));
        }
        return result;
    }
}
