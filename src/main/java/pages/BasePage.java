package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    SelenideElement adminUserButton = $(By.id("menu_admin_viewAdminModule"));
    SelenideElement adminMenuJobTitleButton = $(By.id("menu_admin_Job"));
    SelenideElement adminJobTitleButton = $(By.id("menu_admin_viewJobTitleList"));

    SelenideElement pimButton = $(By.id("menu_pim_viewPimModule"));
    SelenideElement pimEmployeeListButton = $(By.id("menu_pim_viewEmployeeList"));

    SelenideElement leaveButton = $(By.id("menu_leave_viewLeaveModule"));
    SelenideElement leaveListButton = $(By.id("menu_leave_viewLeaveList"));
    SelenideElement assignLeaveButton = $(By.id("menu_leave_assignLeave"));

    SelenideElement timeButton = $(By.id("menu_time_viewTimeModule"));
    SelenideElement recruitmentButton = $(By.id("menu_recruitment_viewRecruitmentModule"));
    SelenideElement myInfoButton = $(By.id("menu_pim_viewMyDetails"));
    SelenideElement performanceButton = $(By.id("menu__Performance"));
    SelenideElement performanceConfigureButton = $(By.id("menu_performance_Configure"));
    SelenideElement performanceKPIButton = $(By.id("menu_performance_searchKpi"));

    SelenideElement dashboardButton = $(By.id("menu_dashboard_index"));
    SelenideElement directoryButton = $(By.id("menu_directory_viewDirectory"));
    SelenideElement maintenanceButton = $(By.id("menu_maintenance_purgeEmployee"));
    SelenideElement buzzButton = $(By.id("menu_buzz_viewBuzz"));
    SelenideElement subscriberButton = $(By.id("Subscriber_link"));

    SelenideElement welcomeButton = $(By.id("welcome"));
    SelenideElement sighOutButton = $(By.cssSelector("#welcome-menu ul > li:nth-child(3) > a"));

    @Step("Set performance KPIs button")
    public BasePage setPerformanceKPIButton() {
        performanceKPIButton.click();
        return this;
    }

    @Step("Set performance configure button")
    public BasePage setPerformanceConfigureButton() {
        performanceConfigureButton.click();
        return this;
    }

    @Step("Set performance button")
    public BasePage setPerformanceButton() {
        performanceButton.click();
        return this;
    }

    @Step("Set PIM employee list button")
    public BasePage setPIMEmployeeListButton() {
        pimEmployeeListButton.click();
        return this;
    }

    @Step("Set dashboard button")
    public BasePage setDashboardButton() {
        dashboardButton.click();
        return this;
    }

    @Step("Set PIM button")
    public BasePage setPIMButton() {
        pimButton.click();
        return this;
    }

    @Step("Set my info button")
    public BasePage setMyInfoButton() {
        myInfoButton.click();
        return this;
    }

    @Step("Set leave list button")
    public BasePage setLeaveListButton() {
        leaveListButton.click();
        return this;
    }

    @Step("Set assign leave button")
    public BasePage setAssignLeaveButton() {
        assignLeaveButton.click();
        return this;
    }


    @Step("Set leave button")
    public BasePage setLeaveButton() {
        leaveButton.click();
        return this;
    }


    @Step("Set recruitment button")
    public void setRecruitmentButton() {
        recruitmentButton.click();
    }


    @Step("Set sing out button")
    public void setSighOutButton() {
        welcomeButton.click();
        sighOutButton.click();
    }

    @Step("Set Admin User button")
    public BasePage setAdminUserButton() {
        adminUserButton.click();
        return this;
    }

    @Step("Set Admin Job button")
    public BasePage setAdminJobTitleButton() {
        adminMenuJobTitleButton.click();
        adminJobTitleButton.click();
        return this;
    }
}