package com.demoqa.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TextBoxHW {
  private WebDriver driver;


    @BeforeMethod
    void textBoxTest2(String str, String expected) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
       // Thread.sleep(5000);
    }
        @Test
        void testFullName(){
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Aikanysh");

    }

    @DataProvider(name = "textBoxDataProvider")
    public Object[][] textBoxDataProvider(){
        return new Object[][]{
                {"userName", "Aikanysh Mukanbetova"},
                {"userEmail", "mukanbet1986@gmail.com"},
                {"currentAddress", "Tokmok. u.T.Moldo, 20"},
                {"permanentAddress", "Tokmok. u.T.Moldo, 20"}
        };

}
}