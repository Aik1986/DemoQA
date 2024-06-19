package com.demoqa.pages;

import lombok.*;
import org.testng.annotations.BeforeClass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class DemoQAPages extends BasePage{

    public TextBoxPage textBoxPage;

    public PracticeFormPage practiceFormPage;

    public AlertPage alertPage;

    public ButtonsPage buttonsPage;

    public MenuPage menuPage;

    public ProgressBarPage progressBarPage;

    public SelectMenuPage selectMenuPage;

    public WebTablePages webTablePages;

    public FramePage framePage;



    // Метод для инициализации страниц
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        textBoxPage = new TextBoxPage();
        practiceFormPage = new PracticeFormPage();
        alertPage = new AlertPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        selectMenuPage = new SelectMenuPage();
        webTablePages = new WebTablePages();
        framePage = new FramePage();




}
}
