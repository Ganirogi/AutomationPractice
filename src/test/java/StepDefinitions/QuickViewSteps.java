package StepDefinitions;

import AutomationPractice.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuickViewSteps {

    PopUpCart popUpCart;
    YourAccount yourAccount;
    WebDriver webDriver;

    public WebDriver getWebDriver(){ return webDriver; }

    @Given("openBrowserAndLogInWithCredentials {word} {word}")
    public void openBrowser(String username, String password){
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        webDriver.get("http://automationpractice.com/index.php");
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn(username, password);
        yourAccount = createOrLogIn.clickSignin();
    }

    @When("slectProdusChangeSizeAndQuantity {word}")
    public void selectDress(String marime) throws InterruptedException {
        yourAccount.hoverOver();
        CasualDresses casualDresses = yourAccount.clickCasualDresses();
        QuickView quickView = casualDresses.clickQuickView();
        quickView.increaseNrProducts();
        quickView.setChangeSize(marime);
        popUpCart = quickView.clickAddCart();
    }

    @Then("^goToCheckout$")
    public void goToCheckout(){
        Cart cart = popUpCart.clickProceedToCheckout();
        //Assert.assertEquals("Sku test", "SKU : demo_3" ,cart.getSku().getText());
        //Assert.assertEquals("Total price test", cart.getTotalPay(), cart.getTotalPrice().getText());

        webDriver.quit();
    }
}
