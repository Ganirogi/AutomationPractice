package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CasualDresses extends BasePage{
    public CasualDresses(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]")
    private WebElement printedDress;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]")
    private WebElement productBlock;

    public QuickView clickQuickView(){
        Actions action = new Actions(webDriver);
        action.moveToElement(getProductBlock()).build().perform();
        new WebDriverWait(getWebDriver(),5).until(ExpectedConditions.visibilityOf(getPrintedDress()));
        getPrintedDress().click();

        return new QuickView(getWebDriver());
    }

    public WebElement getPrintedDress(){ return printedDress; }
    public WebElement getProductBlock(){ return productBlock; }

}
