package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrameProduct extends BasePage{
    public FrameProduct(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }
    @FindBy(css = ".layer_cart_product > h2:nth-child(2)") private WebElement greenTitle;
    @FindBy (css = "#layer_cart_product_title") private WebElement textBlouse;
    @FindBy (css = "#layer_cart_product_attributes") private WebElement colorSize;
    @FindBy (css = "#layer_cart_product_quantity") private WebElement checkQuantity;
    @FindBy (css = "#layer_cart_product_price") private WebElement checkTotal;
    @FindBy (css = "span.ajax_cart_quantity:nth-child(1)") private WebElement checkTotalItems;
    @FindBy (css = ".ajax_block_products_total") private WebElement totalSum;
    @FindBy (css = "span.ajax_cart_shipping_cost:nth-child(2)") private WebElement priceShipping;
    @FindBy (css = "span.ajax_block_cart_total:nth-child(2)") private WebElement priceTotal;
    @FindBy (css = ".continue") private WebElement continueShoppingBtn;
    @FindBy (css = "a.btn:nth-child(2)") private WebElement proceedToCheckoutBtn;

    public SummaryPage clickProceedToCheckout(){
        getProceedToCheckoutBtn().click();
        return new SummaryPage(getWebDriver());
    }

    public void continueShopping(){
        getContinueShoppingBtn().click();
    }

    public WebElement getGreenTitle() {return greenTitle;}
    public WebElement getTextBlouse() {return textBlouse;}
    public WebElement getColorSize() {return colorSize;}
    public WebElement getCheckQuantity() {return checkQuantity;}
    public WebElement getCheckTotal() {return checkTotal;}
    public WebElement getCheckTotalItems() {return checkTotalItems;}
    public WebElement getTotalSum() {return totalSum;}
    public WebElement getPriceShipping() {return priceShipping;}
    public WebElement getPriceTotal() {return priceTotal;}
    public WebElement getContinueShoppingBtn() {return continueShoppingBtn;}
    public WebElement getProceedToCheckoutBtn() {return proceedToCheckoutBtn;}
}
