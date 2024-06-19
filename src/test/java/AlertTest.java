
import com.demoqa.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import static com.demoqa.enums.Endpoints.ALERT;


public class AlertTest extends BaseTest {
    @Description("Описание к текстовому методу")
    @Owner("ответственного за выполнение и поддержку теста")
    @Tag("Smoke") // "добавления меток или тегов к тестовым методам, что позволяет лучше структурировать отчеты и фильтровать тесты по их атрибутам.")
    @Severity(SeverityLevel.CRITICAL)//"для определения уровня серьёзности теста")
    @Story("для указания истории или функциональности")
    @Epic("Регистрация")
    @Link("ссылки") // www.google.com
    @Test(groups = {"Smoke", "UI", "1721"}, description = "Alert test")

    void alertTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
//        Thread.sleep(5000);
        alertHelper.acceptAlert(); // принял условия
        webElementActions.pause(5000);
        //alertHelper.dismissAlert();
        Thread.sleep(3000);

    }

    @Test(groups = {"Regression", "API", "1722"}, description = "Alert test 1")
    void alertTest1() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(5000);
        // alertHelper.acceptAlert(); // принял условия
        alertHelper.dismissAlert();
        Thread.sleep(3000);

    }

    @Test(groups = {"E2E", "SQL", "1723"}, description = "Alert test 2")
    void alertTest2() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        //driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        Thread.sleep(5000);
        // alertHelper.acceptAlert(); // принял условия
        alertHelper.dismissAlert();
        Thread.sleep(3000);
    }
}