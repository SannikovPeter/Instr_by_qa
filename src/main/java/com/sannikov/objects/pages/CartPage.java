package com.sannikov.objects.pages;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.elements.Table;
import com.sannikov.objects.elements.TableRow;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.annotations.Block;

import java.util.List;

@Component
@Block(@FindBy(css = "#t3-mainbody"))
public class CartPage extends AbstractBase {

    private static final int BASE_NUMBER_OF_TABLE_ROWS = 8;
    private static final String correctURL = "https://instr.by/catalog/cart";
    @FindBy(css = ".cart-summary")
    private Table table;

    @Override
    public String getURL() {
        return correctURL;
    }

    public List<TableRow> getRowsList() {
        return table.getRowList();
    }

    public int getBaseNumberOfTableRows() {
        return BASE_NUMBER_OF_TABLE_ROWS;
    }

    public WebElement getTotalBillLocator() {
        return table.getTotalBillLocator();
    }

    public WebElement getItemTotalPriceLocator(int indexOfItem) {
        TableRow tableRow = table.getRow(indexOfItem + 1);
        return tableRow.getItemTotal();
    }

    public WebElement removeItemFromCartButton(int indexOfItem) {
        return table.getRow(indexOfItem + 1).getRemoveButton();
    }
}
