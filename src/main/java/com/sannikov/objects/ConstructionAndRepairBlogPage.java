package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class ConstructionAndRepairBlogPage extends HeaderPage {

    private final static String correctURL = "https://instr.by/blog/strojka-i-remont";

    @Override
    public String getURL() {
        return correctURL;
    }
}
