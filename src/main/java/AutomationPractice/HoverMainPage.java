package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoverMainPage extends BasePage{
    public HoverMainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    Actions actions = new Actions(getWebDriver());

    @FindBy(css = "#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    private WebElement hoverBlouse;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/div[2]/a[2]")
    private WebElement clickMore;

    @FindBy (css = "#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > span:nth-child(1)")
    private WebElement nrFirst;


    public void hoverPage(){
        actions.moveToElement(getHoverBlouse()).perform();
    }

    public ProductPage clickMore(){
        getClickMore().click();
        return new ProductPage(getWebDriver());
    }


    public WebElement getHoverBlouse() {return hoverBlouse;}
    public WebElement getClickMore() {return clickMore;}
    public WebElement getNrFirst() {return nrFirst;}
}
