package pages.myInfo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ImmigrationPage {

    SelenideElement immigrationDetailsButton = $(By.xpath("//*[@id=\"sidenav\"]//*[text()='Immigration']"));
    SelenideElement addImmigrationRecords = $(By.id("btnAdd"));
    SelenideElement clickOnVisaButton = $(By.xpath("//*[@id=\"immigration_type_flag_2\"]/../*[text()='Visa']"));
    SelenideElement number = $(By.id("immigration_number"));
    public SelenideElement button = $(By.xpath("//*[text()='" + number + "']/..//*[@name=\"chkImmigration[]\"]"));
    SelenideElement issueDates = $(By.id("immigration_passport_issue_date"));
    SelenideElement expireDates = $(By.id("immigration_passport_expire_date"));
    SelenideElement status = $(By.id("immigration_i9_status"));
    SelenideElement chooseIssuedByBelarus = $(By.xpath("//*[@id=\"immigration_country\"]//*[@value='BY']"));
    SelenideElement reviewDates = $(By.id("immigration_i9_review_date"));
    SelenideElement comments = $(By.id("immigration_comments"));
    SelenideElement saveButton = $(By.id("btnSave"));
    SelenideElement deleteButton = $(By.id("btnDelete"));

    @Step("Checking for button visibility")
    public ImmigrationPage checkingForButtonVisibility(String number) {
        SelenideElement button = $(By.xpath("//*[text()='" + number + "']/..//*[@name=\"chkImmigration[]\"]"));
        button.shouldNotHave(visible);
        return this;
    }

    @Step("Pressing the button to delete")
    public ImmigrationPage setDeleteButton() {
        deleteButton.click();
        return this;
    }

    @Step("Checking for button visibility")
    public ImmigrationPage clickOnButtonToDelete(String number) {
        SelenideElement button = $(By.xpath("//*[text()='" + number + "']/..//*[@name=\"chkImmigration[]\"]"));
        button.click();
        return this;
    }

    public ImmigrationPage checkingTheAddedVisa(String numVisa) {
        SelenideElement Button = $(By.xpath("//*[@id=\"frmImmigrationDelete\"]//*[text()='" + numVisa + "']"));
        Button.shouldHave(visible);
        return this;
    }

    @Step("Button to save immigration details")
    public ImmigrationPage clickSaveButton() {
        saveButton.click();
        return this;
    }

    @Step("Clicking on the immigration details button")
    public ImmigrationPage clickImmigrationDetailsButton() {
        immigrationDetailsButton.click();
        return this;
    }

    @Step("Button to add immigration records")
    public ImmigrationPage clickAddImmigrationRecords() {
        addImmigrationRecords.click();
        return this;
    }

    @Step("Filling in employee fields")
    public ImmigrationPage fieldEmployee(String numberVisa, String issueDate, String expireDate,
                                         String eligibleStatus, String reviewDate, String comment) {
        clickOnVisaButton.click();
        number.sendKeys(numberVisa);
        issueDates.clear();
        issueDates.sendKeys(issueDate, Keys.ENTER);
        expireDates.clear();
        expireDates.sendKeys(expireDate, Keys.ENTER);
        status.sendKeys(eligibleStatus);
        chooseIssuedByBelarus.click();
        reviewDates.clear();
        reviewDates.sendKeys(reviewDate, Keys.ENTER);
        comments.sendKeys(comment);
        return this;
    }
}