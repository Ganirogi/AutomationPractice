package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyPersonalInformation extends BasePage{
    public MyPersonalInformation(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "firstname")
    private WebElement firstName;

    public String getEmailText(){
        return getEmail().getAttribute("value");
    }

    public String getFirstNameText(){
        return getFirstName().getAttribute("value");
    }

    public YourAccount returnToYourAccount(){
        getAccountName().click();
        new WebDriverWait(getWebDriver(),5).until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-user")));

        return new YourAccount(getWebDriver());
    }

    public WebElement getEmail(){ return email; }
    public WebElement getFirstName(){ return firstName; }
    public WebElement getAccountName(){ return accountName; }
}
