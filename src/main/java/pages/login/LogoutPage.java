package pages.login;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogoutPage {

    public SelenideElement welcomeMessageLogin = $(By.id("logInPanelHeading"));
    SelenideElement menuWelcomeButton = $(By.id("welcome"));
    SelenideElement logoutButton = $(By.xpath("//*[@id=\"welcome-menu\"]//a[text()='Logout']"));

    @Step("Log out from the page")
    public LogoutPage clickLogoutButton() {
        menuWelcomeButton.click();
        logoutButton.click();
        return this;
    }
}