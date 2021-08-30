package Classes;

import AutomationPractice.AddressesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageCucumber {

    WebDriver driver;

    By txt_username = By.cssSelector("#email");
    By txt_password = By.cssSelector("#passwd");
    By btn_login = By.cssSelector("#SubmitLogin");

    public LoginPageCucumber(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void enterUsernameAndPassword(String username,String password){
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
    }

    public AddressesPage clickLoginButton(){
        driver.findElement(btn_login).click();
        return new AddressesPage(driver);
    }

}