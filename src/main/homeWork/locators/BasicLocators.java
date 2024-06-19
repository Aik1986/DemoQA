package com.demoqa.homeWork.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BasicLocators {
    @Test(description = "Find by ID")
void fiindByIdTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver(); // driver, чтобы управлять браузером
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize(); // это команда чтобы мы увеличили страницу
        driver.get("https://demoqa.com/text-box"); // код/ссылка сайта


        // ищем по ID
//        WebElement fullNameInput = driver.findElement(By.id("userName"));
//        fullNameInput.sendKeys("Aika");
//         ищем по классу
//        WebElement emailInput = driver.findElement(By.className("mr-sm-2"));
//        emailInput.sendKeys("Aika");

        // ищем по тегу
//        WebElement inputInput = driver.findElement(By.tagName("input"));
//        inputInput.sendKeys("Aika");


        // ищем по текст ( покажет на консоле)
//        String textBoxText = driver.findElement(By.tagName("h1")).getText();
//        System.out.println(textBoxText);

        //  ищем по ссылке (Меняем ссылку, берем с сайта)
       // driver.get("https://demoqa.com/links"); // код/ссылка сайта links
//        WebElement homeLink = driver.findElement(By.linkText("Home"));
//        homeLink.click();

 // поиск по части ссылки, текста
//        WebElement partial = driver.findElement(By.partialLinkText("Not"));
//        partial.click();


        // чтобы использовать xpath
        //чтобы
        WebElement xpathhh = driver.findElement(By.xpath("(//textarea[@class='form-control'])[1]"));
      xpathhh.sendKeys("Nkjhv");

      String permanent = driver.findElement(By.xpath("//label[text()='permanentAddress']")).getText();
        System.out.println(permanent);
    }
}
