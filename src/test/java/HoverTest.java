import AutomationPractice.HoverMainPage;
import AutomationPractice.ProductPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HoverTest extends BaseTest {

    @Test
    public void makeHover() throws InterruptedException {
        goToLandingPage();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,400)");
        HoverMainPage hoverMainPage = new HoverMainPage(getWebDriver());
        hoverMainPage.hoverPage();
        String a = hoverMainPage.getNrFirst().getText();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));
        ProductPage productPage = hoverMainPage.clickMore();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pb-center-column > h1:nth-child(1)")));
        String b = productPage.getNrSecond().getText();
        Assert.assertEquals("Text verify Blouse","Blouse", productPage.getNameBlouse().getText());
        Assert.assertEquals("Text verify Quantity=1","1", productPage.getQuantityAmmount().getAttribute("value"));
        System.out.println("The current value is: " + productPage.getQuantityAmmount().getAttribute("value"));
        boolean x = a.equals(b);
        System.out.println("Are the elements the same?: " + x);
        productPage.makePlusQuantity();
        productPage.makePlusQuantity();
        productPage.makeMinusQuantity();
        productPage.selectSize();
        productPage.pickColorWhite();
        Assert.assertEquals("Text verify Quantity=2","2", productPage.getQuantityAmmount().getAttribute("value"));
        System.out.println("The current value is: " + productPage.getQuantityAmmount().getAttribute("value"));
        productPage.clickAddToCard();
        Thread.sleep(5000);

    }

}
