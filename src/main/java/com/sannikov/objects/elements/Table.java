package com.sannikov.objects.elements;

import com.sannikov.objects.AbstractBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

import java.util.List;

@Component
@Block(@FindBy(css = "table"))
public class Table extends AbstractBase {

    private List<TableRow> tableRowList;
    @FindBy(css = ".PricebillTotal span")
    private WebElement totalBillLocator;

    public List<TableRow> getRowList() {
        return tableRowList;
    }

    public TableRow getRow(int numberRow) {
        return getRowList().get(numberRow);
    }

    public WebElement getTotalBillLocator() {
        return totalBillLocator;
    }
}
