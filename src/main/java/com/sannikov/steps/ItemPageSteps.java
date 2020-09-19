package com.sannikov.steps;

import com.sannikov.objects.pages.ItemPage;
import org.springframework.stereotype.Component;

@Component
public class ItemPageSteps extends BaseSteps {

    private static final ThreadLocal<ItemPage> ITEM_PAGE_THREAD_LOCAL = new ThreadLocal<>();

    private ItemPage getItemPage() {
        return ITEM_PAGE_THREAD_LOCAL.get();
    }

    public void setItemPage(ItemPage itemPage) {
        ITEM_PAGE_THREAD_LOCAL.set(itemPage);
    }

}
