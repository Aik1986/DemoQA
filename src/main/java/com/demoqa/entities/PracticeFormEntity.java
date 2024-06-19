package com.demoqa.entities;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PracticeFormEntity {
    private String firstNameInput;
    private String lastNameInput;
    private String emailInput;
    private String gender;
    private String mobileNumberInput;
    private String subjectsInput;
    private String hobby;
    private String currentAddressInput;
    private String stateInput;
    private String cityInput;
    private String uploadPicture;
    private String dateOfBirthInput;
    private String monthOfBirthInput;
    private String yearOfBirthInput;

}
