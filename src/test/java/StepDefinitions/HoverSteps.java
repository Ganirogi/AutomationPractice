package StepDefinitions;

import AutomationPractice.FrameProduct;
import AutomationPractice.HoverMainPage;
import AutomationPractice.ProductPage;
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

    @Given("^opening browser and go to the main page$")
    public void openingBrowserAndMainPage(){

        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(getWebDriver(), 5);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        webDriver.get("http://automationpractice.com/index.php");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,400)");
    }

    @When("user selects the black or white blouse and it sets the color, {int} and {word} and {word}")
    public void selectingTheItemsColorQuantityAndSize(Integer quantity,String size,String color){
        mainPage = new HoverMainPage(getWebDriver());
        mainPage.hoverPage();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));
        productPage = mainPage.clickMore();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.exclusive")));
        productPage.selectTheQuantity(quantity);
        productPage.selectSizeOfProduct(size);

        if( color.equals("black")){
            productPage.pickColorBlack();
        } else if (color.equals("white")){
            productPage.pickColorWhite();
        }

        frameProductPage = productPage.clickAddToCard();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn:nth-child(2)")));
        frameProductPage.clickProceedToCheckout();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")));

    }

    @Then("^user finish his order$")
    public void finishOrder(){
        webDriver.quit();
    }
}
