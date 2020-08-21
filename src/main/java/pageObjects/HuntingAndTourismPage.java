package pageObjects;

public class HuntingAndTourismPage extends BasePage {

    private final static String correctURL = "https://instr.by/blog/travel-hunting";

    @Override
    public String getURL() {
        return correctURL;
    }
}
