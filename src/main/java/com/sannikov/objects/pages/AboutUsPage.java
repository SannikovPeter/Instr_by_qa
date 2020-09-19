package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

@Component
@Block(@FindBy(css = "body"))
public class AboutUsPage extends AbstractBase {
    private final static String correctURL = "https://instr.by/aboutus";

    public String getURL() {
        return correctURL;
    }
}
