package pageObjects;

public class MainPage extends BasePage {
    private final static String correctURL = "https://instr.by/";

    @Override
    public String getURL() {
        return correctURL;
    }
}
