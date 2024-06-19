package com.demoqa.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test4 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Создаем экземпляр браузера Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        // Закрываем браузер
        driver.close();
        driver.quit();
    }

    @Test(dataProvider = "textBoxDataProvider")
    public void fillFormAndSubmit(String userName, String userEmail, String currentAddress, String permanentAddress) throws InterruptedException {
        driver.manage().window().maximize();

        // Открываем страницу с формой
        driver.get("https://demoqa.com/text-box");

        // Заполняем поля формы
        fillField("userName", userName);
        fillField("userEmail", userEmail);
        fillField("currentAddress", currentAddress);
        fillField("permanentAddress", permanentAddress);

        // Нажимаем на кнопку Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Ожидание, чтобы убедиться, что форма отправилась и результат отображается
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output"))); // предполагаем, что результат отображается в элементе с id "output"

        // Дополнительная задержка для визуального подтверждения (если нужно)
        Thread.sleep(5000);
    }

    private void fillField(String fieldName, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldName)));
        field.sendKeys(value);
    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][]{
                {"Nargiza", "nargizaknd210986@gmail.com", "21 Pushkina St, Tokmok", "58 Moskovskaya St, Bishkek"},
                {"Alex", "alex@example.com", "123 Main St, Anytown", "456 Elm St, Othertown"},
                {"Maria", "maria@example.com", "789 Oak St, Sometown", "101 Pine St, Everytown"}
        };
    }
}