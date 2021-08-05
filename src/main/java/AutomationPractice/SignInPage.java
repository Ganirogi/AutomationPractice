package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage {
    @FindBy(className = "login")
    private WebElement login;
//    @FindBy(css = "")
//    private WebElement clickLogin;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public CreateOrLogIn clickSignIn() {
        getSignIn().click();
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.elementToBeClickable(By.id("SubmitCreate")));
        return new CreateOrLogIn(getWebDriver());
    }


    public WebElement getSignIn() {
        return login;
    }

//    public WebElement getLogin() {
//        return clickLogin;
//    }
}
