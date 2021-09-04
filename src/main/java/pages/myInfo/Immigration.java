package pages.myInfo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.PIM.AddEmployee;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Immigration {

    SelenideElement immigrationDetailsButton = $(By.xpath("//*[@id=\"sidenav\"]//*[text()='Immigration']"));
    SelenideElement addImmigrationRecords = $(By.id("btnAdd"));
    SelenideElement clickOnVisaButton = $(By.xpath("//*[@id=\"immigration_type_flag_2\"]/../*[text()='Visa']"));
    SelenideElement number = $(By.id("immigration_number"));
    SelenideElement issueDate = $(By.id("immigration_passport_issue_date"));
    SelenideElement expireDate = $(By.id("immigration_passport_expire_date"));
    SelenideElement status = $(By.id("immigration_i9_status"));
    SelenideElement chooseIssuedByBelarus = $(By.xpath("//*[@id=\"immigration_country\"]//*[@value='BY']"));
    SelenideElement reviewDate = $(By.id("immigration_i9_review_date"));
    SelenideElement comments = $(By.id("immigration_comments"));
    SelenideElement saveButton = $(By.id("btnSave"));
    SelenideElement deleteButton = $(By.id("btnDelete"));

    public SelenideElement button = $(By.xpath("//*[text()='" + number + "']/..//*[@name=\"chkImmigration[]\"]"));

    @Step("Checking for button visibility")
    public Immigration checkingForButtonVisibility(String number) {
        SelenideElement button = $(By.xpath("//*[text()='" + number + "']/..//*[@name=\"chkImmigration[]\"]"));
        button.shouldNotHave(visible);
        return this;
    }

    @Step("Pressing the button to delete")
    public Immigration setDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step("Checking for button visibility")
    public Immigration clickOnButtonToDelete(String number) {
        SelenideElement button = $(By.xpath("//*[text()='" + number + "']/..//*[@name=\"chkImmigration[]\"]"));
        button.click();
        return this;
    }

    public Immigration checkingTheAddedVisa(String num_visa) {
        SelenideElement Button = $(By.xpath("//*[@id=\"frmImmigrationDelete\"]//*[text()='" + num_visa + "']"));
        Button.shouldHave(visible);
        return this;
    }

    @Step("Button to save immigration details")
    public Immigration setSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Clicking on the immigration details button")
    public Immigration setImmigrationDetailsButton() {
        immigrationDetailsButton.click();
        return this;
    }

    @Step("Button to add immigration records")
    public Immigration setAddImmigrationRecords() {
        addImmigrationRecords.click();
        return this;
    }

    @Step("Filling in employee fields")
    public Immigration fieldEmployee(String number_visa, String issue_date, String expire_date,
                                     String eligible_status, String review_date, String comment) {
        clickOnVisaButton.click();
        number.sendKeys(number_visa);
        issueDate.clear();
        issueDate.sendKeys(issue_date, Keys.ENTER);
        expireDate.clear();
        expireDate.sendKeys(expire_date, Keys.ENTER);
        status.sendKeys(eligible_status);
        chooseIssuedByBelarus.click();
        reviewDate.clear();
        reviewDate.sendKeys(review_date, Keys.ENTER);
        comments.sendKeys(comment);
        return this;
    }
}