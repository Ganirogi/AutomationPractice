package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage{
    protected PaymentPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy (css = ".page-heading") private WebElement paymentTitlePayment;
    @FindBy (css = "#step_end > span:nth-child(1)") private WebElement paymentPayment;
    @FindBy (css = "p.product-name > a:nth-child(1)") private WebElement productTypePayment;
    @FindBy (css = "td.cart_description > small:nth-child(3) > a:nth-child(1)") private WebElement colorSizePayment;
    @FindBy (css = "#product_price_2_7_538526 > span:nth-child(1)") private WebElement productUnitPricePayment;
    @FindBy (css = "td.cart_quantity > span:nth-child(1)") private WebElement qtyPayment;
    @FindBy (css = "#total_product_price_2_7_538526") private WebElement totalPriceBeforePayment;
    @FindBy (css = "#total_product") private WebElement totalProductsPayment;
    @FindBy (css = "#total_shipping") private WebElement totalShippingPayment;
    @FindBy (css = "#total_price") private WebElement totalPricePayment;
    @FindBy (css = ".cheque") private WebElement payCheckPayment;
    @FindBy (css = ".button-exclusive") private WebElement continueShoppingPayment;

    public CheckPaymentPage clickPayByCheck() {
        getPayCheckPayment().click();
        return new CheckPaymentPage(getWebDriver());
    }

    public WebElement getPaymentTitlePayment() {return paymentTitlePayment;}
    public WebElement getPaymentPayment() {return paymentPayment;}
    public WebElement getProductTypePayment() {return productTypePayment;}
    public WebElement getColorSizePayment() {return colorSizePayment;}
    public WebElement getProductUnitPricePayment() {return productUnitPricePayment;}
    public WebElement getQtyPayment() {return qtyPayment;}
    public WebElement getTotalPriceBeforePayment() {return totalPriceBeforePayment;}
    public WebElement getTotalProductsPayment() {return totalProductsPayment;}
    public WebElement getTotalShippingPayment() {return totalShippingPayment;}
    public WebElement getTotalPricePayment() {return totalPricePayment;}
    public WebElement getPayCheckPayment() {return payCheckPayment;}
    public WebElement getContinueShoppingPayment() {return continueShoppingPayment;}
}
