import com.demoqa.drivers.DriverManager;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseTestPractice {

    protected WebDriver driver;
    protected PracticeFormPage practiceFormPage;
    protected RandomUtils randomUtils;


    @BeforeTest(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        practiceFormPage = new PracticeFormPage();
        randomUtils = new RandomUtils();
    }
}
