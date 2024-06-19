package com.demoqa.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dostavka312K {

    WebDriver driver;

    @BeforeClass
    void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://dostavka312.kg/");
    }
    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
       @Test
               public void openLinks(){
           WebElement mainmenu = driver.findElement(By.xpath("//*[@id=\"tab-01\"]/div/p/a/img"));
           mainmenu.click();
           WebElement kmenu = driver.findElement(By.xpath(""));
    }
}
