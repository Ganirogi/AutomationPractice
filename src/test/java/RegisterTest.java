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
        createOrLogIn.emailVerification("dinugv94@gmail.com");
        AccountInfo accountInfo = createOrLogIn.clickCreateAccount();
        accountInfo.completeRegisterForm("Giorgian Vasile", "Dinu", "P4ssword!", "17779 HACIENDA BLVD , CALIFORNIA CITY, CA", "California City", "93505", "6613909725", "5759 HIGHWAY 58,CALIFORNIA CITY");
        YourAccount yourAccount = accountInfo.clickRegister();
        Assert.assertEquals("Account name","Giorgian Vasile Dinu", yourAccount.getAccountNameText());
    }
}
