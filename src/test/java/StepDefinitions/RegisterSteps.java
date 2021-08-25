package StepDefinitions;

import AutomationPractice.AccountInfo;
import AutomationPractice.CreateOrLogIn;
import AutomationPractice.SignInPage;
import AutomationPractice.YourAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterSteps {
    SignInPage signInPage;
    CreateOrLogIn createOrLogIn;
    YourAccount yourAccount;
    AccountInfo accountInfo;
    private WebDriver webDriver;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Browser is open");
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @And("user is on register page")
    public void user_is_on_register_page() {
        webDriver.navigate().to("http://automationpractice.com/index.php");
        signInPage = new SignInPage(webDriver);
        signInPage.clickSignIn();
    }

    @When("user enters (.*)$")
    public void user_enters_email(String email) {
        createOrLogIn = new CreateOrLogIn(webDriver);
        createOrLogIn.emailVerification(email);
        createOrLogIn.clickCreateAccount();
    }

    @And("user create account")
    public void user_create_account()  {
        accountInfo = new AccountInfo(webDriver);
        accountInfo.completeRegisterForm("test", "test", "testpassword", "17779 HACIENDA BLVD , CALIFORNIA CITY, CA", "California City", "93505", "6613909725", "home");
        accountInfo.clickRegister();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        yourAccount = new YourAccount(webDriver);
        yourAccount.getPersonalInformation().isDisplayed();
        webDriver.close();
        webDriver.quit();
    }
}
