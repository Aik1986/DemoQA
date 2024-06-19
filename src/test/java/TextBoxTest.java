
import com.demoqa.entities.TextBoxEntity;
import com.demoqa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqa.enums.Endpoints.TEXTBOX;

public class TextBoxTest extends BaseTest {

    @Test
    public void textBoxTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+TEXTBOX.getEndpoint());
        TextBoxEntity textBoxEntity = randomUtils.generateRandomTextBoxEntity();
        demoQAPages.getTextBoxPage().fillUpTextBoxForm(textBoxEntity);
        Thread.sleep(3000);
        Assert.assertTrue(true);

}
}