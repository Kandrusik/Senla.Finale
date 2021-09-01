package pages.login;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Logout {

    SelenideElement menuWelcomeButton = $(By.id("welcome"));
    SelenideElement logoutButton = $(By.xpath("//*[@id=\"welcome-menu\"]//li[3]/a"));
    public SelenideElement welcomeMessageLogin = $(By.id("logInPanelHeading"));


    @Step("Log out from the page")
    public Logout setLogoutButton() {
        menuWelcomeButton.click();
        logoutButton.click();
        return this;
    }
}