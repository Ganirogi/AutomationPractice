package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends BasePage{
    protected ShippingPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy (css = ".page-heading") private WebElement shippingTitleShipping;
    @FindBy (css = ".step_current > span:nth-child(1)") private WebElement shippingTextShipping;
    @FindBy (css = ".resume > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(3)") private WebElement shippingTxtShipping;
    @FindBy (css = "div.delivery_option_price") private WebElement shippingTaxShipping;
    @FindBy (id = "cgv") private WebElement checkboxShipping;
    @FindBy (css = ".button-exclusive") private WebElement continueShoppingShipping;
    @FindBy (css = "button.button:nth-child(4) > span:nth-child(1)") private WebElement proceedCheckoutShipping;
    @FindBy (css = ".fancybox-error") private WebElement checkTextNoCheckShipping;
    @FindBy (className = "fancybox-item") private WebElement clickingXShipping;

    public void setCheckBox(){
        Actions check = new Actions(getWebDriver());
        check.pause(2000);
        check.moveToElement(getCheckboxShipping());
        check.click(getCheckboxShipping()).perform();
    }

    public void clickTheX(){
        getClickingXShipping().click();
    }

    public PaymentPage clickProceedToCheckoutPayment(){
        getProceedCheckoutShipping().click();
        return new PaymentPage(getWebDriver());
    }

    public WebElement getShippingTitleShipping() {return shippingTitleShipping;}
    public WebElement getShippingTextShipping() {return shippingTextShipping;}
    public WebElement getShippingTxtShipping() {return shippingTxtShipping;}
    public WebElement getShippingTaxShipping() {return shippingTaxShipping;}
    public WebElement getCheckboxShipping() {return checkboxShipping;}
    public WebElement getContinueShoppingShipping() {return continueShoppingShipping;}
    public WebElement getProceedCheckoutShipping() {return proceedCheckoutShipping;}
    public WebElement getCheckTextNoCheckShipping() {return checkTextNoCheckShipping;}
    public WebElement getClickingXShipping() {return clickingXShipping;}
}
