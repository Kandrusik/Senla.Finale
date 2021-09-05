package pages.myInfo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PersonalDetails {
    public SelenideElement firstName = $(By.id("personal_txtEmpFirstName"));
    public SelenideElement middleName = $(By.id("personal_txtEmpMiddleName"));
    public SelenideElement lastName = $(By.id("personal_txtEmpLastName"));
    public SelenideElement fullNameUser = $(By.id("profile-pic"));
    public String first_Name = firstName.getValue();
    public String last_Name = lastName.getValue();
    SelenideElement editAllInformationButton = $(By.id("btnSave"));
    SelenideElement employeeID = $(By.id("personal_txtEmployeeId"));
    SelenideElement otherID = $(By.id("personal_txtOtherID"));
    SelenideElement numberSSN = $(By.id("personal_txtNICNo"));
    SelenideElement numberSIN = $(By.id("personal_txtSINNo"));
    SelenideElement nationalityButton = $(By.id("personal_cmbNation"));
    SelenideElement nationalityBelarusian = $(By.xpath("//*[@id=\"personal_cmbNation\"]/*[text()='Belarusian'] "));
    SelenideElement smokeFlag = $(By.id("personal_chkSmokeFlag"));
    SelenideElement saveButton = $(By.id("btnSave"));
    SelenideElement personalName = $(By.id("personal_txtEmpNickName"));
    SelenideElement personalMilitarySer = $(By.id("personal_txtMilitarySer"));
    SelenideElement bloodTypeAB = $(By.xpath("//*[@name='custom1']//option[@value='AB+']"));
    SelenideElement addAttachment = $(By.id("btnAddAttachment"));
    SelenideElement addComment = $(By.id("txtAttDesc"));
    SelenideElement saveAttachment = $(By.id("btnSaveAttachment"));
    SelenideElement editCustomField = $(By.id("btnEditCustom"));

    @Step("Clicking on the save button")
    public PersonalDetails setSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Button for changing information")
    public PersonalDetails clearMiddleName() {
        middleName.clear();
        saveButton.click();
        return this;
    }

    @Step("Button for changing information")
    public PersonalDetails setEditAllInformationButton() {
        editAllInformationButton.click();
        return this;
    }

    @Step("Entering personal data")
    public PersonalDetails changePersonalInformation(String first_Name, String last_Name, String employee_ID,
                                                     String other_ID, String number_SSN, String number_SIN,
                                                     String personal_Name, String personal_MilitarySer, String comment) {
        firstName.clear();
        firstName.sendKeys(first_Name);
        middleName.clear();
        lastName.clear();
        lastName.sendKeys(last_Name);
        employeeID.clear();
        employeeID.sendKeys(employee_ID);
        otherID.clear();
        otherID.sendKeys(other_ID);
        numberSSN.clear();
        numberSSN.sendKeys(number_SSN);
        numberSIN.clear();
        numberSIN.sendKeys(number_SIN);
        nationalityButton.click();
        nationalityBelarusian.click();
        personalName.clear();
        personalName.sendKeys(personal_Name);
        personalMilitarySer.clear();
        personalMilitarySer.sendKeys(personal_MilitarySer);
        smokeFlag.click();
        saveButton.click();
        editCustomField.click();
        bloodTypeAB.click();
        editCustomField.click();
        addAttachment.click();
        addComment.clear();
        addComment.sendKeys(comment);
        saveAttachment.click();
        return this;
    }
}