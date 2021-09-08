package pages.leave;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LeaveListPage {

    SelenideElement leaveListButton = $(By.id("menu_leave_viewLeaveList"));
    SelenideElement pendingApprovalFlag = $(By.id("leaveList_chkSearchFilter_1"));
    SelenideElement employeeNames = $(By.id("leaveList_txtEmployee_empName"));
    SelenideElement searchButton = $(By.id("btnSearch"));
    SelenideElement saveButton = $(By.id("btnSave"));

    @Step("Clicking on the save button")
    public LeaveListPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Clicking on the search button")
    public LeaveListPage clickOnSearchButton() {
        searchButton.click();
        return this;
    }

    @Step("Pressing the Leave List button")
    public LeaveListPage clickOnLeaveListButton() {
        leaveListButton.click();
        return this;
    }

    @Step("Click pending approval flag")
    public LeaveListPage clickOnPendingApprovalFlag() {
        pendingApprovalFlag.click();
        return this;
    }

    @Step("Filling in the employee field")
    public LeaveListPage setEmployeeField(String employeeName) {
        employeeNames.sendKeys(employeeName);
        return this;
    }

    @Step("Pressing the vacation cancel button")
    public LeaveListPage clickCancelOurVacationLocator(String date) {
        SelenideElement cancelOurVacationLocator = $(By.xpath("//*[text()='" + date + "']//../..//*[@class=\"select_action quotaSelect\"]//*[text()='Cancel']"));
        cancelOurVacationLocator.click();
        return this;
    }

    @Step("Checking the visibility of the vacation cancel button")
    public void visibilityCheckCancelOurVacationLocator(String date) {
        SelenideElement cancelOurVacationLocator = $(By.xpath("//*[text()='" + date + "']//../..//*[@class=\"select_action quotaSelect\"]//*[text()='Cancel']"));
        cancelOurVacationLocator.shouldNotHave(visible);
    }
}