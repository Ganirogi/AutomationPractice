package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage extends BasePage{
    public AddressesPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy (css = ".page-heading") private WebElement textTitleAddresses;
    @FindBy (css = ".step_current > span:nth-child(1)") private WebElement textAddresses;
    @FindBy (css = "#address_delivery > li:nth-child(2)") private WebElement deliveryNameAddresses;
   /* @FindBy (css = "#address_delivery > li:nth-child(3)") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;
    @FindBy (css = "") private WebElement ;*/
}
