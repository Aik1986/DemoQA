package com.demoqa.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {
    @Test
    void textBoxTest() throws InterruptedException {
        //         сайт где мы будем практиковаться
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // driver, чтобы управлять браузером
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize(); // это команда чтобы мы увеличили страницу
        driver.get("https://demoqa.com/text-box"); // код/ссылка сайта
        Thread.sleep(5000);
    }
}
//    @Test(priority = 1);
//    WebElement fullName = driver.findElement(By.id("userName"));
//    fullName.sendKeys("Aika");
//
////    driver.close();
////    driver.quit();
//}
//}

//currentAddress