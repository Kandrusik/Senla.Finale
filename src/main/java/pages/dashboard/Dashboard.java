package pages.dashboard;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Dashboard {
    String first = "Not assigned to Subunits";
    String admin = "Administration";
    String client_service = "Client Services";
    String engineer = "Engineering";
    String finances = "Finance";
    String human_resources = "Human Resources";
    String sales_and_marketing = "Sales & Marketing";

    public SelenideElement notAssignedToSubunits = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + first + "']"));
    public SelenideElement administration = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + admin + "']"));
    public SelenideElement clientServices = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + client_service + "']"));
    public SelenideElement engineering = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + engineer + "']"));
    public SelenideElement finance = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + finances + "']"));
    public SelenideElement humanResources = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + human_resources + "']"));
    public SelenideElement salesMarketing = $(By.xpath("//*[@class=\"legendLabel\"]/../*[text()='" + sales_and_marketing + "']"));
}