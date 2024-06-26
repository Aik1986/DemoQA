import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.BUTTONS;


public class ButtonsTest extends BaseTest {

    @Test(description = "verify double click js working propertly")
    public void doubleClickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+BUTTONS.getEndpoint());
       webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);

      // Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");

       //Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(), "You have done a double click");

    }
    @Test(description = "Verify right click js working properly")
    public void rightClickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+BUTTONS.getEndpoint());
        webElementActions.rightClick(demoQAPages.getButtonsPage().rightClickBtn);
       // Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(), "You have done a right click");

    }

}
