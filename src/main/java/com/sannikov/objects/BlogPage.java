package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class BlogPage extends BasePage {
    private final static String correctURL = "https://instr.by/blog";

    @Override
    public String getURL() {
        return correctURL;
    }
}
