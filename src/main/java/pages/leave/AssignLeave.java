package pages.leave;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AssignLeave {

    public SelenideElement leaveBalance = $(By.id("assignleave_leaveBalance"));
    public ElementsCollection messageOfSizeDate = $$(By.cssSelector("div.inner > table > tbody > tr"));
    public SelenideElement messageOverlappingLeave = $(By.cssSelector(" div.box.single > div.head > h1"));
    public SelenideElement balanceAssingLiave = $(By.xpath("//*[@id=\"assignleave_leaveBalance\"]"));
    SelenideElement employeeName = $(By.id("assignleave_txtEmployee_empName"));
    SelenideElement txtLeaveType = $(By.id("assignleave_txtLeaveType"));
    SelenideElement personalType = $(By.xpath("//*[@id=\"assignleave_txtLeaveType\"]/option[3]"));
    SelenideElement fromDate = $(By.id("assignleave_txtFromDate"));
    SelenideElement toDate = $(By.id("assignleave_txtToDate"));
    SelenideElement comment = $(By.id("assignleave_txtComment"));
    SelenideElement assignButton = $(By.id("assignBtn"));
    SelenideElement acceptAssignButton = $(By.id("confirmOkButton"));

    public AssignLeave checkMessageOverlappingLeave(String text) {
        messageOverlappingLeave.shouldHave(text(text));
        return this;
    }

    public AssignLeave leaveDescription(String employee_Name, String from_date, String to_date, String some_comment) {
        employeeName.sendKeys(employee_Name, Keys.ENTER);
        txtLeaveType.click();
        personalType.click();
        fromDate.clear();
        fromDate.sendKeys(from_date, Keys.ENTER);
        toDate.clear();
        toDate.sendKeys(to_date, Keys.ENTER);
        comment.sendKeys(some_comment);
        return this;
    }

    public AssignLeave setAcceptAssignButton() {
        acceptAssignButton.click();
        return this;
    }

    public AssignLeave setAssignButton() {
        assignButton.click();
        return this;
    }
}