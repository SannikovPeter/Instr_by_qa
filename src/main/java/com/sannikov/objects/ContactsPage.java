package com.sannikov.objects;

public class ContactsPage extends BasePage {

    private final static String correctURL = "https://instr.by/feedback";

    @Override
    public String getURL() {
        return correctURL;
    }
}
