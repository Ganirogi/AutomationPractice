package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends BasePage{
    public Cart(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(id = "product_price_3_14_538182")
    private WebElement price;

    @FindBy(id = "total_shipping")
    private WebElement shipping;

    @FindBy(id = "total_price")
    private WebElement totalPrice;

    @FindBy(className = "cart_ref")
    private WebElement sku;

    //public String getSkuName(){
   //     return getSku().getText();
    //}

    public String getTotalPay(){
        double price;
        String priceString;
        String removeFirst;
        removeFirst = getPrice().getText().substring(1);
        price = Double.parseDouble(removeFirst) * 3 + Double.parseDouble(getShipping().getText().substring(1));
        priceString =  "$" + String.valueOf(price) + "0";

        return priceString;
    }

    public WebElement getSku(){ return sku; }
    public WebElement getPrice(){ return price; }
    public WebElement getTotalPrice(){ return totalPrice; }
    public WebElement getShipping(){ return shipping; }
}
