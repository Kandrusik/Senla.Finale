package testOrangeHRM;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.PIM.AddEmployee;
import pages.PIM.EmployeeList;
import pages.admin.Job;
import pages.admin.UserManagement;
import pages.dashboard.Dashboard;
import pages.leave.AssignLeave;
import pages.login.Login;
import pages.login.Logout;
import pages.myInfo.Immigration;
import pages.myInfo.PersonalDetails;
import pages.performance.Configure;
import pages.recruitment.Candidates;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOrangeHRM extends BasePage {

    Faker faker = new Faker();
    BasePage basePage = new BasePage();
    Login login = new Login();

    @Attachment(value = "Test attachment [{type}]", type = "text/plain", fileExtension = ".txt")
    public byte[] textAttachment(String type, String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }

    @BeforeEach
    public void setUp() throws IOException {
        Configuration.headless = true;
//        Configuration.startMaximized = true;
        login.openLoginPage()
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
        login.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("Dashboard"));
        textAttachment("Input data", "Login = Admin\n" +
                "Password = admin123");
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(2)
    public void testAddAndDeleteUser() {
        String adminUserName = faker.name().fullName();
        UserManagement userManagement = new UserManagement();
        basePage.setAdminUserButton();
        userManagement.setAddUserButton()
                .personInformationUser(adminUserName, "12345678", "12345678")
                .setSaveButton();
        SelenideElement realName = $(By.xpath("//a[text()='" + adminUserName + "']"));
        realName.shouldHave(visible);
        SelenideElement userNameMarker = $(By.xpath("//a[text()='" + adminUserName + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        userNameMarker.click();
        userManagement.deleteUser();
        userNameMarker.shouldNotHave(visible);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(3)
    public void testAddJobAndDelete() {
        Job job = new Job();
        String firstJob = "Accountant";
        String secondJob = "Actor";
        String thirdJob = "Advocate";
        basePage.setAdminUserButton()
                .setAdminJobTitleButton();
        job.setAddJobButton()
                .jobDescription(firstJob, "Working with numbers", "Salary 2000$")
                .setSaveJobButton();
        job.setAddJobButton()
                .jobDescription(secondJob, "Creative work", "Salary 2000$")
                .setSaveJobButton();
        job.setAddJobButton()
                .jobDescription(thirdJob, "Solves problems", "Salary 2000$")
                .setSaveJobButton();
        job.clickOnJobFlag(firstJob)
                .clickOnJobFlag(secondJob)
                .clickOnJobFlag(thirdJob)
                .setDeleteJobTitlesButton();
        job.checkTheVisibilityOfWork(firstJob)
                .checkTheVisibilityOfWork(secondJob)
                .checkTheVisibilityOfWork(thirdJob);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(4)
    public void testAddAndDeleteCandidates() {
        Candidates candidates = new Candidates();
        String fullNameCandidate = "Egor Aleksandrov Zalesky";
        basePage.setRecruitmentButton();
        candidates.setAddCandidates()
                .candidateDescription("Egor", "Aleksandrov",
                        "Zalesky", "egor@gmail.com", "+375 (33) 33-00-111",
                        "Engineer", "Important information", "2021-04-01")
                .setSaveCandidates()
                .setBackToCandidates()
                .acceptCandidateOnThePage.shouldHave(visible);
        SelenideElement setOnCandidateFlag = $(By.xpath("//a[text()='" + fullNameCandidate + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        setOnCandidateFlag.click();
        candidates.setDeleteCandidatesButton()
                .setAcceptDeleteCandidatesButton()
                .acceptCandidateOnThePage.shouldNotHave(visible);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Flaky
    @Test
    @Order(5)
    public void testAddAssignLeave() {
        AssignLeave assignLeave = new AssignLeave();
        PersonalDetails personalDetails = new PersonalDetails();
        basePage.setMyInfoButton();
        personalDetails.setEditAllInformationButton();
        basePage.setLeaveButton()
                .setAssignLeaveButton();
        assignLeave.leaveDescription(personalDetails.first_Name + " " + personalDetails.last_Name,
                "2021-09-06", "2021-09-07", "I need a little rest");
        String beforeLeaveBalance = assignLeave.balanceAssingLiave.text();
        assignLeave.setAssignButton()
                .setAcceptAssignButton();
        assignLeave.balanceAssingLiave.shouldNotHave(text(beforeLeaveBalance));
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(6)
    public void testChangePersonalDetails() {
        basePage.setMyInfoButton();
        PersonalDetails personalDetails = new PersonalDetails();
        String lastName = faker.name().lastName();
        String fullNameUserText = personalDetails.fullNameUser.getText();
        personalDetails.setEditAllInformationButton()
                .changePersonalInformation("Anton", lastName, "213", "01",
                        "1", "29", "Boss", "PB",
                        "Important");
        personalDetails.fullNameUser.shouldNotHave(text(fullNameUserText));
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(7)
    public void testAddImmigrationInformation() {
        basePage.setMyInfoButton();
        String number_visa = "2378473";
        Immigration immigration = new Immigration();
        immigration.setImmigrationDetailsButton()
                .setAddImmigrationRecords()
                .fieldEmployee(number_visa, "2021-09-02", "2022-09-01",
                        "True", "2021-09-03", "It's good");
        immigration.setSaveButton()
                .checkingTheAddedVisa(number_visa);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(8)
    public void testAddAndDeleteEmployee() {
        AddEmployee addEmployee = new AddEmployee();
        String firstName = "Jacque";
        String lastName = "Fresco";
        String employeeID = "1313";
        basePage.setPIMButton()
                .setPimAddEmployeeButton();
        addEmployee.fieldEmployee(firstName, lastName, employeeID)
                .setSaveButton()
                .messagePersonalDetails.shouldHave(visible);
        basePage.setPIMEmployeeListButton();
        addEmployee.checkLocatorFlagButtonAndClickOn(lastName)
                .setDeleteButton()
                .setAcceptDeleteButton()
                .CheckRemoteEmployeesByID(employeeID);
    }

    @Owner(value = "Dmitry")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test buy")
    @Test
    @Order(9)
    public void testCorrectEmployeeField() {
        EmployeeList employeeList = new EmployeeList();
        basePage.setPIMButton()
                .setPIMEmployeeListButton();
        String expected_firstName = employeeList.firstNameFirstPeople.getText();
        String expected_lastName = employeeList.lastNameFirstPeople.getText();
        String expected_jobTitle = employeeList.jobTitlePeople.text();
        employeeList.setOpenFirstPeopleButton()
                .firstName.shouldHave(value(expected_firstName));
        employeeList.lastName.shouldHave(value(expected_lastName));
        employeeList.setOpenJobInfoButton()
                .selectedJobTitle.shouldHave(text(expected_jobTitle));
    }

    @Severity(SeverityLevel.NORMAL)
    @Owner(value = "Dmitry")
    @Description("Test for removing items from the cart")
    @Test
    @Order(10)
    public void testCheckingThePresenceOfFields() {
        Dashboard dashboard = new Dashboard();
        basePage.setDashboardButton();
        dashboard.checkLegendPanel()
                .checkQuickLaunch();
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Owner(value = "Dmitry")
    @Description("Test to compare the expected price with the actual")
    @Test
    @Order(11)
    public void testPerformanceConfigureKPIs() {
        Configure configure = new Configure();
        String keyIndicator = "Founder";
        basePage.setPerformanceButton()
                .setPerformanceConfigureButton()
                .setPerformanceKPIButton();
        configure.messageSearchKeyPerformance.shouldHave(text("Search Key Performance Indicators"));
        configure.setAddKeyPerformanceButton()
                .changePersonalInformation(keyIndicator, "1", "99")
                .setSaveButton()
                .messageSearchKeyPerformance.shouldHave(text("Search Key Performance Indicators"));
        SelenideElement keyPerformanceFlag = $(By.xpath("//a[text()='" + keyIndicator + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        keyPerformanceFlag.click();
        configure.setDeleteKeyButton()
                .setAcceptDeleteKeyButton();
        keyPerformanceFlag.shouldNotHave(visible);
    }

    @Test
    @Order(12)
    public void testLogoutTest() {
        Logout logout = new Logout();
        logout.setLogoutButton()
                .welcomeMessageLogin.shouldHave(text("LOGIN Panel"));
    }
}