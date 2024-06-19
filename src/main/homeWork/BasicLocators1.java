package com.demoqa.homeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class BasicLocators1 {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "textBoxDataProvider")
    public void textBoxTest(String name, String email, String currAddress, String permAddress) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys(name);

        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(email);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(currAddress);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(permAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String text1 = driver.findElement(By.xpath("//p[@id='name']")).getText();
        String text2 = driver.findElement(By.xpath("//p[@id='email']")).getText();
        String text3 = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String text4 = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();

        // Assert the output
        Assert.assertEquals(text1, "Name:" + name);
        System.out.println(text1);
        Assert.assertEquals(text2, "Email:" + email);
        System.out.println(text2);
        Assert.assertEquals(text3, "Current Address :" + currAddress);
        System.out.println(text3);
        Assert.assertEquals(text4, "Permananet Address :" + permAddress);
        System.out.println(text4);
    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider() {
        return new Object[][]{
                {"Aikanysh Mukanbetova", "mukanbet1986@gmail.com", "Elebaeva 3 - 77", "via U.Foscolo 9"}
        };
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}