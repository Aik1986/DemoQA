import com.demoqa.helper.WebElementActions;
import com.demoqa.utils.ConfigReader;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.MENU;

public class MenuTest extends BaseTest{

    @Test(description = "Verify move to element methods is working ")
    public void moveToElementTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+MENU.getEndpoint());
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
        Thread.sleep(5000);
    }
}
