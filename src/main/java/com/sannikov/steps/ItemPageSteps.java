package com.sannikov.steps;

import com.sannikov.objects.AbstractBase;
import com.sannikov.objects.ItemPage;
import com.sannikov.objects.SearchPage;
import org.springframework.stereotype.Component;
import com.sannikov.core.AppContext;

@Component
public class ItemPageSteps extends BasePageSteps {

    private static final ThreadLocal<ItemPage> ITEM_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private ItemPage getItemPage() {
        return ITEM_PAGE_THREAD_LOCAL.get();
    }

    public void setItemPage(ItemPage itemPage) {
        ITEM_PAGE_THREAD_LOCAL.set(itemPage);
    }

    public SearchPageSteps addToCart() {
        SearchPageSteps searchPageSteps = AppContext.getBean(SearchPageSteps.class);
        searchPageSteps.setSearchPage(AbstractBase.getPage(SearchPage.class));
        getItemPage().getAddToCartButton().click();
        saveClick(getItemPage().getContinueButton());
        return searchPageSteps;
    }

}
