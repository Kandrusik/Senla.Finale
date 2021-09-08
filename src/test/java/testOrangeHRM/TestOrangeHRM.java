package testOrangeHRM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.PIM.AddEmployeePage;
import pages.PIM.EmployeeListPage;
import pages.admin.JobPage;
import pages.admin.UserManagementPage;
import pages.dashboard.DashboardPage;
import pages.leave.AssignLeavePage;
import pages.leave.LeaveListPage;
import pages.login.LoginPage;
import pages.login.LogoutPage;
import pages.myInfo.ImmigrationPage;
import pages.myInfo.PersonalDetailsPage;
import pages.performance.ConfigurePage;
import pages.recruitment.CandidatesPage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOrangeHRM extends BasePage {

    Faker faker = new Faker();
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @Attachment(value = "Test attachment [{type}]", type = "text/plain", fileExtension = ".txt")
    public byte[] textAttachment(String type, String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }

    @Owner(value = "Dmitry")
    @BeforeEach
    public void setUp() throws IOException {
        Configuration.headless = true;
//        Configuration.startMaximized = true;
        loginPage.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("Dashboard"));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test")
    @Link(name = "Admin", url = "https://opensource-demo.orangehrmlive.com/")
    @Test
    @Order(1)
    public void testLoginTest() throws IOException {
        basePage.setSighOutButton();
        loginPage.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("Dashboard"));
        textAttachment("Input data", "Login = Admin\n" +
                "Password = admin123");
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for checking adding and deleting a user")
    @Test
    @Order(2)
    public void testAddAndDeleteUser() {
        String adminUserName = faker.name().fullName();
        UserManagementPage userManagementPage = new UserManagementPage();
        basePage.setAdminUserButton();
        userManagementPage.clickAddUserButton()
                .personInformationUser(adminUserName, "12345678", "12345678")
                .clickSaveButton();
        SelenideElement realName = $(By.xpath("//a[text()='" + adminUserName + "']"));
        realName.shouldHave(visible);
        SelenideElement userNameMarker = $(By.xpath("//a[text()='" + adminUserName + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        userNameMarker.click();
        userManagementPage.clickDeleteUserButton();
        userNameMarker.shouldNotHave(visible);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for checking adding and deleting a job")
    @Test
    @Order(3)
    public void testAddJobAndDelete() {
        JobPage jobPage = new JobPage();
        String firstJob = "Accountant";
        String secondJob = "Actor";
        String thirdJob = "Advocate";
        basePage.setAdminUserButton()
                .setAdminJobTitleButton();
        jobPage.clickAddJobButton()
                .jobDescription(firstJob, "Working with numbers", "Salary 2000$")
                .clickSaveJobButton();
        jobPage.clickAddJobButton()
                .jobDescription(secondJob, "Creative work", "Salary 2000$")
                .clickSaveJobButton();
        jobPage.clickAddJobButton()
                .jobDescription(thirdJob, "Solves problems", "Salary 2000$")
                .clickSaveJobButton();
        jobPage.clickOnJobFlag(firstJob)
                .clickOnJobFlag(secondJob)
                .clickOnJobFlag(thirdJob)
                .setDeleteJobTitlesButton();
        jobPage.checkTheVisibilityOfWork(firstJob)
                .checkTheVisibilityOfWork(secondJob)
                .checkTheVisibilityOfWork(thirdJob);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for checking the addition and removal of a candidate")
    @Test
    @Order(4)
    public void testAddAndDeleteCandidates() {
        CandidatesPage candidatesPage = new CandidatesPage();
        String fullNameCandidate = "Egor Aleksandrov Zalesky";
        basePage.setRecruitmentButton();
        candidatesPage.clickAddCandidatesButton()
                .candidateDescription("Egor", "Aleksandrov",
                        "Zalesky", "egor@gmail.com", "+375 (33) 33-00-111",
                        "Engineer", "Important information", "2021-04-01")
                .clickSaveCandidatesButton()
                .clickBackToCandidatesButton()
                .acceptCandidateOnThePage.shouldHave(visible);
        SelenideElement setOnCandidateFlag = $(By.xpath("//a[text()='" + fullNameCandidate + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        setOnCandidateFlag.click();
        candidatesPage.clickDeleteCandidatesButton()
                .clickAcceptDeleteCandidatesButton()
                .acceptCandidateOnThePage.shouldNotHave(visible);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Personal data change test")
    @Test
    @Order(5)
    public void testChangePersonalDetails() {
        basePage.setMyInfoButton();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        String lastName = faker.name().lastName();
        String fullNameUserText = personalDetailsPage.fullNameUser.getText();
        personalDetailsPage.clickSetEditAllInformationButton()
                .clearUserFields()
                .changePersonalInformation("Aristarch", lastName, "213", "01",
                        "1", "29", "Boss", "PB",
                        "Important")
                .clickSaveAllPersonalInformation();
        personalDetailsPage.fullNameUser.shouldNotHave(text(fullNameUserText));
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test buy")
    @Flaky
    @Test
    @Order(6)
    public void testAddAndCancelAssignLeave() {
        LeaveListPage leaveListPage = new LeaveListPage();
        AssignLeavePage assignLeavePage = new AssignLeavePage();
        String date = "2021-12-01";
        basePage.setMyInfoButton();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        personalDetailsPage.clickSetEditAllInformationButton()
                .clearMiddleNameMethod();
        basePage.setLeaveButton()
                .setAssignLeaveButton();
        assignLeavePage.leaveDescription(personalDetailsPage.first_Name + " " + personalDetailsPage.last_Name,
                date, date, "I need a little rest");
        assignLeavePage.clickAssignButton();
        leaveListPage.clickOnLeaveListButton()
                .clickOnPendingApprovalFlag()
                .setEmployeeField(personalDetailsPage.first_Name + " " + personalDetailsPage.last_Name)
                .clickOnSearchButton()
                .clickCancelOurVacationLocator(date)
                .clickSaveButton();
        leaveListPage.visibilityCheckCancelOurVacationLocator(date);

    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test of adding and removing immigration information")
    @Test
    @Order(7)
    public void testAddAndDeleteImmigrationInformation() {
        basePage.setMyInfoButton();
        String number_visa = "2378473";
        ImmigrationPage immigrationPage = new ImmigrationPage();
        immigrationPage.clickImmigrationDetailsButton()
                .clickAddImmigrationRecords()
                .fieldEmployee(number_visa, "2021-09-02", "2022-09-01",
                        "True", "2021-09-03", "It's good");
        immigrationPage.clickSaveButton()
                .checkingTheAddedVisa(number_visa)
                .clickOnButtonToDelete(number_visa)
                .setDeleteButton()
                .checkingForButtonVisibility(number_visa);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test for checking adding and removing a worker")
    @Test
    @Order(8)
    public void testCheckForAddingAndRemovingWorker() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        String firstName = "Jacque";
        String lastName = "Fresco";
        String employeeID = "1313";
        basePage.setPIMButton()
                .setPimAddEmployeeButton();
        addEmployeePage.fieldEmployee(firstName, lastName, employeeID)
                .clickSaveButton()
                .messagePersonalDetails.shouldHave(visible);
        basePage.setPIMEmployeeListButton();
        addEmployeePage.checkLocatorFlagButtonAndClickOn(lastName)
                .clickDeleteButton()
                .clickAcceptDeleteButton()
                .checkRemoteEmployeesByID(employeeID);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test data is displayed correctly worker")
    @Test
    @Order(9)
    public void testDataIsDisplayedCorrectlyWorker() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        basePage.setPIMButton()
                .setPIMEmployeeListButton();
        String expected_firstName = employeeListPage.firstNameFirstPeople.getText();
        String expected_lastName = employeeListPage.lastNameFirstPeople.getText();
        String expected_jobTitle = employeeListPage.jobTitlePeople.text();
        employeeListPage.clickOpenFirstPeopleButton()
                .firstName.shouldHave(value(expected_firstName));
        employeeListPage.lastName.shouldHave(value(expected_lastName));
        employeeListPage.clickOpenJobInfoButton()
                .selectedJobTitle.shouldHave(text(expected_jobTitle));
    }

    @Severity(SeverityLevel.NORMAL)
    @Owner(value = "Dmitry")
    @Description("Checking the display of all fields on this page")
    @Test
    @Order(10)
    public void testCheckingThePresenceOfFields() {
        String first = "Not assigned to Subunits";
        String admin = "Administration";
        String clientService = "Client Services";
        String engineer = "Engineering";
        String finances = "Finance";
        String humanResources = "Human Resources";
        String salesAndMarketing = "Sales & Marketing";
        String assignLeave = "Assign Leave";
        String leaveList = "Leave List";
        String timeSheets = "Timesheets";
        String applyLeave = "Apply Leave";
        String myLeave = "My Leave";
        String myTimesheet = "My Timesheet";
        DashboardPage dashboardPage = new DashboardPage();
        basePage.setDashboardButton();
        dashboardPage.checkLegendPanel(first,admin,clientService,engineer,finances,humanResources,salesAndMarketing)
                .checkQuickLaunch(assignLeave, leaveList,timeSheets,applyLeave,myLeave,myTimesheet);
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Owner(value = "Dmitry")
    @Description("KPI Tuning Performance Test")
    @Test
    @Order(11)
    public void testPerformanceConfigureKPIs() {
        ConfigurePage configurePage = new ConfigurePage();
        String keyIndicator = "Founder";
        basePage.setPerformanceButton()
                .setPerformanceConfigureButton()
                .setPerformanceKPIButton();
        configurePage.messageSearchKeyPerformance.shouldHave(text("Search Key Performance Indicators"));
        configurePage.clickSetAddKeyPerformanceButton()
                .changePersonalInformation(keyIndicator, "1", "99")
                .clickSetSaveButton()
                .messageSearchKeyPerformance.shouldHave(text("Search Key Performance Indicators"));
        configurePage.clickOnKeyPerformanceFlag(keyIndicator);
        configurePage.clickSetDeleteKeyButton()
                .clickSetAcceptDeleteKeyButton();
        configurePage.checkKeyPerformanceFlag(keyIndicator);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Logout test")
    @Test
    @Order(12)
    public void testLogoutTest() {
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickLogoutButton()
                .welcomeMessageLogin.shouldHave(text("LOGIN Panel"));
    }
}