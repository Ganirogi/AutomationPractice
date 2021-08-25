package Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageCucumber {

    WebDriver driver;

    By txt_username = By.cssSelector("#email");
    By txt_password = By.cssSelector("#passwd");
    By btn_login = By.cssSelector("#SubmitLogin");
    By text_myaccount = By.cssSelector(".page-heading");

    public LoginPageCucumber(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void enterUsernameAndPassword(String username,String password){
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(btn_login).click();
    }

}
