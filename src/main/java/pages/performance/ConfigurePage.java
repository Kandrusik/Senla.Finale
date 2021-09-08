package pages.performance;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ConfigurePage {

    public SelenideElement messageSearchKeyPerformance = $(By.xpath("//*[@id=\"divFormContainer\"]//*[text()='Search Key Performance Indicators']"));
    SelenideElement addKeyPerformance = $(By.id("btnAdd"));
    SelenideElement listOfJobTitle = $(By.id("defineKpi360_jobTitleCode"));
    SelenideElement chooseQALead = $(By.xpath("//*[@class='formSelect']//*[text()='QA Lead']"));
    SelenideElement keyPerformanceIndicators = $(By.id("defineKpi360_keyPerformanceIndicators"));
    SelenideElement minRatings = $(By.id("defineKpi360_minRating"));
    SelenideElement maxRatings = $(By.id("defineKpi360_maxRating"));
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
    public ConfigurePage clickSetDeleteKeyButton() {
        deleteKeyButton.click();
        return this;
    }

    @Step("Set accept delete key button")
    public ConfigurePage clickSetAcceptDeleteKeyButton() {
        acceptDeleteKeyButton.click();
        return this;
    }

    @Step("Set save button")
    public ConfigurePage clickSetSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("change of personal information")
    public ConfigurePage changePersonalInformation(String keyIndicators, String minRating, String maxRating) {
        listOfJobTitle.click();
        chooseQALead.click();
        keyPerformanceIndicators.sendKeys(keyIndicators);
        minRatings.clear();
        minRatings.sendKeys(minRating);
        maxRatings.clear();
        maxRatings.sendKeys(maxRating);
        makeDefaultButton.click();
        return this;
    }

    @Step("Set add key performance button")
    public ConfigurePage clickSetAddKeyPerformanceButton() {
        addKeyPerformance.click();
        return this;
    }
}