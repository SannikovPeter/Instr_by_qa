package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class AboutUsPage extends BasePage {
    private final static String correctURL = "https://instr.by/aboutus";

    @Override
    public String getURL() {
        return correctURL;
    }
}
