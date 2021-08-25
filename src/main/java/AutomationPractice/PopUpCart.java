package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpCart extends BasePage{
    public PopUpCart(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(),this);
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]")
    private WebElement toCart;

    public Cart clickProceedToCheckout(){
        getToCart().click();
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_title")));

        return new Cart(getWebDriver());
    }

    public WebElement getToCart(){ return toCart; }
}