package pageObjects;

public class ServicePage extends BasePage {
    private final static String correctURL = "https://instr.by/servis";

    @Override
    public String getURL() {
        return correctURL;
    }
}
