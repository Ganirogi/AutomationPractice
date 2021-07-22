package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPersonalInformation extends BasePage {
    @FindBy(className = "account")
    private WebElement accountName;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "old_passwd")
    private WebElement oldPasswdInput;
    @FindBy(id = "passwd")
    private WebElement passwdInput;
    @FindBy(id = "confirmation")
    private WebElement confirmationPasswdInput;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button")
    private WebElement saveButton;

    public MyPersonalInformation(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    public String getEmailText() {
        return getEmail().getAttribute("value");
    }

    public String getFirstNameText() {
        return getFirstName().getAttribute("value");
    }

    public YourAccount returnToYourAccount() {
        getAccountName().click();
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-user")));

        return new YourAccount(getWebDriver());
    }

    public YourAccount updatePassword(String oldPasswd, String newPasswd, String confirmationPasswd) {
        getOldPasswdInput().sendKeys(oldPasswd);
        getPasswdInput().sendKeys(newPasswd);
        getConfirmationPasswdInput().sendKeys(confirmationPasswd);
        return new YourAccount(getWebDriver());
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getAccountName() {
        return accountName;
    }

    public WebElement getOldPasswdInput() {
        return oldPasswdInput;
    }

    public WebElement getPasswdInput() {
        return passwdInput;
    }

    public WebElement getConfirmationPasswdInput() {
        return confirmationPasswdInput;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
}
