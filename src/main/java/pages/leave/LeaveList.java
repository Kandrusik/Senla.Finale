package pages.leave;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeaveList {

    public SelenideElement messageFromDate = $(By.id("calFromDate"));
    public SelenideElement messageToDate = $(By.id("calToDate"));
    public SelenideElement sizePeopleInTable = $(By.cssSelector("#resultTable > tbody > tr"));

     SelenideElement employeeName = $(By.id("leaveList_txtEmployee_empName"));
}