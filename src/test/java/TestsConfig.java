import core.AppContext;
import core.BrowserManager;
import core.PropertiesManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import steps.MainPageSteps;


public class TestsConfig {

    protected MainPageSteps mainPageSteps;
    private final PropertiesManager propertiesManager = new PropertiesManager();
    protected String loginName = propertiesManager.getName();
    protected String loginPassword = propertiesManager.getPassword();
    //    protected BrowserManager browserManager = new BrowserManager();
    private BrowserManager browserManager;

    @BeforeTest
    public void startTest() {
        browserManager = AppContext.getBean(BrowserManager.class);
        browserManager.startBrowser();
        mainPageSteps = new MainPageSteps();
    }

    @AfterTest
    public void stop() {
        browserManager.closeBrowser();
    }

}
