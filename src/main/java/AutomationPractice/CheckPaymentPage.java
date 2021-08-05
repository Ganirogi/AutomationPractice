package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckPaymentPage extends BasePage{
    protected CheckPaymentPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy (css = ".page-heading") private WebElement orderTitleCheck;
    @FindBy (css = ".page-subheading") private WebElement checkPaymentCheck;
    @FindBy (css = "#amount") private WebElement totalPriceCheck;
    @FindBy (css = "button.button-medium > span:nth-child(1)") private WebElement confirmBtnCheck;

    public FinalCheckPage clickConfirmBtnCheck(){
        getConfirmBtnCheck().click();
        return new FinalCheckPage(getWebDriver());
    }

    public WebElement getCheckPaymentCheck() {return checkPaymentCheck;}
    public WebElement getOrderTitleCheck() {return orderTitleCheck;}
    public WebElement getTotalPriceCheck() {return totalPriceCheck;}
    public WebElement getConfirmBtnCheck() {return confirmBtnCheck;}
}
