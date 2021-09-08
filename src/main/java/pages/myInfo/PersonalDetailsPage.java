package pages.myInfo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalDetailsPage {
    public SelenideElement firstNames = $(By.id("personal_txtEmpFirstName"));
    public SelenideElement middleNames = $(By.id("personal_txtEmpMiddleName"));
    public SelenideElement lastNames = $(By.id("personal_txtEmpLastName"));
    public SelenideElement fullNameUser = $(By.id("profile-pic"));
    public String first_Name = firstNames.getValue();
    public String last_Name = lastNames.getValue();
    SelenideElement editAllInformationButton = $(By.id("btnSave"));
    SelenideElement employeeIDs = $(By.id("personal_txtEmployeeId"));
    SelenideElement otherIDs = $(By.id("personal_txtOtherID"));
    SelenideElement numberSSNs = $(By.id("personal_txtNICNo"));
    SelenideElement numberSINs = $(By.id("personal_txtSINNo"));
    SelenideElement nationalityButton = $(By.id("personal_cmbNation"));
    SelenideElement nationalityBelarusian = $(By.xpath("//*[@id=\"personal_cmbNation\"]/*[text()='Belarusian'] "));
    SelenideElement smokeFlag = $(By.id("personal_chkSmokeFlag"));
    SelenideElement saveButton = $(By.id("btnSave"));
    SelenideElement personalNames = $(By.id("personal_txtEmpNickName"));
    SelenideElement personalMilitarySers = $(By.id("personal_txtMilitarySer"));
    SelenideElement bloodTypeAB = $(By.xpath("//*[@name='custom1']//option[@value='AB+']"));
    SelenideElement addAttachment = $(By.id("btnAddAttachment"));
    SelenideElement addComment = $(By.id("txtAttDesc"));
    SelenideElement saveAttachment = $(By.id("btnSaveAttachment"));
    SelenideElement editSaveCustomField = $(By.id("btnEditCustom"));

    @Step("Clicking on the save button")
    public PersonalDetailsPage clickOnSetSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Clear middle name")
    public PersonalDetailsPage clearMiddleNameMethod() {
        middleNames.clear();
        saveButton.click();
        return this;
    }

    @Step("Button for changing information")
    public PersonalDetailsPage clickSetEditAllInformationButton() {
        editAllInformationButton.click();
        editSaveCustomField.click();
        addAttachment.click();
        return this;
    }

    @Step("Clear all information")
    public PersonalDetailsPage clearUserFields() {
        firstNames.clear();
        middleNames.clear();
        lastNames.clear();
        employeeIDs.clear();
        otherIDs.clear();
        numberSSNs.clear();
        numberSINs.clear();
        personalNames.clear();
        personalMilitarySers.clear();
        addComment.clear();
        return this;
    }

    @Step("Entering personal data")
    public PersonalDetailsPage changePersonalInformation(String firstName, String lastName, String employeeID,
                                                         String otherID, String numberSSN, String numberSIN,
                                                         String personalName, String personalMilitarySer, String comment) {
        firstNames.sendKeys(firstName);
        lastNames.sendKeys(lastName);
        employeeIDs.sendKeys(employeeID);
        otherIDs.sendKeys(otherID);
        numberSSNs.sendKeys(numberSSN);
        numberSINs.sendKeys(numberSIN);
        nationalityButton.click();
        nationalityBelarusian.click();
        personalNames.sendKeys(personalName);
        personalMilitarySers.sendKeys(personalMilitarySer);
        smokeFlag.click();
        bloodTypeAB.click();
        addComment.sendKeys(comment);
        return this;
    }

    @Step("Save all information button")
    public PersonalDetailsPage clickSaveAllPersonalInformation() {
        editSaveCustomField.click();
        saveAttachment.click();
        saveButton.click();
        return this;
    }
}