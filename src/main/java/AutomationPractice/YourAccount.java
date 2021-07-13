package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourAccount extends BasePage{
    public YourAccount(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(className = "icon-building")
    private WebElement myAddresses;

    @FindBy(className = "icon-user")
    private WebElement personalInformation;

    @FindBy(className = "account")
    private WebElement accountName;

    public String getAccountNameText(){
        return getAccountName().getText();
    }

    public MyAddresses clickMyAddresses(){
        getMyAddresses().click();
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.className("page-subheading")));

        return new MyAddresses(getWebDriver());
    }


    public MyPersonalInformation  clickMyPersonalInformation(){
        getPersonalInformation().click();
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        return new MyPersonalInformation(getWebDriver());
    }

    public WebElement getAccountName(){ return accountName; }
    public WebElement getMyAddresses(){ return myAddresses; }
    public WebElement getPersonalInformation(){ return personalInformation; }
}
