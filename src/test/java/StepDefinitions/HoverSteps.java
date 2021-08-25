package StepDefinitions;

import AutomationPractice.BasePage;
import AutomationPractice.FrameProduct;
import AutomationPractice.HoverMainPage;
import AutomationPractice.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverSteps  {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    HoverMainPage mainPage;
    ProductPage productPage;
    FrameProduct frameProductPage;



    public WebDriver getWebDriver(){ return webDriver; }

@Given("opening browser and go to the main page")
    public void openingBrowserAndMainPage(){

    System.out.println("Opening browser");
    System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
    webDriver = new ChromeDriver();
    webDriverWait = new WebDriverWait(getWebDriver(), 5);
    webDriver.manage().window().maximize();
    webDriver.manage().deleteAllCookies();

    System.out.println("Going to login page");
    webDriver.get("http://automationpractice.com/index.php");

    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
    JavascriptExecutor jse = (JavascriptExecutor)webDriver;
    jse.executeScript("window.scrollBy(0,400)");
}

@When("user selects the black blouse and it sets the color, no of products and size")
    public void selectingTheItemsColorAndQuantity(){
    mainPage = new HoverMainPage(getWebDriver());
    mainPage.hoverPage();
    String a = mainPage.getNrFirst().getText();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));
    productPage = mainPage.clickMore();
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pb-center-column > h1:nth-child(1)")));
    String b = productPage.getNrSecond().getText();
    Assert.assertEquals("Text verify Blouse ProductPage","Blouse", productPage.getNameBlouse().getText());
    Assert.assertEquals("Text verify Quantity=1","1", productPage.getQuantityAmmount().getAttribute("value"));
    Assert.assertEquals("Expected a = b", a,b);
    productPage.selectTheQuantity("3");
    productPage.selectSizeOfProduct(3);
    productPage.pickColorBlack();
    Assert.assertEquals("Text verify Quantity=2","2", productPage.getQuantityAmmount().getAttribute("value"));
    productPage.clickAddToCard();

    frameProductPage.continueShopping();

    productPage.pickColorWhite();
    productPage.untilOne();
    productPage.selectSizeOfProduct(2);
    productPage.clickAddToCard();

    frameProductPage.clickProceedToCheckout();
    }

    @Then("user finish his order")
    public void finishOrder(){
        webDriver.quit();
    }
}
