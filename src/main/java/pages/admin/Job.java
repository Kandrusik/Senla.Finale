package pages.admin;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Job {

    SelenideElement addJobTitles = $(By.id("btnAdd"));
    SelenideElement deleteJobTitles = $(By.id("btnDelete"));
    SelenideElement dialogDeleteJob = $(By.id("dialogDeleteBtn"));

    SelenideElement jobTitle = $(By.id("jobTitle_jobTitle"));
    SelenideElement jobDescription = $(By.id("jobTitle_jobDescription"));
    SelenideElement jobNote = $(By.id("jobTitle_note"));
    SelenideElement saveJob = $(By.id("btnSave"));
    ElementsCollection selectRom = $$(By.xpath("//*[@name=\"chkSelectRow[]\"]"));
    public SelenideElement welcomeMessage = $(By.cssSelector(".head"));


    public Job jobDescription(String job_title, String job_description, String note) {
        jobTitle.sendKeys(job_title);
        jobDescription.sendKeys(job_description);
        jobNote.sendKeys(note);
        return this;
    }

    public Job setAddJobButton() {
        addJobTitles.click();
        return this;
    }

    public Job setDelete() {
        selectRom.first().click();
        deleteJobTitles.click();
        dialogDeleteJob.click();
        welcomeMessage.shouldHave(text("Job Titles"));
        selectRom.first().click();
        deleteJobTitles.click();
        dialogDeleteJob.click();
        welcomeMessage.shouldHave(text("Job Titles"));
        selectRom.first().click();
        deleteJobTitles.click();
        dialogDeleteJob.click();
        welcomeMessage.shouldHave(text("Job Titles"));
        return this;
    }

    public Job setSaveJobButton() {
        saveJob.click();
        return this;
    }
}