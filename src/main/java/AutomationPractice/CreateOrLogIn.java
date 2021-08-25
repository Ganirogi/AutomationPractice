package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrLogIn extends BasePage{
    public CreateOrLogIn(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(id = "email_create")
    private WebElement addEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement buttonCreateAnAccount;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signIn;

    public void emailVerification(String email){
        getAddEmail().sendKeys(email);
    }

    public AccountInfo clickCreateAccount(){
        getButtonCreateAnAccount().click();
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

        return new AccountInfo(getWebDriver());
    }

    public void logIn(String email, String password){
        getEmailAddress().sendKeys(email);
        getPassword().sendKeys(password);
    }

    public AddressesPage signIn(){
        getSignIn().click();
        return new AddressesPage(getWebDriver());
    }

    public YourAccount clickSignin() {
        getSignIn().click();
        return new YourAccount(getWebDriver());
    }

    public WebElement getAddEmail(){ return addEmail; }
    public WebElement getButtonCreateAnAccount(){ return buttonCreateAnAccount; }
    public WebElement getEmailAddress(){ return emailAddress; }
    public WebElement getPassword(){ return password; }
    public WebElement getSignIn(){ return signIn; }
}
