import AutomationPractice.CreateOrLogIn;
import AutomationPractice.MyPersonalInformation;
import AutomationPractice.SignInPage;
import AutomationPractice.YourAccount;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class UpdatePasswordTest extends BaseTest{
    public static final String email = "testaccount123@gmail.com";
    public static final String password = "testpassword";
    public static final String newpassword = "newtestpassword";
    @Test
    public void updatePassword(){
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn(email, password);
        createOrLogIn.getSignInButton().click();
        YourAccount yourAccount=new YourAccount(getWebDriver());
        yourAccount.clickMyPersonalInformation();
        MyPersonalInformation myPersonalInformation=new MyPersonalInformation(getWebDriver());
        myPersonalInformation.updatePassword(password,newpassword,newpassword);
        myPersonalInformation.getSaveButton().click();
        WebElement alertSuccess = getWebDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
        assertEquals("Your personal information has been successfully updated.", alertSuccess.getText());
        myPersonalInformation.returnToYourAccount();
        assertEquals("http://automationpractice.com/index.php?controller=my-account", getWebDriver().getCurrentUrl());

    }
}
