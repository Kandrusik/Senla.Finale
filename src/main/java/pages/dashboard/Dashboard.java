package pages.dashboard;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Dashboard {
    String first = "Not assigned to Subunits";
    String admin = "Administration";
    String client_service = "Client Services";
    String engineer = "Engineering";
    String finances = "Finance";
    String human_resources = "Human Resources";
    String sales_and_marketing = "Sales & Marketing";

    String assignLeave = "Assign Leave";
    String leaveList = "Leave List";
    String timeSheets = "Timesheets";
    String applyLeave = "Apply Leave";
    String myLeave = "My Leave";
    String myTimesheet = "My Timesheet";

    public void locatorLegendPanel(String name) {
        SelenideElement checkLegendPanel = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + name + "']"));
        checkLegendPanel.shouldHave(visible);
    }

    public void locatorQuickLaunch(String name) {
        SelenideElement checkQuickLaunch = $(By.xpath("//span[contains(@class,'quickLinkText') and contains(text(),'" + name + "')]"));
        checkQuickLaunch.shouldHave(visible);
    }

    @Step("Checking for compliance of Quick Launch fields")
    public Dashboard checkQuickLaunch() {
        locatorQuickLaunch(assignLeave);
        locatorQuickLaunch(leaveList);
        locatorQuickLaunch(timeSheets);
        locatorQuickLaunch(applyLeave);
        locatorQuickLaunch(myLeave);
        locatorQuickLaunch(myTimesheet);
        return this;
    }

    @Step("Checking for compliance of Legend Panel fields")
    public Dashboard checkLegendPanel() {
        locatorLegendPanel(first);
        locatorLegendPanel(admin);
        locatorLegendPanel(client_service);
        locatorLegendPanel(engineer);
        locatorLegendPanel(finances);
        locatorLegendPanel(human_resources);
        locatorLegendPanel(sales_and_marketing);
        return this;
    }
}