package AutomationPractice;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
