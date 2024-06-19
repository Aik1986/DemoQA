package com.demoqa.helper;

import com.demoqa.drivers.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {
    private WebDriver driver = DriverManager.getDriver();

    // создаем конструктор этого класса, принимает в качестве параметра драйвер
    public AlertHelper(WebDriver driver) {
        this.driver = driver;
    }

    public Alert getAlert() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent()); // жди пока alert  не появится
        return driver.switchTo().alert(); // переключается с html кода в alert
    }

    public void acceptAlert() {
        getAlert().accept();  // accept принимает условия

    }

    public void dismissAlert() {
        getAlert().dismiss();  // dismiss не принимает условия
    }

    public String getAlertText() {
        return getAlert().getText();
    }

    //проверка alerta есть или нет
    public boolean isAlertPresented() {
        try {
            driver.switchTo().alert().accept(); // если есть прими его, если принял то возврати true
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void acceptAlertIfPresented() {
        if (!isAlertPresented()) // если alert нет, остановись
            return;
        acceptAlert(); // если есть принимает

    }

    public void dismissAlertIfPresented(){
        if (!isAlertPresented()) // если alerta (cancel) нет, то остановись
            return;
        dismissAlert();

    }

    public void acceptPrompt(String txt){
        if(!isAlertPresented()) // если нет alerta, то останавливаем на этом этапе
            return;
        Alert alert = getAlert(); // если есть находим alert, Пишем и нажимаем cancel
        alert.sendKeys(txt);
        alert.accept();

    }

}
