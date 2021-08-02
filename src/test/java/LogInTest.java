import AutomationPractice.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogInTest extends BaseTest {
    public static final String email = "testaccount123@gmail.com";
    public static final String password = "testpassword";


    @Test
    public void logInSucces() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn(email, password);
        YourAccount yourAccount = createOrLogIn.signIn();
        Assert.assertEquals("Account name", "test test", yourAccount.getAccountNameText());
        MyAddresses myAddresses = yourAccount.clickMyAddresses();
        Assert.assertEquals("Adress test", "HOME", myAddresses.getAliasAddressText());
        YourAccount yourAccount1 = myAddresses.returnToYourAccount();
        MyPersonalInformation myPersonalInformation = yourAccount1.clickMyPersonalInformation();
        Assert.assertEquals("FirstName test", "test", myPersonalInformation.getFirstNameText());
        Assert.assertEquals("Email test", email, myPersonalInformation.getEmailText());
    }

    @Test
    public void logInFail() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn("abc12345@gmail.com", "abc12345");
        createOrLogIn.getSignInButton().click();
        assertEquals("Authentication failed.", createOrLogIn.getAlertDanger().getText());
    }

    @Test
    public void logInInvalidEmail() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn("abc12345", "abc12345");
        createOrLogIn.getSignInButton().click();
        assertEquals("Invalid email address.", createOrLogIn.getAlertDanger().getText());
    }

    @Test
    public void logInWrongPassword() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn(email, "test");
        createOrLogIn.getSignInButton().click();
        assertEquals("Invalid password.", createOrLogIn.getAlertDanger().getText());
    }

    @Test
    public void logInEmptyPassword() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn(email, "");
        createOrLogIn.getSignInButton().click();
        assertEquals("Password is required.", createOrLogIn.getAlertDanger().getText());
    }

    @Test
    public void logInEmptyEmail() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn("", password);
        createOrLogIn.getSignInButton().click();
        assertEquals("An email address required.", createOrLogIn.getAlertDanger().getText());
    }

    @Test
    public void logInEmptyFields() {
        goToLoadingPage();
        SignInPage signIn = new SignInPage(getWebDriver());
        CreateOrLogIn createOrLogIn = signIn.clickSignIn();
        createOrLogIn.logIn("", "");
        createOrLogIn.getSignInButton().click();
        assertEquals("An email address required.", createOrLogIn.getAlertDanger().getText());
    }
}
