package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class YourAccount extends BasePage{
    public YourAccount(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    Actions action = new Actions(webDriver);

    @FindBy(className = "icon-building")
    private WebElement myAddresses;

    @FindBy(className = "icon-user")
    private WebElement personalInformation;

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
    private WebElement dresses;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
    private WebElement casualDresses;

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

    public void hoverOver(){
        action.moveToElement(getDresses()).build().perform();
    }

    public CasualDresses clickCasualDresses(){
        getCasualDresses().click();

        return new CasualDresses(getWebDriver());
    }

    public WebElement getAccountName(){ return accountName; }
    public WebElement getMyAddresses(){ return myAddresses; }
    public WebElement getPersonalInformation(){ return personalInformation; }
    public WebElement getDresses(){ return dresses; }
    public WebElement getCasualDresses(){ return casualDresses; }

}