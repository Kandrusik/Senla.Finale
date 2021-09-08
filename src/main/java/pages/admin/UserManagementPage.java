package pages.admin;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserManagementPage {

    SelenideElement addUser = $(By.id("btnAdd"));
    SelenideElement saveButton = $(By.name("btnSave"));
    SelenideElement userRole = $(By.xpath("//*[@id=\"systemUser_userType\"]//option[text() = 'Admin']"));
    SelenideElement employeeName = $(By.id("systemUser_employeeName_empName"));
    SelenideElement userName = $(By.id("systemUser_userName"));
    SelenideElement status = $(By.xpath("//*[@id=\"systemUser_status\"]//option[text() = 'Enabled']"));
    SelenideElement userPassword = $(By.id("systemUser_password"));
    SelenideElement userPasswordConfirm = $(By.id("systemUser_confirmPassword"));
    SelenideElement deleteUserButton = $(By.id("btnDelete"));
    SelenideElement acceptDeleteUserButton = $(By.id("dialogDeleteBtn"));

    @Step("Deleting a user")
    public UserManagementPage clickDeleteUserButton() {
        deleteUserButton.click();
        acceptDeleteUserButton.click();
        return this;
    }

    @Step("Set personal information of user")
    public UserManagementPage personInformationUser(String name, String password, String passwordConfirm) {
        userRole.click();
        employeeName.setValue("a").pressEnter();
        userName.sendKeys(name);
        status.click();
        userPassword.sendKeys(password);
        userPasswordConfirm.sendKeys(passwordConfirm);
        return this;
    }

    @Step("Set add user button")
    public UserManagementPage clickAddUserButton() {
        addUser.click();
        return this;
    }

    @Step("Set save button")
    public UserManagementPage clickSaveButton() {
        saveButton.click();
        return this;
    }
}