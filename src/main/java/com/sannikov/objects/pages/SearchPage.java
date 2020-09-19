package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.elements.Header;
import com.sannikov.objects.elements.Item;
import com.sannikov.objects.popUp.SearchPageConfirmForm;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

import java.util.List;

@Component
@Block(@FindBy(css = "body"))
public class SearchPage extends AbstractBase {

    private List<Item> itemList;

    private SearchPageConfirmForm popUp;

    public Header getHeader() {
        return getPage(Header.class);
    }

    public List<Item> getItemsList() {
        return itemList;
    }

    public SearchPageConfirmForm getPopUp() {
        return popUp;
    }
}
