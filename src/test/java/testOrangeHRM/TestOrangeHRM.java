package testOrangeHRM;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import pages.*;
import pages.PIM.EmployeeList;
import pages.admin.Job;
import pages.admin.UserManagement;
import pages.dashboard.Dashboard;
import pages.leave.AssignLeave;
import pages.login.Login;
import pages.login.Logout;
import pages.myInfo.PersonalDetails;
import pages.performance.Configure;
import pages.recruitment.Candidates;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
//        Configuration.headless = true;
        Configuration.startMaximized = true;
        login.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("Dashboard"));
        textAttachment("Annotated", "Здесь очень важная информация!");
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

//    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.BLOCKER)
//    @Description("Login test")
//    @Issue("11")
//    @Link(name = "Admin", url = "https://opensource-demo.orangehrmlive.com/")
    @Test
    @Order(1)
    public void testLoginTest() throws IOException {
        basePage.setSighOutButton();
        login.openLoginPage()
                .singIn()
                .welcomeMessage.shouldHave(text("Dashboard"));
    }

//    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test buy")
//    @Issue("12")
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
        String userNameMarkerLocator = "//a[text()='" + adminUserName + "']/../..//input[@name=\"chkSelectRow[]\"]";
        SelenideElement userNameMarker = $(By.xpath(userNameMarkerLocator));
        userNameMarker.click();
        userManagement.deleteUser();
        userNameMarker.shouldNotHave(visible);
    }

    //    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test buy")
//    @Issue("12")
    @Test
    @Order(3)
    public void testAddJobAndDelete() {
        Job job = new Job();
        basePage.setAdminUserButton()
                .setAdminJobTitleButton();
        job.setAddJobButton()
                .jobDescription("A1", "A1", "A1")
                .setSaveJobButton()
                .welcomeMessage.shouldHave(text("Job Titles"));
        job.setAddJobButton()
                .jobDescription("A2", "A2", "A2")
                .setSaveJobButton()
                .welcomeMessage.shouldHave(text("Job Titles"));
        job.setAddJobButton()
                .jobDescription("A3", "A3", "A3")
                .setSaveJobButton()
                .welcomeMessage.shouldHave(text("Job Titles"));
        job.setDelete();
    }

//    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test buy")
//    @Issue("12")
    @Test
    @Order(4)
    public void testAddAndDeleteCandidates() {
        Candidates candidates = new Candidates();
        String fullNameCandidate = "Egor Aleksandrov Zalesky";
        basePage.setRecruitmentButton();
        candidates.setAddCandidates()
                .candidateDescription("Egor", "Aleksandrov",
                        "Zalesky","egor@gmail.com","+375 (33) 33-00-111",
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



//    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test buy")
//    @Issue("12")
    @Test
    @Order(5)
    public void testAddAssignLeave() {
        AssignLeave assignLeave = new AssignLeave();
        basePage.setLeaveButton()
                .setAssignLeaveButton();
        assignLeave.leaveDescription("Chenzira Chuki","2021-09-06",
                        "2021-09-07","I need a little rest");
//                .setAssignButton();
//                .checkMessageOverlappingLeave("Overlapping Leave Request Found");
        String beforeLeaveBalance = assignLeave.balanceAssingLiave.text();
        assignLeave.setAssignButton()
                .setAcceptAssignButton();
        assignLeave.balanceAssingLiave.shouldHave(text(beforeLeaveBalance));
//        assignLeave.messageOfSizeDate.filter(visible).shouldHave(CollectionCondition.size(1));
    }

//    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test buy")
//    @Issue("12")
    @Test
    @Order(6)
    public void testChangePersonalDetails() {
        PersonalDetails personalDetails = new PersonalDetails();
        String lastName = faker.name().lastName();
        basePage.setMyInfoButton();
        String fullNameUserText = personalDetails.fullNameUser.getText();
        personalDetails.setEditAllInformationButton()
                .changePersonalInformation("Anton",lastName,"213","01",
                        "1","29")
                .setSaveButton();
        personalDetails.fullNameUser.shouldNotHave(text(fullNameUserText));
    }

//    @Owner(value = "Dmitry")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test buy")
//    @Issue("12")
    @Test
    @Order(7)
    public void testCorrectByOder() {
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

    @Test
    @Order(8)
    public void testCheckingThePresenceOfFields() {
        Dashboard dashboard = new Dashboard();
        basePage.setDashboardButton();
        dashboard.notAssignedToSubunits.shouldHave(visible);
        dashboard.administration.shouldHave(visible);
        dashboard.clientServices.shouldHave(visible);
        dashboard.engineering.shouldHave(visible);
        dashboard.finance.shouldHave(visible);
        dashboard.humanResources.shouldHave(visible);
        dashboard.salesMarketing.shouldHave(visible);
    }

    @Test
    @Order(9)
    public void testPerformanceConfigureKPIs() {
        Configure configure = new Configure();
        String keyIndicator = "Founder";
        basePage.setPerformanceButton()
                .setPerformanceConfigureButton()
                .setPerformanceKPIButton();
        configure.messageSearchKeyPerformance.shouldHave(text("Search Key Performance Indicators"));
        configure.setAddKeyPerformanceButton()
                .changePersonalInformation(keyIndicator,"1","99")
                .setSaveButton()
                .messageSearchKeyPerformance.shouldHave(text("Search Key Performance Indicators"));
        SelenideElement keyPerformanceFlag = $(By.xpath("//a[text()='" + keyIndicator + "']/../..//input[@name=\"chkSelectRow[]\"]"));
        keyPerformanceFlag.click();
        configure.setDeleteKeyButton()
                .setAcceptDeleteKeyButton();
        keyPerformanceFlag.shouldNotHave(visible);
    }

    @Test
    @Order(10)
    public void testLogoutTest() {
        Logout logout = new Logout();
        logout.setLogoutButton()
                .welcomeMessageLogin.shouldHave(text("LOGIN Panel"));
    }

//    @Severity(SeverityLevel.MINOR)
//    @Owner(value = "Dmitry")
//    @Description("Purchase cancellation test")
//    @Issue("13")
//    @Test
//    @Order(3)
//    public void testCancelOfBuyingThings() {
//        basketPage.scanTableBody()
//                .setAddAllItemToCartButton();
//        basePage.setBasketButton();
//        basketPage.setCheckoutButton();
//        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
//                .setContinueOrderButton()
//                .setCancelOrderButton();
//        loginPage.welcomeMessage.shouldHave(text("PRODUCTS"));
//    }


//    @Severity(SeverityLevel.NORMAL)
//    @Owner(value = "Dmitry")
//    @Description("Test for removing items from the cart")
//    @Issue("14")
//    @Test
//    @Order(4)
//    public void testDeletingItemsFromTheTrash() {
//        basketPage.scanTableBody()
//                .setAddAllItemToCartButton();
//        basePage.setBasketButton();
//        basketPage.setCancelAllButtonFromCart();
//        basePage.setHomeButton()
//                .shoppingCartBadge.shouldBe(hidden);
//    }


//    @Severity(SeverityLevel.TRIVIAL)
//    @Owner(value = "Dmitry")
//    @Description("Test to compare the expected price with the actual")
//    @Issue("15")
//    @Flaky
//    @Test
//    @Order(5)
//    public void testCheckingTheTotalAmount() {
//        basketPage.scanTableBody()
//                .setAddAllItemToCartButton();
//        basePage.setBasketButton();
//        basketPage.setCheckoutButton();
//        checkoutPage.yourPersonInformation("Oleg", "Oleg", "12345")
//                .setContinueOrderButton()
//                .stringPriceToDouble();
//    }
}