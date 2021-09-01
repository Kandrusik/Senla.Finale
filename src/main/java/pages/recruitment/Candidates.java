package pages.recruitment;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.admin.Job;

import static com.codeborne.selenide.Selenide.$;

public class Candidates {

    SelenideElement addCandidates = $(By.id("btnAdd"));
    SelenideElement saveCandidates = $(By.id("btnSave"));
    SelenideElement backToCandidates = $(By.id("btnBack"));
    SelenideElement deleteCandidates = $(By.id("btnDelete"));
    SelenideElement acceptDeleteCandidates = $(By.id("dialogDeleteBtn"));



    SelenideElement firstNameCandidates = $(By.id("addCandidate_firstName"));
    SelenideElement middleNameCandidates = $(By.id("addCandidate_middleName"));
    SelenideElement lastNameCandidates = $(By.id("addCandidate_lastName"));
    SelenideElement emailCandidates = $(By.id("addCandidate_email"));
    SelenideElement contactCandidates = $(By.id("addCandidate_contactNo"));
    SelenideElement keywordsCandidates = $(By.id("addCandidate_keyWords"));

    SelenideElement vacancyCandidates = $(By.id("addCandidate_vacancy"));
    SelenideElement softwareEngineerVacancy = $(By.cssSelector("option:nth-child(8)"));

    SelenideElement commentCandidates = $(By.id("addCandidate_comment"));
    SelenideElement dateCandidates = $(By.id("addCandidate_appliedDate"));
    SelenideElement toKeepDataCandidates = $(By.id("addCandidate_consentToKeepData"));

    public SelenideElement acceptCandidateOnThePage = $(By.xpath("//a[text()='Egor Aleksandrov Zalesky']"));

    public Candidates setAcceptDeleteCandidatesButton() {
        acceptDeleteCandidates.click();
        return this;
    }

    public Candidates setDeleteCandidatesButton() {
        deleteCandidates.click();
        return this;
    }

    public Candidates setBackToCandidates() {
        backToCandidates.click();
        return this;
    }

    public Candidates setSaveCandidates() {
        saveCandidates.click();
        return this;
    }

    public Candidates setAddCandidates() {
        addCandidates.click();
        return this;
    }

    public Candidates candidateDescription(String first_name, String middle_name, String last_name, String email, String contact_NO, String keywords, String comment, String date_of_application) {
        firstNameCandidates.sendKeys(first_name);
        middleNameCandidates.sendKeys(middle_name);
        lastNameCandidates.sendKeys(last_name);
        emailCandidates.sendKeys(email);
        contactCandidates.sendKeys(contact_NO);
        vacancyCandidates.click();
        softwareEngineerVacancy.click();
        keywordsCandidates.sendKeys(keywords);
        commentCandidates.sendKeys(comment);
        dateCandidates.clear();
        dateCandidates.sendKeys(date_of_application, Keys.ENTER);
        toKeepDataCandidates.click();
        return this;
    }
}