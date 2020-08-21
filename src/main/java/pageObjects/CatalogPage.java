package pageObjects;

public class CatalogPage extends BasePage {

    private final static String correctURL = "https://instr.by/catalog";

    @Override
    public String getURL() {
        return correctURL;
    }


}
