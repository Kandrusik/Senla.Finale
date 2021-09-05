package pages.leave;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class AssignLeave {

    public SelenideElement acceptAssignButton = $(By.id("confirmOkButton"));
    SelenideElement employeeName = $(By.id("assignleave_txtEmployee_empName"));
    SelenideElement txtLeaveType = $(By.id("assignleave_txtLeaveType"));
    SelenideElement personalType = $(By.xpath("//*[@id=\"assignleave_txtLeaveType\"]/option[3]"));
    SelenideElement fromDate = $(By.id("assignleave_txtFromDate"));
    SelenideElement toDate = $(By.id("assignleave_txtToDate"));
    SelenideElement comment = $(By.id("assignleave_txtComment"));
    SelenideElement assignButton = $(By.id("assignBtn"));

    public void leaveDescription(String employee_Name, String from_date, String to_date, String some_comment) {
        employeeName.sendKeys(employee_Name, Keys.ENTER);
        txtLeaveType.click();
        personalType.click();
        fromDate.clear();
        fromDate.sendKeys(from_date, Keys.ENTER);
        toDate.clear();
        toDate.sendKeys(to_date, Keys.ENTER);
        comment.sendKeys(some_comment);
    }

    public AssignLeave setAcceptAssignButton() {
        acceptAssignButton.click();
        return this;
    }

    public void setAssignButton() {
        assignButton.click();
    }
}