package pages.PIM;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddEmployee {
    public SelenideElement messagePersonalDetails = $(By.xpath("//*[@id=\"pdMainContainer\"]//*[text()='Personal Details']"));
    SelenideElement firstName = $(By.id("firstName"));
    SelenideElement lastNameName = $(By.id("lastName"));
    SelenideElement employeeId = $(By.id("employeeId"));
    SelenideElement saveButton = $(By.id("btnSave"));
    SelenideElement deleteButton = $(By.id("btnDelete"));
    SelenideElement acceptDeleteButton = $(By.id("dialogDeleteBtn"));
    SelenideElement employeePhoto = $(By.id("photofile"));

    File file = new File("src/main/resources/testPhoto.jpg");

    @Step("Checking the deletion of an employee by ID")
    public void checkRemoteEmployeesByID(String ID) {
        SelenideElement flagButton = $(By.xpath("//a[text()='" + ID + "']/../..//*[@name=\"chkSelectRow[]\"]"));
        flagButton.shouldNotHave(visible);
    }

    @Step("Checking the presence of an employee by the locator and clicking on the flag")
    public AddEmployee checkLocatorFlagButtonAndClickOn(String name) {
        SelenideElement flagButton = $(By.xpath("//a[text()='" + name + "']/../..//*[@name=\"chkSelectRow[]\"]"));
        flagButton.shouldHave(visible);
        flagButton.click();
        return this;
    }

    @Step("Button for accept deleting employee list")
    public AddEmployee setAcceptDeleteButton() {
        acceptDeleteButton.click();
        return this;
    }

    @Step("Button for deleting employee list")
    public AddEmployee setDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step("Button for saving employee parameters")
    public AddEmployee setSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Filling in employee fields")
    public AddEmployee fieldEmployee(String first_name, String last_name, String employee_ID) {
        firstName.sendKeys(first_name);
        lastNameName.sendKeys(last_name);
        employeeId.clear();
        employeeId.sendKeys(employee_ID);
        employeePhoto.uploadFile(file);
        return this;
    }
}