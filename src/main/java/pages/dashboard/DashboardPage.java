package pages.dashboard;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    public void locatorLegendPanel(String name) {
        SelenideElement checkLegendPanel = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + name + "']"));
        checkLegendPanel.shouldHave(visible);
    }

    public void locatorQuickLaunch(String name) {
        SelenideElement checkQuickLaunch = $(By.xpath("//span[contains(@class,'quickLinkText') and contains(text(),'" + name + "')]"));
        checkQuickLaunch.shouldHave(visible);
    }

    @Step("Checking for compliance of Quick Launch fields")
    public DashboardPage checkQuickLaunch(String assignLeave, String leaveList, String timeSheets,
                                          String applyLeave, String myLeave, String myTimesheet) {
        locatorQuickLaunch(assignLeave);
        locatorQuickLaunch(leaveList);
        locatorQuickLaunch(timeSheets);
        locatorQuickLaunch(applyLeave);
        locatorQuickLaunch(myLeave);
        locatorQuickLaunch(myTimesheet);
        return this;
    }

    @Step("Checking for compliance of Legend Panel fields")
    public DashboardPage checkLegendPanel(String first, String admin, String clientService,
                                          String engineer, String finances, String humanResources,String salesAndMarketing) {
        locatorLegendPanel(first);
        locatorLegendPanel(admin);
        locatorLegendPanel(clientService);
        locatorLegendPanel(engineer);
        locatorLegendPanel(finances);
        locatorLegendPanel(humanResources);
        locatorLegendPanel(salesAndMarketing);
        return this;
    }
}