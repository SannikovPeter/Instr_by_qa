package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class ConstructionAndRepairBlogPage extends AbstractBase {

    private final static String correctURL = "https://instr.by/blog/strojka-i-remont";

    public String getURL() {
        return correctURL;
    }
}