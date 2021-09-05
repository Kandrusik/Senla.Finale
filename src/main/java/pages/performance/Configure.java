package pages.performance;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Configure {

    public SelenideElement messageSearchKeyPerformance = $(By.xpath("//*[@id=\"divFormContainer\"]//*[text()='Search Key Performance Indicators']"));
    SelenideElement addKeyPerformance = $(By.id("btnAdd"));
    SelenideElement listOfJobTitle = $(By.id("defineKpi360_jobTitleCode"));
    SelenideElement chooseQALead = $(By.xpath("//*[@class='formSelect']//*[text()='QA Automation  Engineer']"));
    SelenideElement keyPerformanceIndicators = $(By.id("defineKpi360_keyPerformanceIndicators"));
    SelenideElement minRating = $(By.id("defineKpi360_minRating"));
    SelenideElement maxRating = $(By.id("defineKpi360_maxRating"));
    SelenideElement makeDefaultButton = $(By.id("defineKpi360_makeDefault"));
    SelenideElement saveButton = $(By.id("saveBtn"));
    SelenideElement deleteKeyButton = $(By.id("btnDelete"));
    SelenideElement acceptDeleteKeyButton = $(By.id("dialogDeleteBtn"));

    @Step("Checking the deletion of an employee by ID")
    public void clickOnKeyPerformanceFlag(String keyIndicator) {
        SelenideElement keyPerformanceFlag = $(By.xpath("//a[text()='" + keyIndicator + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        keyPerformanceFlag.click();
    }

    @Step("Checking the deletion of an employee by ID")
    public void checkKeyPerformanceFlag(String keyIndicator) {
        SelenideElement keyPerformanceFlag = $(By.xpath("//a[text()='" + keyIndicator + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        keyPerformanceFlag.shouldNotHave(visible);
    }

    @Step("Set delete key button")
    public Configure setDeleteKeyButton() {
        deleteKeyButton.click();
        return this;
    }

    @Step("Set accept delete key button")
    public Configure setAcceptDeleteKeyButton() {
        acceptDeleteKeyButton.click();
        return this;
    }

    @Step("Set save button")
    public Configure setSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("change of personal information")
    public Configure changePersonalInformation(String key_performance_indicators, String min_rating, String max_rating) {
        listOfJobTitle.click();
        chooseQALead.click();
        keyPerformanceIndicators.sendKeys(key_performance_indicators);
        minRating.clear();
        minRating.sendKeys(min_rating);
        maxRating.clear();
        maxRating.sendKeys(max_rating);
        makeDefaultButton.click();
        return this;
    }

    @Step("Set add key performance button")
    public Configure setAddKeyPerformanceButton() {
        addKeyPerformance.click();
        return this;
    }
}