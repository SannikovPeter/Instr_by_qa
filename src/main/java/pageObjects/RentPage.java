package pageObjects;

public class RentPage extends BasePage {
    private final static String correctURL = "https://instr.by/arenda";

    @Override
    public String getURL() {
        return correctURL;
    }
}
