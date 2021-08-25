import AutomationPractice.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HoverTest extends BaseTest {

    public static final String email = "dedi.alex.121@gmail.com";
    public static final String password = "parola123";

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
        Assert.assertEquals("Text verify Blouse ProductPage","Blouse", productPage.getNameBlouse().getText());
        Assert.assertEquals("Text verify Quantity=1","1", productPage.getQuantityAmmount().getAttribute("value"));
        Assert.assertEquals("Expected a = b", a,b);
        productPage.makePlusQuantity();
        productPage.makePlusQuantity();
        productPage.makeMinusQuantity();
        productPage.selectSize();
        productPage.pickColorBlack();
        Assert.assertEquals("Text verify Quantity=2","2", productPage.getQuantityAmmount().getAttribute("value"));
        System.out.println("The current value is: " + productPage.getQuantityAmmount().getAttribute("value"));

        // Verify before Checkout

        FrameProduct frameProduct = productPage.clickAddToCard();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ajax_block_cart_total:nth-child(2)")));
        Assert.assertEquals("Verify Blouse", "Blouse", frameProduct.getTextBlouse().getText());
        Assert.assertEquals("Verify color and size" , "Black, M", frameProduct.getColorSize().getText());
        Assert.assertEquals("Verify price" , "$54.00" , frameProduct.getCheckTotal().getText());
        Assert.assertEquals("Verify quantity", "2" , frameProduct.getCheckQuantity().getText());
        Assert.assertEquals("Verify Total Products", "2", frameProduct.getCheckTotalItems().getText());
        Assert.assertEquals("Verify Total Shipping" , "$2.00", frameProduct.getPriceShipping().getText());
        Assert.assertEquals("Verify Total" , "$56.00", frameProduct.getPriceTotal().getText());


        SummaryPage summaryPage = frameProduct.clickProceedToCheckout();

        // Summary Page
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart_title")));
        Assert.assertEquals("Verify Nr of Products", "2 Products", summaryPage.getNumberOfProductsSummary().getText());
        Assert.assertEquals("Verify 01. Summary", "01. Summary", summaryPage.getCheckIfSummary().getText());
        Assert.assertEquals("Verify Blouse", "Blouse", summaryPage.getSummaryBlouse().getText());
        Assert.assertEquals("Verify Color,Size", "Color : Black, Size : M", summaryPage.getColorSizeSummary().getText());
        Assert.assertEquals("Verify In Stock", "In stock", summaryPage.getCheckIfStockSummary().getText());
        Assert.assertEquals("Verify Total Products", "$54.00", summaryPage.getCheckTotalProductsSummary().getText());
        Assert.assertEquals("Verify Total Shipping", "$2.00", summaryPage.getCheckTotalShippingSummary().getText());
        Assert.assertEquals("Verify Total", "$56.00", summaryPage.getCheckTotalPriceSummary().getText());
        Assert.assertEquals("Verify Tax", "$0.00", summaryPage.getCheckTaxSummary().getText());
        Assert.assertEquals("Verify TOTAL", "$56.00", summaryPage.getCheckFinalPrice().getText());

        CreateOrLogIn createOrLogIn = summaryPage.clickProccedToCheckoutToLogin();

        // Inserting corect Credentials to Proceed
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        createOrLogIn.logIn(email, password);
        AddressesPage addressesPage = createOrLogIn.signIn();

        // Addresses Page
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        Assert.assertEquals("Verify Names are the same", addressesPage.getDeliveryNameAddresses().getText(), addressesPage.getBillingNameAddresses().getText());
        Assert.assertEquals("Verify Company are the same", addressesPage.getDeliveryCompanyAddresses().getText(), addressesPage.getBillingCompanyAddresses().getText());

        ShippingPage shippingPage = addressesPage.clickProccedtoCheckoutShipping();

        // Shipping Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        Assert.assertEquals("Verify Page", "SHIPPING", shippingPage.getShippingTitleShipping().getText());
        Assert.assertEquals("Verify TAX", frameProduct.getPriceShipping().getAttribute("value"), shippingPage.getShippingTaxShipping().getAttribute("value"));
        PaymentPage paymentPage1 = shippingPage.clickProceedToCheckoutPayment();
        Assert.assertEquals("Verify Text No Checking", "You must agree to the terms of service before continuing.", shippingPage.getCheckTextNoCheckShipping().getText());
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fancybox-item")));
        shippingPage.clickTheX();

        shippingPage.setCheckBox();
        PaymentPage paymentPage = shippingPage.clickProceedToCheckoutPayment();

        // Payment Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        Assert.assertEquals("Checking Page", "PLEASE CHOOSE YOUR PAYMENT METHOD", paymentPage.getPaymentTitlePayment().getText());
        System.out.println("Blouse Payment: " + paymentPage.getProductTypePayment().getText());

        CheckPaymentPage checkPaymentPage = paymentPage.clickPayByCheck();

        // CheckPayment Page

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        Assert.assertEquals("Cheking Total Price", "$56.00", checkPaymentPage.getTotalPriceCheck().getText());

        FinalCheckPage finalCheckPage = checkPaymentPage.clickConfirmBtnCheck();

        // FinalcheckPage

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".page-heading")));
        Assert.assertEquals("Final Verification", "$56.00", finalCheckPage.getLastPriceCheckFinalCheck().getText());



        Thread.sleep(5000);

    }

}
