package pages.myInfo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PersonalDetails {
    SelenideElement editAllInformationButton = $(By.id("btnSave"));
    SelenideElement firstName = $(By.id("personal_txtEmpFirstName"));
    SelenideElement lastName = $(By.id("personal_txtEmpLastName"));
    SelenideElement employeeID = $(By.id("personal_txtEmployeeId"));
    SelenideElement otherID = $(By.id("personal_txtOtherID"));
    SelenideElement numberSSN = $(By.id("personal_txtNICNo"));
    SelenideElement numberSIN = $(By.id("personal_txtSINNo"));
    SelenideElement nationalityButton = $(By.id("personal_cmbNation"));
    SelenideElement nationalityBelarusian = $(By.cssSelector("option:nth-child(20)"));
    SelenideElement smokeFlag = $(By.id("personal_chkSmokeFlag"));
    SelenideElement saveButton = $(By.id("btnSave"));
    public SelenideElement fullNameUser = $(By.cssSelector("#profile-pic > h1"));



    @Step("Save button")
    public PersonalDetails setSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Button for changing information")
    public PersonalDetails setEditAllInformationButton() {
        editAllInformationButton.click();
        return this;
    }

    @Step("Change of personal information")
    public PersonalDetails changePersonalInformation(String first_Name, String last_Name, String employee_ID,
                                                     String other_ID, String number_SSN, String number_SIN) {
        firstName.clear();
        firstName.sendKeys(first_Name);
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
        smokeFlag.click();
        return this;
    }
}