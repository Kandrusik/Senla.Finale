package pages.PIM;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EmployeeList {
    public SelenideElement firstName = $(By.id("personal_txtEmpFirstName"));
    public SelenideElement lastName = $(By.id("personal_txtEmpLastName"));

    public SelenideElement firstNameFirstPeople = $(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > a"));
    public SelenideElement lastNameFirstPeople = $(By.cssSelector("tr:nth-child(1) > td:nth-child(4) > a"));
    public SelenideElement jobTitlePeople = $(By.cssSelector("tr:nth-child(1) > td:nth-child(5)"));
    public SelenideElement openFirstPeopleButton = $(By.cssSelector("tr:nth-child(1) > td:nth-child(2) > a"));
    SelenideElement openJobInfoButton = $(By.xpath("//*[@id=\"sidenav\"]//..//a[text()='Job']"));
    public SelenideElement selectedJobTitle = $(By.xpath("//*[@id=\"job_job_title\"]//..//option[@selected=\"selected\"]"));

    @Step("Opening the job information person")
    public EmployeeList setOpenJobInfoButton() {
        openJobInfoButton.click();
        return this;
    }

    @Step("Opening the first person")
    public EmployeeList setOpenFirstPeopleButton() {
        openFirstPeopleButton.click();
        return this;
    }
}