package pageObjects;

public class BlogPage extends BasePage {
    private final static String correctURL = "https://instr.by/blog";

    @Override
    public String getURL() {
        return correctURL;
    }
}
