import com.demoqa.pages.DemoQAPages;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.PROGRESSBAR;
import static org.testng.Assert.assertEquals;

public class ProgressBarTest extends BaseTest {

    @Test(description = "")
    public void progressBarTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+PROGRESSBAR.getEndpoint());
//        webElementActions.click(progressBarPage.startStopButton);
        demoQAPages.getProgressBarPage();
        Thread.sleep(2000);
        webElementActions.click(demoQAPages.getProgressBarPage().startStopButton);
        Thread.sleep(6000);

        System.out.println(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"));
        assertEquals(demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow"), "70");

    }

    @Test(description = "Test progress bar stopping at 52%")
    public void testProgressBarAt52Percent1() {
        browserHelper.open(ConfigReader.getValue("baseURL")+PROGRESSBAR.getEndpoint());
        demoQAPages.getProgressBarPage().startProgressBar();
        while (true) {

            String value = demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow");
            System.out.println("Current progress: " + value + "%");
            if (value.equals("52")) {
                demoQAPages.getProgressBarPage().startStopButton.click();
                break;
            }
        }
        String progressBarValue = demoQAPages.getProgressBarPage().aria_valuenow.getAttribute("aria-valuenow");
        assertEquals(progressBarValue, "52", "Progress bar should beat 52%");
    }

}

