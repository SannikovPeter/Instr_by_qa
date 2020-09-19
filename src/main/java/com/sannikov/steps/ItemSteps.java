package com.sannikov.steps;

import com.sannikov.objects.elements.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemSteps extends BaseSteps {

    private static final ThreadLocal<Item> ITEM_THREAD_LOCAL = new ThreadLocal<>();

    private Item getItem() {
        return ITEM_THREAD_LOCAL.get();
    }

    public void setItem(Item item) {
        ITEM_THREAD_LOCAL.set(item);
    }

    public void addItemToCart() {
        try {
            moveTo(getItem().getWrappedElement());
            saveClick(getItem().getAddToCartButton());
        } catch (Exception e) {
            scrollWindow(100);
            saveClick(getItem().getAddToCartButton());
        }
    }

    public String getItemName() {
        return getItem().getName();
    }
}
