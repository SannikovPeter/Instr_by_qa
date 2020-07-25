import core.BrowserManager;
import core.PropertiesManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.MainPageSteps;

public class AllTestsSettings {

    private PropertiesManager propertiesManager = new PropertiesManager();
    protected BrowserManager browserManager = new BrowserManager();
    protected MainPageSteps mainPageSteps;
    protected String loginName = propertiesManager.getName();
    protected String loginPassword = propertiesManager.getPassword();

    @BeforeTest
    public void startTest(){
        browserManager.createBrowser();
        mainPageSteps = browserManager.getMainPageSteps();
    }

    @AfterTest
    public void stop() {
        browserManager.closeBrowser();
    }

}
