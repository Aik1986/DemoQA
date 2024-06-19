import com.demoqa.enums.Endpoints;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test(description = "Verify that driver can switch to another frame")
    void doubleClickTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ Endpoints.FRAMES.getEndpoint());
        iframeHelper.switchTofFrame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        iframeHelper.switchToParentFrame();
        System.out.println(driver.findElement(By.tagName("h1")).getText());


    }
}
