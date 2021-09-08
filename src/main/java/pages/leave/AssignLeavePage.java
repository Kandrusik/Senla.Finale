package pages.leave;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class AssignLeavePage {

    public SelenideElement acceptAssignButton = $(By.id("confirmOkButton"));
    SelenideElement employeeNames = $(By.id("assignleave_txtEmployee_empName"));
    SelenideElement txtLeaveTypes = $(By.id("assignleave_txtLeaveType"));
    SelenideElement personalTypes = $(By.xpath("//*[@id=\"assignleave_txtLeaveType\"]/option[3]"));
    SelenideElement fromDates = $(By.id("assignleave_txtFromDate"));
    SelenideElement toDates = $(By.id("assignleave_txtToDate"));
    SelenideElement comments = $(By.id("assignleave_txtComment"));
    SelenideElement assignButton = $(By.id("assignBtn"));

    public void leaveDescription(String employeeName, String fromDate, String toDate, String comment) {
        employeeNames.sendKeys(employeeName, Keys.ENTER);
        txtLeaveTypes.click();
        personalTypes.click();
        fromDates.clear();
        fromDates.sendKeys(fromDate, Keys.ENTER);
        toDates.clear();
        toDates.sendKeys(toDate, Keys.ENTER);
        comments.sendKeys(comment);
    }

    public AssignLeavePage clickAcceptAssignButton() {
        acceptAssignButton.click();
        return this;
    }

    @Step("Clicking on the assign button")
    public void clickAssignButton() {
        assignButton.click();
    }
}