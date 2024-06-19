import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    public static void main(String[] args) {


        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("httr://example.com");
            FluentWait <WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30)) //  в течение 30 секунд он будет каждые 3 секунды проверять
                    .pollingEvery(Duration.ofSeconds(3)) // элемент, если ошибка выходит он игнорит, итак до того как найдет этот элемент
                            .ignoring(NoSuchElementException.class);


        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("someId"));
            }
        });
            element.click();
            }finally {
            driver.quit();
        }
    }
}
