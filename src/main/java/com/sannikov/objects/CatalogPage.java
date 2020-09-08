package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class CatalogPage extends HeaderPage {

    private final static String correctURL = "https://instr.by/catalog";

    @Override
    public String getURL() {
        return correctURL;
    }


}
