package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class MainPage extends HeaderPage {
    private final static String correctURL = "https://instr.by/";

    @Override
    public String getURL() {
        return correctURL;
    }
}
