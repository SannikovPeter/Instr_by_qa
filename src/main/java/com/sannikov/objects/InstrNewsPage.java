package com.sannikov.objects;

import org.springframework.stereotype.Component;

@Component
public class InstrNewsPage extends BasePage {
    private final static String correctURL = "https://instr.by/blog/novosti-ot-instr-by";

    @Override
    public String getURL() {
        return correctURL;
    }
}
