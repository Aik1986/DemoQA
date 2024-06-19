package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SelectMenuPage extends BasePage {

    @FindBy(id = "selectOne")
    public WebElement selectOne;

    @FindBy(id = "withOptGroup")
    public WebElement selectValue;

    @FindBy(xpath= "//*[@class=' css-1hwfws3']/div[contains(text(), 'Select...')]")
    public WebElement select;

    @FindBy(id = "cars")
    public WebElement cars;

    // кликает на поля select

    /**
     *
     * @param divElement
     * @param optionsXPath
     * @return
     */
    // метод для клика
    @Step("для маркировки методов, которые представляют отдельные шаги или действия внутри тестового метода")
    public List<String> getAllDivOptions(WebElement divElement, String optionsXPath) {
        divElement.click();
        List<WebElement> options = DriverManager.getDriver().findElements(By.xpath(optionsXPath));
        return options.stream().map(WebElement::getText).collect(Collectors.toList());
    }


// //*[@class=' css-26l3qy-menu']
public List<String> getSelectOneOptions() {

        return getAllDivOptions(selectOne, "//*[@class=' css-26l3qy-menu']");
}

    public List<String> getSelectValueOptions() {
        return getAllDivOptions(selectValue, " //*[@class=' css-26l3qy-menu']");
    }

    public List<String> getMultiSelectDropDownOptions() {
        return getAllDivOptions(select, " //*[@class=' css-26l3qy-menu']");
    }

    // //select[@id='cars']/option
    public List<String> getStandardMultiSelectDropDownOptions() {
        return getAllDivOptions(cars, "//*[@id='cars']/option");
    }
}
