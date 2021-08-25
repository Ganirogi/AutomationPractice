package StepDefinitions;

import Classes.LoginPageCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSteps {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    LoginPageCucumber loginPageCucumber;


    public WebDriver getWebDriver(){ return webDriver; }

@Given("browser is open and user is on login page")
    public void open_browser() {
    System.out.println("Opening browser");
    System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
    webDriver = new ChromeDriver();
    webDriverWait = new WebDriverWait(getWebDriver(), 5);
    webDriver.manage().window().maximize();
    webDriver.manage().deleteAllCookies();

    System.out.println("Going to login page");
    webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
}

@When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password){
    System.out.println("Insert email and password");
    loginPageCucumber = new LoginPageCucumber(webDriver);
    loginPageCucumber.enterUsernameAndPassword(username, password);

}

@And("user clicks on button")
    public void click_login_button(){

    loginPageCucumber = new LoginPageCucumber(webDriver);
    loginPageCucumber.clickLoginButton();
}

@Then("^user navigates to the profile page and (.*)$")
    public void log_successful_go_to_profile(String text){
    System.out.println("User is on my account page");

    loginPageCucumber = new LoginPageCucumber(webDriver);
    String txt = webDriver.findElement(By.cssSelector(".page-heading")).getText();

    if(text.equals(txt)){
        System.out.println("User has successfuly loged in!");
    } else {
        System.out.println("User has not loged in!");
    }

    webDriver.close();
    webDriver.quit();
}

}
