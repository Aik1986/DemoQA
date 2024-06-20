import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.PRACTICEFORM;
import static org.testng.Assert.assertEquals;
// @Listeners(com.demoqa.listener.ScreenshotListener.class)
public class PracticeFormTest extends BaseTest {

//    @Test
//    public void testPracticeForms() {
//         browserHelper.open(ConfigReader.getValue("baseDevURL")+PRACTICEFORM.getEndpoint());
//        PracticeFormEntity practiceFormEntity = randomUtils.generalRandomPracticeFormEntity();
//        demoQAPages.practiceFormPage.fillUpPracticeForm(practiceFormEntity);
//        String confirmationMessage = driver.findElement(By.xpath("//*[text()='Thanks for submitting the form']")).getText();
//        assertEquals(confirmationMessage, "Thanks for submitting the form");

//

    @Test
    public void test123() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+PRACTICEFORM.getEndpoint());
        demoQAPages.getPracticeFormPage().selectDateMonthYear("30 June 2020");
        Thread.sleep(4000);

        //LocalDate
        //LocalTime

    }
}
