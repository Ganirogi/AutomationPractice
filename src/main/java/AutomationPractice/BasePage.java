package AutomationPractice;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private final WebDriver webDriver;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
