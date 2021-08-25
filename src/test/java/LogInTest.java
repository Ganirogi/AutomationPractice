import AutomationPractice.*;
import org.junit.Assert;
import org.junit.Test;

public class LogInTest extends BaseTest{

    @Test
    public void logIn() {
        goToLandingPage();

        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn("dinugv94@gmail.com", "P4ssword!");
        YourAccount yourAccount = createOrLogIn.signIn();
        Assert.assertEquals("Account name","Giorgian Vasile Dinu", yourAccount.getAccountNameText());
        MyAddresses myAddresses = yourAccount.clickMyAddresses();
        Assert.assertEquals("Adress test", "5759 HIGHWAY 58,CALIFORNIA CITY", myAddresses.getAliasAddressText());
        yourAccount = myAddresses.returnToYourAccount();
        MyPersonalInformation myPersonalInformation = yourAccount.clickMyPersonalInformation();
        Assert.assertEquals("FirstName test", "Giorgian Vasile", myPersonalInformation.getFirstNameText());
        Assert.assertEquals("Email test", "dinugv94@gmail.com", myPersonalInformation.getEmailText());

    }
}
