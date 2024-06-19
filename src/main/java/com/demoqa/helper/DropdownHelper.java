package com.demoqa.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownHelper {
    public WebDriver driver;

    public DropdownHelper(WebDriver driver){
        this.driver = driver;
    }
    public DropdownHelper() {
    }

        public DropdownHelper selectByVisibleText(WebElement element, String value) {
            Select select = new Select(element);
            select.selectByVisibleText(value);
            return this;
        }

        public DropdownHelper selectByValueText(WebElement element, String value) {
            Select select = new Select(element);
            select.selectByValue(value);
            return this;

        }

        public DropdownHelper selectByIndex(WebElement element, int index) {
            Select select = new Select(element);
            select.selectByIndex(index);
            return this;

        }

        // Вывод всех элементов выпадающего списка через ЦИКЛ
        public DropdownHelper getOptions(WebElement element) {
            Select select = new Select(element);
            List<WebElement> listOfOptions = select.getOptions();
            for (WebElement item : listOfOptions) {
                System.out.println(item.getText());
            }
            return this;
        }

        // Вывод всех элементов выпадающего списка через СТРИМ
        public DropdownHelper getOptions2(WebElement element) {
            Select select = new Select(element);
            select.getOptions().stream()
                    .map(WebElement::getText)
                    .forEach(System.out::println);
            return this;
        }

        // Вывод всех выбранных элементов выпадающего списка через цикл
        public DropdownHelper getAllSelectedOptions(WebElement element) {
            Select select = new Select(element);
            List<WebElement> listOfAllSelectedOptions = select.getAllSelectedOptions();
            for (WebElement item : listOfAllSelectedOptions) {
                System.out.println(item.getText());
            }
            return this;
        }


    }

