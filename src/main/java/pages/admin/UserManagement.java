package pages.admin;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserManagement {

    SelenideElement addUser = $(By.id("btnAdd"));
    SelenideElement saveButton = $(By.name("btnSave"));
    SelenideElement userRole = $(By.cssSelector("#systemUser_userType > option:nth-child(1)"));
    SelenideElement employeeName = $(By.id("systemUser_employeeName_empName"));
    SelenideElement userName = $(By.id("systemUser_userName"));
    SelenideElement status = $(By.cssSelector("#systemUser_status > option:nth-child(1)"));
    SelenideElement userPassword = $(By.id("systemUser_password"));
    SelenideElement userPasswordConfirm = $(By.id("systemUser_confirmPassword"));
    SelenideElement deleteUserButton = $(By.id("btnDelete"));
    SelenideElement acceptDeleteUserButton = $(By.id("dialogDeleteBtn"));

    @Step("Deleting a user")
    public UserManagement deleteUser() {
        deleteUserButton.click();
        acceptDeleteUserButton.click();
        return this;
    }

    @Step("Set personal information of user")
    public UserManagement personInformationUser(String user_Name, String user_Password, String user_Password_Confirm) {
        userRole.click();
        employeeName.setValue("a").pressEnter();
        userName.sendKeys(user_Name);
        status.click();
        userPassword.sendKeys(user_Password);
        userPasswordConfirm.sendKeys(user_Password_Confirm);
        return this;
    }

    @Step("Set add user button")
    public UserManagement setAddUserButton() {
        addUser.click();
        return this;
    }

    @Step("Set save button")
    public UserManagement setSaveButton() {
        saveButton.click();
        return this;
    }
}