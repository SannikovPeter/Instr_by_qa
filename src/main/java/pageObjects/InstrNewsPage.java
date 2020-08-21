package pageObjects;

public class InstrNewsPage extends BasePage {
    private final static String correctURL = "https://instr.by/blog/novosti-ot-instr-by";

    @Override
    public String getURL() {
        return correctURL;
    }
}
