package pages.login;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Login {
    SelenideElement loginField = $(By.id("txtUsername"));
    SelenideElement passwordField = $(By.id("txtPassword"));
    public SelenideElement signInButton = $(By.name("Submit"));
    public SelenideElement welcomeMessage = $(By.cssSelector("#content div > h1"));

    @Step("Sing in")
    public Login singIn() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/user.properties"));
        loginField.sendKeys(props.getProperty("user.username"));
        passwordField.sendKeys(props.getProperty("user.password"));
        signInButton.click();
        return this;
    }

    @Step("Open login page")
    public Login openLoginPage() {
        open("https://opensource-demo.orangehrmlive.com/");
        return this;
    }
}