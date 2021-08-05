import AutomationPractice.AccountInfo;
import AutomationPractice.CreateOrLogIn;
import AutomationPractice.SignInPage;
import AutomationPractice.YourAccount;
import org.junit.Assert;
import org.junit.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void register() {
        goToLandingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.emailVerification("testaccount000@gmail.com");
        AccountInfo accountInfo = createOrLogIn.clickCreateAccount();
        accountInfo.completeRegisterForm("test", "test", "testpassword", "17779 HACIENDA BLVD , CALIFORNIA CITY, CA", "California City", "93505", "6613909725", "home");
        YourAccount yourAccount = accountInfo.clickRegister();
        Assert.assertEquals("Account name","test test", yourAccount.getAccountNameText());
    }
}
