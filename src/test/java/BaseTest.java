import com.demoqa.drivers.DriverManager;
import com.demoqa.helper.*;
import com.demoqa.pages.*;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected WebDriver driver;

    protected RandomUtils randomUtils;

    protected WebElementActions webElementActions;

    protected AlertHelper alertHelper;

    protected BrowserHelper browserHelper;

    protected DemoQAPages demoQAPages;

    protected DropdownHelper dropdownHelper;

   protected IframeHelper iframeHelper;


@BeforeSuite(alwaysRun = true)
public void setUp(){

}



    @BeforeClass(alwaysRun = true)
    public void setUp1() {
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        demoQAPages = new DemoQAPages();
        dropdownHelper = new DropdownHelper(driver);
        iframeHelper = new IframeHelper(driver);
        demoQAPages.setUp();  // Вызов метода для инициализации страниц, созданного в DemoQAPages



    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()  {
        DriverManager.closeDriver();
}
}