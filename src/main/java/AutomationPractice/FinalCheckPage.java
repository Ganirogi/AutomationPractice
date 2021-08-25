package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalCheckPage extends BasePage{
    protected FinalCheckPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy (css = ".page-heading") private WebElement titleFinalCheck;
    @FindBy (css = "span.price:nth-child(2) > strong:nth-child(1)") private WebElement lastPriceCheckFinalCheck;

    public WebElement getTitleFinalCheck() {return titleFinalCheck;}
    public WebElement getLastPriceCheckFinalCheck() {return lastPriceCheckFinalCheck;}
}
