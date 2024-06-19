package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.helper.WebElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {

    @FindBy(xpath = "//*[@id='firstName']")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(xpath = "//*[@id='userEmail']")
    public WebElement emailInput;

    // //input[@name ='gender']
    @FindBy(xpath = "(//div[@class='custom-control custom-radio custom-control-inline'])[1]")
    public WebElement genderFemaleRadioBtn;

    @FindBy(xpath = "(//div[@class='custom-control custom-radio custom-control-inline'])[2]")
    public WebElement genderMaleRadioBtn;

    @FindBy(xpath = "(//div[@class='custom-control custom-radio custom-control-inline'])[3]")
    public WebElement genderOthersRadioBtn;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberInput;

    //react-datepicker__input-container
    @FindBy(className = "react-datepicker__input-container")
    public WebElement datePickerBtn; // Календарь

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(id = "//*[@class ='react-datepicker__month-select']")
    public WebElement monthOfBirthInput;

    @FindBy(id = "//*[@class ='react-datepicker__year-select']")
    public WebElement yearOfBirthInput;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsInput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement sportCheckboxBtn;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement readingCheckboxBtn;

    //"//label[normalize-space(text())='Reading']"
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement musicCheckboxBtn;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public PracticeFormPage fillUpPracticeForm(PracticeFormEntity practiceFormEntity) {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstNameInput())
                .sendKeys(lastNameInput, practiceFormEntity.getLastNameInput())
                .sendKeys(emailInput, practiceFormEntity.getEmailInput())
                .click(selectGender(practiceFormEntity.getGender()))
                .sendKeys(mobileNumberInput, practiceFormEntity.getMobileNumberInput())
                .sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjectsInput())
                .click(selectHobby(practiceFormEntity.getHobby()))
                .sendKeys(uploadPicture, practiceFormEntity.getUploadPicture())
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddressInput())
                .sendKeysWithEnter(stateInput, practiceFormEntity.getStateInput())
                .sendKeysWithEnter(cityInput, practiceFormEntity.getCityInput())
                .click(submitBtn);
        return this;
    }

    private WebElement selectGender(String gender) {
        switch (gender) {
            case "Male":
                return genderMaleRadioBtn;
            case "Female":
                return genderFemaleRadioBtn;
            case "Others":
                return genderOthersRadioBtn;
            default:
                throw new IllegalArgumentException("invalid gender: " + gender);
        }

    }

    private WebElement selectHobby(String hobby) {
        switch (hobby) {
            case "Sports":
                return sportCheckboxBtn;
            case "Reading":
                return readingCheckboxBtn;
            case "Music":
                return musicCheckboxBtn;
            default:
                throw new IllegalArgumentException("Invalid hobby: " + hobby);
        }
    }

    /**
     *
     * @param dateMonthYear
     * @return
     */
    // метод для клика
    @Step("для маркировки методов, которые представляют отдельные шаги или действия внутри тестового метода")
    public PracticeFormPage selectDateMonthYear(String dateMonthYear) { // 04 JUN 2024
        String[] dateMonthYearParts = dateMonthYear.split(" "); // split - это разделить, а с помощью regex- мы ставим пробелы между день месяц год
        String date = dateMonthYearParts[0];
        String month = dateMonthYearParts[1];
        String year = dateMonthYearParts[2];

        webElementActions.click(datePickerBtn);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        WebElement monthDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month-select")));

        WebElement yearDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__year-select")));

        dropdownHelper.selectByVisibleText(monthDropDown, month)
                .selectByVisibleText(yearDropDown, year);
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()='" + date + "']")
        ));
        webElementActions.click(day);
        return this;
    }
}




