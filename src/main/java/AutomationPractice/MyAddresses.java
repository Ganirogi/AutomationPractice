package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAddresses extends BasePage{
    public MyAddresses(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(className = "page-subheading")
    private WebElement aliasAddress;

    public String getAliasAddressText(){
        return getAliasAddress().getText();
    }

    public YourAccount returnToYourAccount(){
        getAccountName().click();
        new WebDriverWait(getWebDriver(),5).until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-building")));

        return new YourAccount(getWebDriver());
    }

    public WebElement getAliasAddress(){ return aliasAddress; }
    public WebElement getAccountName(){ return accountName; }
}
