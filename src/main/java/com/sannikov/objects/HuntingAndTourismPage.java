package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class HuntingAndTourismPage extends HeaderPage {

    private final static String correctURL = "https://instr.by/blog/travel-hunting";

    @Override
    public String getURL() {
        return correctURL;
    }
}
