package com.demoqa.utils;

import com.demoqa.entities.Employee;
import com.demoqa.entities.PracticeFormEntity;
import com.demoqa.entities.TextBoxEntity;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    Faker faker = new Faker();
    Random random = new Random();

    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generalRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstNameInput(faker.name().firstName());
        practiceFormEntity.setLastNameInput(faker.name().lastName());
        practiceFormEntity.setEmailInput(faker.internet().emailAddress());
        practiceFormEntity.setGender(randomGender());
        practiceFormEntity.setMobileNumberInput(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setMonthOfBirthInput("April");
        practiceFormEntity.setYearOfBirthInput("2024");
        practiceFormEntity.setSubjectsInput("h");
        practiceFormEntity.setHobby(randomHobby());
        practiceFormEntity.setCurrentAddressInput(faker.address().fullAddress());
        practiceFormEntity.setStateInput("Uttar");
        practiceFormEntity.setCityInput("Agra");
        practiceFormEntity.setUploadPicture("C:\\Users\\Айка\\Desktop\\gpeg.jpg");
        return practiceFormEntity;

    }

    private String randomGender() {
        List<String> genders = Arrays.asList("Male", "Female", "Others");
        return genders.get(random.nextInt(genders.size()));
    }

    private String randomHobby() {
        List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
        return hobbies.get(random.nextInt(hobbies.size()));
    }

    //Создаем метод который будет
    public Employee createMockEmployee() {
        Employee employee = new Employee();

        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18, 100));
        //employee.setEmail("cierra@example.com");
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(1000000l,2000000000l));
        employee.setDepartment(faker.job().position());

        return employee;

    }


}