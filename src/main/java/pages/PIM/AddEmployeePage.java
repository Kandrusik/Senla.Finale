package pages.PIM;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddEmployeePage {
    public SelenideElement messagePersonalDetails = $(By.xpath("//*[@id=\"pdMainContainer\"]//*[text()='Personal Details']"));
    SelenideElement firstNames = $(By.id("firstName"));
    SelenideElement lastNameNames = $(By.id("lastName"));
    SelenideElement employeeId = $(By.id("employeeId"));
    SelenideElement saveButton = $(By.id("btnSave"));
    SelenideElement deleteButton = $(By.id("btnDelete"));
    SelenideElement acceptDeleteButton = $(By.id("dialogDeleteBtn"));

    @Step("Checking the deletion of an employee by ID")
    public void checkRemoteEmployeesByID(String ID) {
        SelenideElement flagButton = $(By.xpath("//a[text()='" + ID + "']/../..//*[@name=\"chkSelectRow[]\"]"));
        flagButton.shouldNotHave(visible);
    }

    @Step("Checking the presence of an employee by the locator and clicking on the flag")
    public AddEmployeePage checkLocatorFlagButtonAndClickOn(String name) {
        SelenideElement flagButton = $(By.xpath("//a[text()='" + name + "']/../..//*[@name=\"chkSelectRow[]\"]"));
        flagButton.shouldHave(visible);
        flagButton.click();
        return this;
    }

    @Step("Button for accept deleting employee list")
    public AddEmployeePage clickAcceptDeleteButton() {
        acceptDeleteButton.click();
        return this;
    }

    @Step("Button for deleting employee list")
    public AddEmployeePage clickDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step("Button for saving employee parameters")
    public AddEmployeePage clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Filling in employee fields")
    public AddEmployeePage fieldEmployee(String firstName, String lastName, String employeeID) {
        firstNames.sendKeys(firstName);
        lastNameNames.sendKeys(lastName);
        employeeId.clear();
        employeeId.sendKeys(employeeID);
        return this;
    }
}