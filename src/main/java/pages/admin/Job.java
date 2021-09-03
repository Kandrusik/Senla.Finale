package pages.admin;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Job {

    SelenideElement addJobTitles = $(By.id("btnAdd"));
    SelenideElement deleteJobTitles = $(By.id("btnDelete"));
    SelenideElement dialogDeleteJob = $(By.id("dialogDeleteBtn"));
    SelenideElement jobTitle = $(By.id("jobTitle_jobTitle"));
    SelenideElement jobDescription = $(By.id("jobTitle_jobDescription"));
    SelenideElement jobNote = $(By.id("jobTitle_note"));
    SelenideElement saveJob = $(By.id("btnSave"));
    SelenideElement jobPhoto = $(By.id("jobTitle_jobSpec"));

    File file = new File("src/main/resources/testPhoto.jpg");

    @Step("Deleting Created Job")
    public Job setDeleteJobTitlesButton() {
        deleteJobTitles.click();
        dialogDeleteJob.click();
        return this;
    }

    @Step("Checking the visibility of work")
    public Job checkTheVisibilityOfWork(String job) {
        SelenideElement clickOnJobFlag = $(By.xpath("//a[text()='" + job + "']/../..//*[@name=\"chkSelectRow[]\"]"));
        clickOnJobFlag.shouldNotHave(visible);
        return this;
    }

    @Step("Clicking on a flag by name")
    public Job clickOnJobFlag(String name) {
        SelenideElement clickOnJobFlag = $(By.xpath("//a[text()='" + name + "']/../..//*[@name=\"chkSelectRow[]\"]"));
        clickOnJobFlag.click();
        return this;
    }

    @Step("Filling in the job description fields")
    public Job jobDescription(String job_title, String job_description, String note) {
        jobTitle.sendKeys(job_title);
        jobDescription.sendKeys(job_description);
        jobPhoto.uploadFile(file);
        jobNote.sendKeys(note);
        return this;
    }

    @Step("Clicking on the add work button")
    public Job setAddJobButton() {
        addJobTitles.click();
        return this;
    }

    @Step("Button to save work")
    public Job setSaveJobButton() {
        saveJob.click();
        return this;
    }
}