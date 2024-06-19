package com.demoqa.pages;

import com.demoqa.drivers.DriverManager;
import com.demoqa.entities.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WebTablePages extends BasePage {
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "age")
    public WebElement ageInput;
    @FindBy(id = "userEmail")
    public WebElement emailInput;
    @FindBy(id = "salary")
    public WebElement salaryInput;
    @FindBy(id = "department")
    public WebElement departmentInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;


    public WebTablePages addNewEmployee(Employee employee) {
        boolean emailExists = getEmployeesFormTable().stream().anyMatch(e -> e.getEmail().equals(employee.getEmail()));

        if (emailExists) {
            throw new IllegalArgumentException("This email already exists: " + employee.getEmail());
        }
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput, employee.getFirstName())
                .sendKeys(lastNameInput, employee.getLastName())
                .sendKeys(ageInput, String.valueOf(employee.getAge()))
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput, employee.getDepartment())
                .click(submitBtn);
        return this;
    }

    public ArrayList<Employee> getEmployeesFormTable() {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        ArrayList<Employee> employees = new ArrayList<>(); // spisok vseh elementov sotrudnika vsya ego info

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", ""); // если случайно добавят цифру
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]", "");
            String department = cells.get(5).getText();

            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() || salaryText.isEmpty() || department.isEmpty()) {
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            long salary = Long.parseLong(salaryText.trim()); // для того чтобы
            boolean emailExists = employees.stream().anyMatch(e -> e.getEmail().equals(email));
            if (!emailExists) {
                employees.add(new Employee(firstName, lastName, age, email, salary, department));
            }
        }

        return employees;
    }
     //метод для удаления сотрудника по email
    public WebTablePages editEmployeeData(String email, String oldValue, String newValue) {

        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            if (cells.size() > 3 && cells.get(3).getText().equals(email)) {
                WebElement editBtn = row.findElement(By.cssSelector("#edit-record-1"));
                webElementActions.click(editBtn);
                // uslovie dlya zameny starogo value na new value
                switch (oldValue) {
                    case "firstName":
                        WebElement firstNameInput = DriverManager.getDriver().findElement(By.id("firstName"));
                        webElementActions.clear(firstNameInput)
                                .sendKeys(firstNameInput, newValue);
                        break;
                    case "lastName":
                        WebElement lastNameInput = DriverManager.getDriver().findElement(By.id("lastName"));
                        webElementActions.clear(lastNameInput)
                                .sendKeys(lastNameInput, newValue);
                        break;
                    case "age":
                        WebElement ageInput = DriverManager.getDriver().findElement(By.id("age"));
                        webElementActions.clear(ageInput)
                                .sendKeys(ageInput, newValue);
                        break;
                    case "email":
                        WebElement emailInput = DriverManager.getDriver().findElement(By.id("userEmail"));
                        webElementActions.clear(emailInput)
                                .sendKeys(emailInput, newValue);
                        break;
                    case "salary":
                        WebElement salaryInput = DriverManager.getDriver().findElement(By.id("salary"));
                        webElementActions.clear(salaryInput)
                                .sendKeys(salaryInput, newValue);
                        break;
                    case "department":
                        WebElement departmentInput = DriverManager.getDriver().findElement(By.id("department"));
                        webElementActions.clear(departmentInput)
                                .sendKeys(departmentInput, newValue);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field : " + oldValue);
                }
                // Save updated information
                WebElement submitBtn = DriverManager.getDriver().findElement(By.cssSelector("#submit"));
                webElementActions.click(submitBtn);
                break;
            }
        }
        return this;
    }

    // Метод для удаления сотрудника по email
    public WebTablePages deleteEmployeeByEmail(String email) {
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            if (cells.size() > 3 && cells.get(3).getText().equals(email)) {
                WebElement deleteBtn = row.findElement(By.cssSelector("span[id^='delete-record-']"));
                webElementActions.click(deleteBtn);
                break;
            }
        }
        return this;
    }
}

