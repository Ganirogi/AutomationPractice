package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickView extends BasePage{
    public QuickView(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(id = "add_to_cart")
    private WebElement addToCart;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/p[1]/a[2]")
    private WebElement plus;

    public void increaseNrProducts(){
        new WebDriverWait(getWebDriver(),5).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("fancybox-iframe")));
        new WebDriverWait(getWebDriver(), 5).until(ExpectedConditions.elementToBeClickable(plus));
        getPlus().click();
        getPlus().click();
    }

    public void setChangeSize(String value){
        Select select = new Select(getWebDriver().findElement(By.id("group_1")));
        select.selectByValue(value);
    }

    public PopUpCart clickAddCart() throws InterruptedException {
        getAddToCart().click();
        Thread.sleep(5000);
        getWebDriver().switchTo().defaultContent();
        new WebDriverWait(getWebDriver(),5).until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));

        return new PopUpCart(getWebDriver());
    }

    public WebElement getPlus(){ return plus; }
    public WebElement getAddToCart(){ return addToCart; }
}
