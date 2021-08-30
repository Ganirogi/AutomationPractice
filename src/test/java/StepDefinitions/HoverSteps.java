package StepDefinitions;

import AutomationPractice.*;
import Classes.LoginPageCucumber;
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

public class HoverSteps {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    HoverMainPage mainPage;
    ProductPage productPage;
    SummaryPage summaryPage;
    CreateOrLogIn createOrLogIn;
    LoginPageCucumber loginPageCucumber;
    AddressesPage addressesPage;
    ShippingPage shippingPage;
    FrameProduct frameProduct;
    PaymentPage paymentPage;
    FinalCheckPage finalCheckPage;



    public WebDriver getWebDriver(){ return webDriver; }

    @Given("^opening browser and go to the main page$")
    public void openingBrowserAndMainPage(){
        System.out.println("#############################\nInitiate the Test!\n#############################");
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(getWebDriver(), 5);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        System.out.println("#############################\nGo to our testing page\n#############################");
        webDriver.get("http://automationpractice.com/index.php");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,400)");
    }

    @When("user selects the black or white blouse and it sets the color, {int} and {word} and {word}")
    public void selectingTheItemsColorQuantityAndSize(Integer quantity,String size,String color){
        System.out.println("Selecting the black blouse by hover over it");
        mainPage = new HoverMainPage(getWebDriver());
        mainPage.hoverPage();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#homefeatured > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));
        productPage = mainPage.clickMore();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.exclusive")));
        productPage.selectTheQuantity(quantity);
        productPage.selectSizeOfProduct(size);

        System.out.println("Choosing the color");
        if( color.equals("black")){
            productPage.pickColorBlack();
        } else if (color.equals("white")){
            productPage.pickColorWhite();
        }

        frameProduct = productPage.clickAddToCard();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")));
        summaryPage = frameProduct.clickProceedToCheckout();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")));

        System.out.println("Verify the color and what order we need to make");
        if( color.equals("black")) {
            Assert.assertEquals("Verify Nr of Products", "3 Products", summaryPage.getNumberOfProductsSummary().getText());
            Assert.assertEquals("Verify 01. Summary", "01. Summary", summaryPage.getCheckIfSummary().getText());
            Assert.assertEquals("Verify Blouse", "Blouse", summaryPage.getSummaryBlouse().getText());
            Assert.assertEquals("Verify Color,Size", "Color : Black, Size : S", summaryPage.getColorSizeSummary().getText());
            Assert.assertEquals("Verify In Stock", "In stock", summaryPage.getCheckIfStockSummary().getText());
            Assert.assertEquals("Verify Total Products", "$81.00", summaryPage.getCheckTotalProductsSummary().getText());
            Assert.assertEquals("Verify Total Shipping", "$2.00", summaryPage.getCheckTotalShippingSummary().getText());
            Assert.assertEquals("Verify Total", "$83.00", summaryPage.getCheckTotalPriceSummary().getText());
            Assert.assertEquals("Verify Tax", "$0.00", summaryPage.getCheckTaxSummary().getText());
            Assert.assertEquals("Verify TOTAL", "$83.00", summaryPage.getCheckFinalPrice().getText());
        }else if (color.equals("white")){
            Assert.assertEquals("Verify Nr of Products", "2 Products", summaryPage.getNumberOfProductsSummary().getText());
            Assert.assertEquals("Verify 01. Summary", "01. Summary", summaryPage.getCheckIfSummary().getText());
            Assert.assertEquals("Verify Blouse", "Blouse", summaryPage.getSummaryBlouse().getText());
            Assert.assertEquals("Verify Color,Size", "Color : White, Size : M", summaryPage.getColorSizeSummary().getText());
            Assert.assertEquals("Verify In Stock", "In stock", summaryPage.getCheckIfStockSummary().getText());
            Assert.assertEquals("Verify Total Products", "$54.00", summaryPage.getCheckTotalProductsSummary().getText());
            Assert.assertEquals("Verify Total Shipping", "$2.00", summaryPage.getCheckTotalShippingSummary().getText());
            Assert.assertEquals("Verify Total", "$56.00", summaryPage.getCheckTotalPriceSummary().getText());
            Assert.assertEquals("Verify Tax", "$0.00", summaryPage.getCheckTaxSummary().getText());
            Assert.assertEquals("Verify TOTAL", "$56.00", summaryPage.getCheckFinalPrice().getText());
        }

        createOrLogIn = summaryPage.clickProccedToCheckoutToLogin();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
    }

    @And("user now must login with {word} and {word} to continue")
    public void insertingCredentials(String username, String password){

        System.out.println("Inserting credentials username and password");
        loginPageCucumber = new LoginPageCucumber(webDriver);
        loginPageCucumber.enterUsernameAndPassword(username, password);

        addressesPage = loginPageCucumber.clickLoginButton();
        System.out.println("Login successful!");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
    }

    @Then("^user finish his order$")
    public void finishOrder(){
        System.out.println("We are now on Addresses Page");
        // Addresses Page
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button:nth-child(4) > span:nth-child(1)")));
        Assert.assertEquals("Verify Names are the same", addressesPage.getDeliveryNameAddresses().getText(), addressesPage.getBillingNameAddresses().getText());
        Assert.assertEquals("Verify Company are the same", addressesPage.getDeliveryCompanyAddresses().getText(), addressesPage.getBillingCompanyAddresses().getText());

        shippingPage = addressesPage.clickProccedtoCheckoutShipping();

        System.out.println("We are now on Shipping Page");
        // Shipping Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        paymentPage = shippingPage.clickProceedToCheckoutPayment();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fancybox-item")));
        shippingPage.clickTheX();
        shippingPage.setCheckBox();
        paymentPage = shippingPage.clickProceedToCheckoutPayment();

        System.out.println("We are now on Payment Page");
        // Payment Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        Assert.assertEquals("Checking Page", "PLEASE CHOOSE YOUR PAYMENT METHOD", paymentPage.getPaymentTitlePayment().getText());
        CheckPaymentPage checkPaymentPage = paymentPage.clickPayByCheck();

        System.out.println("We are now on CheckPayment Page");
        // CheckPayment Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));

        finalCheckPage = checkPaymentPage.clickConfirmBtnCheck();

        System.out.println("We are now on FinalCheck Page");
        // FinalCheck Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));

        System.out.println("End of test!");
        webDriver.quit();
    }
}
