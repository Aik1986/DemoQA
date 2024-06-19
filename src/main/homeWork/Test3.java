package com.demoqa.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test3 {
    WebDriver driver;

    // Этот метод инициализирует WebDriver и открывает нужный URL перед всеми тестами.
    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        //Thread.sleep(5000);
    }
    // Этот метод закрывает и завершает работу WebDriver после всех тестов.
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    // Этот тест заполняет поле name
    @Test(priority = 1)
    public void testFullName() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Aikanysh Mukanbetova");
    }

    // Этот тест заполняет поле email
    @Test(priority = 2)
    public void testEmail() {
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("mukanbet1986@gmail.com");
    }

    // Этот тест заполняет поле currentAddress
    @Test(priority = 3)
    public void testCurrentAddress() {
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("20 Togolok Moldo St, Tokmok, KG");
    }

    // Этот тест заполняет поле permanentAddress
    @Test(priority = 4)
    public void testPermanentAddress() {
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("20 Togolok Moldo St, Tokmok, KG");
    }

    // Этот тест скролит и нажимает кнопку submit
    @Test(priority = 5)
    public void testSubmitButton() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        // Скроллим страницу до кнопки submit. Используется JavascriptExecutor для выполнения JavaScript кода, который прокручивает страницу до элемента submitButton.
        //Метод executeScript с аргументом "arguments[0].scrollIntoView(true);" прокручивает страницу так, чтобы элемент submitButton стал видимым.
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();

//            // либо используем Actions для прокрутки до элемента submitButton вместо джаваскрипта
//            Actions actions = new Actions(driver);
//            actions.moveToElement(submitButton);
//            // Выполняем действие
//            actions.perform();

    }

}