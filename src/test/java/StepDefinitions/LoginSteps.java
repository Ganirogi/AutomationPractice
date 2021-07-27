package StepDefinitions;

import AutomationPractice.CreateOrLogIn;
import AutomationPractice.SignInPage;
import AutomationPractice.YourAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    SignInPage signInPage;
    CreateOrLogIn createOrLogIn;
    YourAccount yourAccount;
    private WebDriver webDriver;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("Browser is open");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @And("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        webDriver.navigate().to("http://automationpractice.com/index.php");
        signInPage = new SignInPage(webDriver);
        signInPage.clickSignIn();

    }

    @When("user enters (.*) and (.*)$")
    public void user_enters_email_and_password(String email, String password) {
        createOrLogIn = new CreateOrLogIn(webDriver);
        createOrLogIn.logIn(email, password);
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        yourAccount = new YourAccount(webDriver);
        yourAccount.getPersonalInformation().isDisplayed();
        webDriver.close();
        webDriver.quit();
    }

}
